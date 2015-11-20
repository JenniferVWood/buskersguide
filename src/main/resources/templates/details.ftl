[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Buskers Guide"]
    <div class="content" role="main">
        [#if !userName??]
        <h4>Log in to edit page.</h4>
            [#include "login.ftl"]
        </div>
        [#else]
        <!-- /content -->

        Hello, ${userName}

        <div/>
        [/#if]

        <h3>Stub for Details Page</h3>

        <ul>
            <li>Non-logged-in user can view this page</li>
            <li>Logged-in user can edit this page</li>
        </ul>
    [/@page.pageTemplate]
[/#escape]
