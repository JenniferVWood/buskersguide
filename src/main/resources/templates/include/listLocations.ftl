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
        <td>${l.latitude/10000}/${l.longitude/10000}</td>
    </tr>
    [/#list]
</table>
[/#escape]