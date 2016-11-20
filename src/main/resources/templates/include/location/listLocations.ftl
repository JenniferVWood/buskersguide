[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
<fieldset xmlns="http://www.w3.org/1999/html">
    <p><b>Locations Near Me</b></p>
    <p><i>A km is a little more than half a mile.</i></p>
    <form id="nearMeForm">
        <label for="searchRadius">Search Radius (in km): </label>
        <input id="searchRadius" type="text" size="5" value="10">
        <input type="button" value="search" onclick="onRequestLocationsNearMe()"/>
    </form>
    <div id="locationsNearMeTableEntries">

    </div>

    <script src="/js/locationRatings.js"></script>
</fieldset>

[/#escape]