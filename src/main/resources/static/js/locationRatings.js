$( document ).ready(function(){

    $("#nearMeForm").keypress(
        function(event){
            if (event.which == '13') {
                event.preventDefault();
                onRequestLocationsNearMe();
            }
        });

    onRequestLocationsNearMe();
});

var getGeoData = function(success, failureMessage) {
    var options = {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
    };

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(success, function() {alert("error");}, options);
    } else {
        alert(failureMessage);
    }
};





var addRatingToExistingLocation = function() {
    var rating = $('#addRatingToExisting select[name=rating]').val();
    var locationId = $('#addRatingToExisting input[name=locationId]').val();

    var that = this;
    $.ajax({
        type: "POST",
        url: "/api/location/rate/" + locationId + "/" + rating,
        // data: JSON.stringify(locationData),
        contentType: "application/json",
        success: function() {
            that.reloadCurrentPage();
        },
        error: function(e) {
            alert(e.responseText);
        }
    });

    return false;
}







/**
 * Click event handler for createLocation button.
 *
 * Part 1 of 3 functions for creating a location
 * @returns {boolean}
 */
var onSubmitLocation = function() {
    getGeoData(saveLocation, "Sorry, you need to enable GPS in order to submit a locaiton.")
    return false;
};


var onSubmitLocationManual = function() {
    var locationData = {
        //$('#locationForm').serializeArray()
        name: $('#manualLocationForm input[name=name]').val(),
        rating: $('#manualLocationForm select[name=rating]').val(),
        latitude: $('#manualLocationForm input[name=latitude]').val(),
        longitude:$('#manualLocationForm input[name=longitude]').val(),
    };

    sendSaveLocationRequest(locationData);
    return false;
};


/**
 * part 2 of 3 functions for creating locations.
 *
 * Make AJAX POST to record new location.
 *
 * @param position location data.
 */
var saveLocation = function(position){
    // submit AJAX

    var foo = $('#locationForm');
    var locationData = {
        //$('#locationForm').serializeArray()
        name: $('#locationForm input[name=name]').val(),
        rating: $('#locationForm select[name=rating]').val(),
        latitude: position.coords.latitude,
        longitude:position.coords.longitude
    };

    sendSaveLocationRequest(locationData);
    return false;
};

var sendSaveLocationRequest = function(locationData) {
    var that = this;
    $.ajax({
        type: "POST",
        url: "/api/location/rate",
        data: JSON.stringify(locationData),
        contentType: "application/json",
        success: function() {
            that.reloadCurrentPage();
        },
        error: function(e) {
            alert(e.responseText);
        }
    });

    return false;

};


/**
 * part 3 of 3 functions for creating a new location.
 */
var reloadCurrentPage = function() {
    location.reload(true);
};



var onRequestLocationsNearMe = function() {
    getGeoData(fetchLocationsNearMe, "Sorry, you need to enable GPS in order to find locations near you.");
    return false;
};


var fetchLocationsNearMe = function(position) {
    // we're still componentizing this page.  For now, if you're on the details page, we don't need this code, but
    // it will get run.  Cludge time!  :-)
    var radiusElement = document.getElementById('searchRadius');
    if (radiusElement != undefined) {
        var radius = radiusElement.value;

        if (typeof radius == "undefined" || radius == '' || radius == 0) {
            radius = 10000;
        } else {
            radius = parseInt(radius) * 1000;
        }

        var coords = position.coords
        $.ajax({
            dataType: "json",
            url: "/api/location/near/" + coords.latitude + "/" + coords.longitude + "/" + radius,
            data: undefined,
            success: renderLocationsNearMe
        });
        return false;
    }
};

/**
 * It seems like there's too much direct definition of html here.
 * But for now, it will do.
 *
 * In true JSP fashion, could we do this in the template instead?
 *
 * @param o
 */
var renderLocationsNearMe = function(o) {
    var html = '   <table> <tr> <th>name</th> <th>rating</th>  <th>distance</th></tr>';
    for(var i in o){
        var distance = (Math.abs(o[i].distanceInMeters) / 1000).toFixed(2);
        var ratingWholeNum = Math.round(o[i].averageRating);
        html += '<tr>';
        html += '<td> <a href="/render/location/detail/' + o[i].locationId + '">' + o[i].name + '</a></td>';
        html += '<td>' + ratingWholeNum + '</td>';
        html += '<td><a href="https://www.google.com/maps/place/' + o[i].latitude + ',' +o[i].longitude + '"> + ' + distance + ' km</a></td>';
        html += '</tr>';
    }
    html += '</table>';


    //var tableContent = $('#locationsNearMeTableEntries');
    //tableContent.html(html);
    document.getElementById('locationsNearMeTableEntries').innerHTML = html;
};

