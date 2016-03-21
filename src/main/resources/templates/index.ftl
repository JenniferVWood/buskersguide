[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Buskers Guide"]
    <div class="content" role="main">
          <!-- /content -->


        <br/>${display}
            [#switch display]
                [#case "detail"]
                    [#include "include/details.ftl"]
                    [#break]
                [#default]
                <hr/>
                    [#include "include/submitLocation.ftl" ]
                <hr/>

                    [#include "include/listLocations.ftl" ]
            [/#switch]
    [/@page.pageTemplate]
[/#escape]
