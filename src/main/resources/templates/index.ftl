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
    [#import "include/submitLocation.ftl" as submitLocation]
    <hr/>

    [/@page.pageTemplate]
[/#escape]
