[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#if principal.username == "preview"]
<div id="motd">
    <p><bold>This user ("preview") will be retired soon.  Please click on "sign up" to create a log-in.</bold></p>
</div>
[/#if]
