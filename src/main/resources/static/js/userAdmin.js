var onCreateUser = function(position){
    // submit AJAX

    var user = {
        userName: document.getElementById("newUserName").value,
        password: document.getElementById("newUserPassword").value
    };

    var that = this;
    $.ajax({
        type: "POST",
        url: "/api/user/admin/create",
        data: JSON.stringify(user),
        contentType: "application/json",
        success: function() {
            alert("OKAY!");
        },
        error: function(e) {
            alert(e.responseText);
        }
    });

    return false;
};



var requestInvites = function() {
    var userName = document.getElementById("requestInvitesForUserName").value;

    var that = this;
    $.ajax({
        type: "POST",
        url: "/api/user/admin/requestInvites/" + userName,
        data: undefined,
        contentType: "application/json",
        success: function() {
            alert("OKAY!");
        },
        error: function(e) {
            alert(e.responseText);
        }
    });

    return false;
};