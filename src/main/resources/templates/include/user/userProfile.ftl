[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<fieldset>
    <p><b>Remaining Invites</b></p>
    <p>To invite a friend to view the Guide, copy any of the following URLs:</p>
    <div id="inviteLinks" />
</fieldset>

<script>fetchInvitesListList();
</script>
[/#escape]