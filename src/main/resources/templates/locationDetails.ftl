[#ftl]
[#import "spring.ftl" as spring/]
[#import "include/pageTemplate.ftl" as page]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<script type="application/javascript" src="/js/user.js"></script>
Template for things to come....
    [@page.pageTemplate "location/details/details.ftl" /]
[/#escape]
