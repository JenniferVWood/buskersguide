/*
 * details.js
 *
 * methods for rendering parts of the details page
*/

var detailsPage = function(locationId) {
    fetchLocationDetails(locationId);
};

var buildDetailsPage = function(o) {
    renderComments();
};


var renderComments = function(commentsList) {
    var html = "";
    if (commentsList == undefined || commentsList.size == 0) {
        html += "<i>no comments</i>"
    } else {
        html += '<table> <tr> <th>name</th> <th>Comments:</th> </tr>';
        for(var i in commentsList){
            html += '<tr>';
            html += '<td>' + commentsList[i].text + '</a></td>';
            html += '</tr>';
            html += '</table>';
        }
        html += "</table>";
    }
    $('#location-name').html(html);
};



var fetchLocationDetails = function(locationId) {
    var that = this;
    $.ajax({
        dataType: "json",
        url: "/api/location/detail/" + locationId,
        data: undefined,
        success: that.buildDetailsPage
    });

};
