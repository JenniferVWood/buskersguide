[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Buskers Guide"]
    <div class="content" role="addUser">
        <!-- /content -->
        <hr />
        Add New User

        <form id="createUserForm" onsubmit="return onCreateUser()">
            <table>
                <tr>
                    <td><label for="newUserName">New User Name</label></td>
                    <td><input id="newUserName" type="text" size="15"/></td>
                </tr>
                <tr>
                    <td><label for="newUserPassword">New User Password</label></td>
                    <td><input id="newUserPassword" type="password" size="15"/></td>
                </tr>
                <tr>
                    <td></td><td><input id="createUserBtn" type="submit"/></td>
                </tr>
            </table>
        </form>
        <script>
            var onCreateUser = function(position){
                // submit AJAX

                var user = {
                    userName: document.getElementById("newUserName").value,
                    password: document.getElementById("newUserPassword").value
                };

                var that = this;
                $.ajax({
                    type: "POST",
                    url: "/api/user/create",
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

        </script>
    [/@page.pageTemplate]
[/#escape]