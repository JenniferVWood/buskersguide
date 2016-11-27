[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#import "../rating.ftl" as rating]

[#escape x as x?html]
<h2>Details: <i>${location.name}</i></h2>
<p><b>Rating:</b>
    [@rating.addRatingToExisting /]
<i>Add your own rating to the average...</i>
</p
<p><b>Distance:</b> <a href="https://www.google.com/maps/place/${location.latitude?c},${location.longitude?c}">${location.distanceInMeters?abs} km</a>
<br /><i>Bug: everything looks like "0" from here.  The link will take you to the correct map, though.</i>
</p>
<h4>Long Description:</h4>
${location.name}
<h4>Comments:</h4>
<div id="comments-list"></div>


<script src="/js/details.js"></script>
<script language="JavaScript">$(document).ready(buildDetailsPage(${location.locationId}));</script>
[/#escape]
