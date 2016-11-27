[#ftl]
[#escape x as x?html]
    [#macro pageTemplate topLevelTemplate]
    <!DOCTYPE html>
    <html lang="en" >
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <title>Buskers' Guide To The Universe</title>
        <!-- META DATA -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script type="application/javascript" src="/js/user.js"></script>
        <script type="application/javascript" src="/js/locationRatings.js"></script>
    <body>
    <table>
        <tr>
            <td width="5%"></td>
            <td width="90%">
                <div class="masthead" role="banner">
                    <div class="masthead-hd">
                        <h1>Buskers Guide to the Universe</h1>
                    </div>
                </div>
            </td>
            <td width="5%"></td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="90%">
                [#include "menu.ftl" /]
            </td>
            <td width="5%"></td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="90%">
                [#include "motd.ftl" /]
            </td>
            <td width="5%"></td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="90%">
                [#include "${topLevelTemplate}" /]
            </td>
            <td width="5%"></td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="90%">
                [#include "changelog.ftl" /]
            </td>
            <td width="5%"></td>
        </tr>
        <tr>
            <td width="5%"></td>
            <td width="90%">
                [#include "footer.ftl" /]
            </td>
            <td width="5%"></td>
        </tr>
    </table>
    </body>
    </html>
    <script src="/js/bg.js"></script>
    [/#macro]
[/#escape]

