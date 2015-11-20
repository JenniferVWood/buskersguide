[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Buskers Guide"]
    <div class="content" role="main">
        [#if !userName??]
            [#include "login.ftl"]
        [#else]

        </div>
        <!-- /content -->

        Hello, ${userName}

        <hr/>
            [#include "include/submitLocation.ftl" ]
        <hr/>

            [#include "include/listLocations.ftl" ]
        [/#if]
    [/@page.pageTemplate]
[/#escape]
