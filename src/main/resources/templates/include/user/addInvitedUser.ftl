[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<div class="content" role="addInvitedUser">
        <p><b>Welcome to the Guide!</b></p>
        <p>We hope you find it useful.  And remember -- it works best when you add your own reviews!</p>
    <fieldset>
        <p>Let's get you set up with a new username and password.</p>
        <form id="createInvitedUserForm" action="/invite/consume/${inviteId}" method="post">
            <table>
                <tr>
                    <td align="right"><label for="newUserName">New User Name</label></td>
                    <td align="left"><input name="newUserName" id="newUserName" type="text" size="15"/></td>
                </tr>
                <tr>
                    <td align="right"><label for="newUserPassword">New User Password</label></td>
                    <td align="left"><input name="newUserPassword" id="newUserPassword" type="password" size="15"/> <i>we're not doing that 'retype password' thing yet, so...</i></td>
                </tr>
                <tr>
                    <td></td><td><input id="createUserBtn" type="SUBMIT" value="Create User"/></td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>

[/#escape]