

/**
 * Click event handler for createLocation button.
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
        latitude: position.coords.latitude * 10000,
        longitude:position.coords.longitude * 10000
    };

    var that = this;
    $.ajax({
        type: "POST",
        url: "/location/create",
        data: JSON.stringify(locationData),
        contentType: "application/json",
        success: function() {
            that.onSuccess();
        },
        error: function(e) {
            alert(e.responseText);
        }
    });

    return false;
};


var onSubmitLocation = function() {
    var options = {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
    };

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(saveLocation, function() {alert("error");}, options);
    } else {
        alert("Sorry, you need to enable GPS in order to submit a locaiton.");
    }

    return false;
};




var onSuccess = function() {
    //location.reload(true);
};


