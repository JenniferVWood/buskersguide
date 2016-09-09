
var renderInvitesList = function(invites) {
    var baseUrl = window.location.protocol;
    baseUrl += "//" + window.location.hostname;
    if (window.location.port != undefined && window.location.port != '') {
        baseUrl +=":" + window.location.port;
    }
    baseUrl += "/invite/";

    var html = '<table>';
    for (var i in invites) {
            html += '<tr>';
            html += '<td>' + baseUrl + invites[i];
    }
    if (invites.length == 0) {
        html += "<tr><td>No remaining invites, sorry.</td></tr>"
    }
    html += '</table>';

    document.getElementById('inviteLinks').innerHTML = html;
};

var buildProfilePageSegments = function(o) {
    if (o.hasOwnProperty('invites')) {
        renderInvitesList(o.invites);
    } else {
        alert("uh oh...\n" + o);
    }
};

var fetchInvitesListList = function() {
    var that = this;

    $.ajax({
        dataType: "json",
        url: "/api/user/profile",
        data: undefined,
        success: buildProfilePageSegments,
        error: function(e) {
            alert(e.responseText);
        }

    });
    return false;
};

