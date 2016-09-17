[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
    [#include "../welcome.ftl" /]
    [#include "listLocations.ftl" /]
    [#if principal.username != "anonymous"]
        [#include "submitLocation.ftl" /]
    [#else]
    <fieldset>
        <h3>Want to help?</h3>
        <p><a href="/invite/guest">Sign up</a> or <a href="/login">log in</a> to rate new locations!</p>
    </fieldset>
    [/#if]
[/#escape]