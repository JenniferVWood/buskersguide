
var renderInvitesList = function(invites) {
    var html = '<table>';
    for (var i in invites) {
            html += '<tr>';
            html += '<td>https://buskersguidetotheuniverse.org/invite/' + invites[i];
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

