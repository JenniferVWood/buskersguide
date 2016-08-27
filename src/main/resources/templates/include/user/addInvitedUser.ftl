[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<div class="content" role="addUser">
    <fieldset>
        <!-- /content -->
        <b>Welcome to the Guide!  We hope it helps, and are grateful for your contributed reviews!</b>
        <form id="createInvitedUserForm" onsubmit="return onCreateInvitedUser()">
            <table>
                <tr>
                    <td><label for="newUserName">User Name</label></td>
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
    </fieldset>



    <script src="/js/userAdmin.js">

[/#escape]