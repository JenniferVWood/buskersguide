[#ftl]
[#import "spring.ftl" as spring/]
[#import "include/pageTemplate.ftl" as page]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<script type="application/javascript" src="/js/user.js"></script>
    [@page.pageTemplate "user/userProfile.ftl" /]

        [#if isAdmin == true]
            [#include "include/user/userAdmin.ftl" /]
        [/#if]
[/#escape]
