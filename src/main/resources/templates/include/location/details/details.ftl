[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<h3 align="center">${location.name}</h3>
<h4>Rating:</h4>

<h4>Long Description:</h4>
${location.name}
<h4>Comments:</h4>
<div id="comments-list"></div>


<script src="/js/details.js"></script>
<script language="JavaScript">$(document).ready(buildDetailsPage(${location.locationId}));</script>
[/#escape]
