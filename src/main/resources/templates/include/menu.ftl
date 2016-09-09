[#ftl]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]

<table>
    <tr>
        <td><a href="/">Home</a></td>
        [#if principal.username != "anonymous"]
            <td><a href="/user"> ${principal.username} </a></td>
        [/#if]
        <td>
            [#if principal.username == "anonymous"]
            <a href="/login">Log In
            [#else]
            <a href="/logout">Log Out
            [/#if]
        </a></td>
    </tr>
</table>

[/#escape]