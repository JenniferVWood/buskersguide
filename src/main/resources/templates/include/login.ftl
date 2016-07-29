[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#escape x as x?html]
    [@page.pageTemplate "Login or Create User"]
    <form action="/user/login" method="GET">
        <label>Log in with existing user name:<input name="userName" type="text" size="16"></label>
    </form>
    <p/>
    <form action="/user/create" method="GET">
        <label>Create User:<input type="text" name="userName" size="16"></label>
    </form>
    [/@page.pageTemplate]
[/#escape]