$( document ).ready(function(){
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

/**
 * part 2 of 3 functions for creating locations.
 *
 * Make AJAX POST to record new location.
 *
 * @param o Event.
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

    var that = this;
    $.ajax({
        type: "POST",
        url: "/location/create",
        data: JSON.stringify(locationData),
        contentType: "application/json",
        success: function() {
            that.onCreateLocationSuccess();
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
var onCreateLocationSuccess = function() {
    location.reload(true);
};



var onRequestLocationsNearMe = function() {
    getGeoData(fetchLocationsNearMe, "Sorry, you need to enable GPS in order to find locations near you.")
};


var fetchLocationsNearMe = function(position) {
    var coords = position.coords
    $.ajax({
        dataType: "json",
        url: "/location/near/" + coords.latitude + "/" + coords.longitude + "/2000",
        data: undefined,
        success: renderLocationsNearMe
    });
    return false;
};

/**
 * It seems like there's too much direct definition of html here.
 * But for now, it will do.
 *
 * @param o
 */
var renderLocationsNearMe = function(o) {
    var html = '   <table> <tr> <th>name</th> <th>rating</th>  <th>distance</th></tr>';
    for(var i in o){
        html += '<tr>';
        html += '<td> <a href="/location/details/" + o[i].id>' + o[i].name + '</a></td>';
        html += '<td>' + o[i].averageRating + '</td>';
        html += '<td><a href="https://www.google.com/maps/preview/@>' + o[i].latitude + ',' +o[i].longitude + ',8z"> + ' + o[i].distanceInMeters + ' meters</a></td>';
        html += '</tr>';
    }
    html += '</table>';


    //var tableContent = $('#locationsNearMeTableEntries');
    //tableContent.html(html);
    $('#locationsNearMeTableEntries').replaceWith(html);

};