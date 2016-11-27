[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
[#import "ratingSelect.ftl" as ratingSelect]

[#macro addRatingToExisting]
<div id="addRatingToExisting">
    <form action="post" id="locationForm" name="locationForm" onSubmit="return addRatingToExistingLocation();">
        <input type="hidden" name="locationId" id="locationId" value="${location.locationId?c}" />
        [@ratingSelect.ratingSelectList /]
        <input type="submit" id="addRatingButton" value="update"/>
    </form>
</div>
[/#macro]

<#macro createRatingLocationGPS>
<div i="rateCurrenLocation">
    <b>Rate your current location using your device's GPS:</b>oo
    <form id="locationForm" name="locationForm" onSubmit="return onSubmitLocation(this)">
        <label for="name">Name:</label> <input id="name" name="name" type="text" size="32">
        <br/>
        [@ratingSelect.ratingSelectList /]
        <input type="submit" id="createLocation" value="create"/>
    </form>
</div>
</#macro>

<#macro createRatingLocationManually>
<div id="rateLocationManually">
    <b>Rate a new location manually by entering coordinates:</b>
    <form id="manualLocationForm" name="manualLocationForm" onSubmit="return onSubmitLocationManual(this)">
        <label for="name">Name:</label> <input id="name" name="name" type="text" size="32">
        <br/>
        [@ratingSelect.ratingSelectList /]
        <label for="lattitude">Latitude:</label> <input type="text" size="4" name="latitude"/>
        <label for="longitude">Longitude:</label> <input type="text" size="4" name="longitude"/>
        <input type="submit" id="createLocation" value="rate"/>
    </form>
</div>

</#macro>

[/#escape]