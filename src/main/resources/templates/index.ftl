[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Buskers Guide"]
    <div class="content" role="main">

    </div>
    <!-- /content -->

    Hello, ${userName}

    <hr/>
    [#include "include/submitLocation.ftl" ]
    <hr/>

    [#include "include/listLocations.ftl" ]
    [/@page.pageTemplate]
[/#escape]
