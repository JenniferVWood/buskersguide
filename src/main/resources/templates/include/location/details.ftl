[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
    <div class="content" role="main">
        Details for ${location.name}

        <div/>

        <h3><div id="location-name">location name</div></h3>

        <img id="location-image" width="100" height="100" src="http://www.underconsideration.com/brandnew/archives/google_2015_logo_detail.png"/>

        <h2><div id="details-long-description">Long Description</div></h2>
        <h2>Comments:</h2>
        <ul>
            <div id="comments-list"></div>
        </ul>
    <script src="/js/details.js"></script>
    <script language="JavaScript">$(document).ready(buildDetailsPage(${location.locationId}));</script>
[/#escape]
