[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<fieldset>
    <p><b>Generate Invites for a user</b></p>
    <form id="requestInvitesForm" onsubmit="requestInvites()">
        <label for="requestInvitesForUserName">User Name:  </label>
        <input id="requestInvitesForUserName" name="requestInvitesForUserName" type="text" size="16" />
        <input type="submit"/>
    </form>
</fieldset>
[/#escape]