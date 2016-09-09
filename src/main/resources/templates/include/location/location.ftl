[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
    [#include "listLocations.ftl" /]
    [#if principal.username != "anonymous"]
        [#include "submitLocation.ftl" /]
    [#else]
    <fieldset>
        <h3><a href="/invite/none">Sign up</a> or <a href="/login">log in</a> to submit new locations.</h3>
    </fieldset>
    [/#if]
[/#escape]