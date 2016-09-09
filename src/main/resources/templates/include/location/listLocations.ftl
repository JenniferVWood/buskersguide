[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<fieldset xmlns="http://www.w3.org/1999/html">
<p><b>Locations Near Me</b></p>
    <p><i>I'm still tweaking the "location resolution", so you may see a few that look pretty close to each other.</i>
    <br /><i>A km is a little more than half a mile.</i></br></p>
<form id="nearMeForm"">
<label for="searchRadius">Search Radius (in km): </label>
<input id="searchRadius" type="text" size="5" value="10">
<input type="button" value="search" onclick="onRequestLocationsNearMe()"/>
</form>
    <hr align = "left" width = "30%" />
<p/>
<div id="locationsNearMeTableEntries">

</div>
    [#if principal.username == "anonymous"]
        If you were logged in, you'd see a list of suitable busking locations near you...
    [/#if]

<script src="/js/locationRatings.js"></script>
</fieldset>

[/#escape]