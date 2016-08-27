[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<div id="userAdmin">
    [#include "requestInvites.ftl" /]
    [#include "addUser.ftl" /]
</div>
<script src="/js/userAdmin.js" ></script>
[/#escape]