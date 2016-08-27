[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]

<table>
    <tr>
        <td><a href="/">Home</a></td>
        <td><a href="/user"> ${principal.username} </a></td>
        <td><a href="/logout">Log Out</a></td>
    </tr>
</table>

[/#escape]