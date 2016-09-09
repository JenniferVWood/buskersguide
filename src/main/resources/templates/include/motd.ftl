[#ftl]
[#assign xhtmlCompliant = true in spring/]
<div id="motd">
    <p><i> This project is obviously a work in progress.  Send feedback/suggestions/rants to info@buskersguidetotheuniverse.org</i></p>
    [#if principal.username == "preview"]
    <p><bold>This user ("preview") will be retired soon.  Please navigate to the 'profile' page to send yourself an invite.</bold></p>
    [/#if]
        <p /><a onclick="toggleDiv('changelog')">[Show/Hide change-log]</a></p>
    <div id="changelog" style="display: none;">
        <ul>
            <li>9/08/16:  Show anonymous users a teaser page...</li>
            <li>8/27/16:  Added user-invite system.  Click on your username in the menu to view available invites.</li>
            <li>8/26/16:  Added a menubar. </li>
            <li>8/17/16:  Select search radius.</i></li>
        </ul>
    </div>
</div>
