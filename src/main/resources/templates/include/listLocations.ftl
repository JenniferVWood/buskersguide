[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]

<p/>
<a href="#" onclick="onRequestLocationsNearMe()">get locations near me</a>
<table>
    <th>name</th>
    <th>rating</th>
    <th>coordinates</th>
    <th>distance</th>
    <div id="locationsNearMeTableEntries">
        <td>no name</td>
        <td>no rating</td>
        <td>no coordinates</td>
        <td>no distance</td>
    </div>
</table>


<p/>
All Locations:
<table>
    <th>name</th>
    <th>rating</th>
    <th>coordinates</th>
    [#list locations as l]
    <tr>
        <td>${l.name}</td>
        <td>${l.averageRating}</td>
        <td><a href="https://www.google.com/maps/preview/@>${l.latitude},${l.longitude},8z">${l.latitude}/${l.longitude}</a></td>
    </tr>
    [/#list]
</table>

[/#escape]