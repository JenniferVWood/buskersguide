[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]

Existing Locations:
<table>
    <th>name</th>
    <th>rating</th>
    <th>coordinates</th>
    [#list locations as l]
    <tr>
        <td>${l.name}</td>
        <td>${l.averageRating}</td>
        <td><a href="https://www.google.com/maps/preview/@>${l.latitude/100000},${l.longitude/100000},8z">${l.latitude/100000}/${l.longitude/100000}</a></td>
    </tr>
    [/#list]
</table>
[/#escape]