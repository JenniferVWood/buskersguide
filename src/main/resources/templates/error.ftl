[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
    <h1>Server Error</h1>
    <div>
        [#if restException??]
        Error Fetching Rest Data: ${restException.message}
        [#else]
        Unknown Error
        [/#if]
    </div>

[/#escape]
