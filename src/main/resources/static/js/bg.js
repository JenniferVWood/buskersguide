
//$(document).ready(function () {
//    //alert("hello");
//    // assign listeners to vote buttons.
//    $('#createLocation').submit(
//        function (o) {
//            onCreateLocation(o);
//            o.preventDefault();
//        }
//    )
//});

/**
 * Click event handler for createLocation button.
 *
 * Make AJAX POST to record new location.
 *
 * @param o Event.
 */
function onCreateLocation(o) {
    // submit AJAX

    var foo = $('#locationForm');
    var locationData = {
        //$('#locationForm').serializeArray()
        name: $('#locationForm input[name=name]').val(),
        rating: $('#locationForm select[name=rating]').val(),
        latitude: $('#locationForm input[name=latitude]').val(),
        longitude: $('#locationForm input[name=longitude]').val()
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
    // reload page
    //   - if we had time to get fancy we'd load some JSON and rebuild part of the page.
    //location.reload(true); // true => load from server instead of cache
}

function onSuccess() {
    //location.reload(true);
}


