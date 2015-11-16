[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Server Error"]
    <h1>Server Error</h1>
    <div>
        [#if restException??]
        Error Fetching Rest Data: ${restException.message}
        [#else]
        Unknown Error
        [/#if]
    </div>

    [/@page.pageTemplate]
[/#escape]
