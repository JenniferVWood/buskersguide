[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]

<p/>
<b>Locations Near Me</b>
<br />
<form id="nearMeForm"">
<label for="searchRadius">Search Radius (in kilometers): </label>
<input id="searchRadius" type="text" size="5" value="2">
<input type="button" value="search" onclick="onRequestLocationsNearMe()"/>
</form>

<p/>
<div id="locationsNearMeTableEntries">

</div>

<script src="/js/locationRatings.js"></script>


[/#escape]