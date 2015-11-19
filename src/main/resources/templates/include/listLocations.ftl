[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]

<p/>
<b><a onclick="onRequestLocationsNearMe()">Locations Near Me</a></b>
<div id="locationsNearMeTableEntries">

</table>
</div>


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