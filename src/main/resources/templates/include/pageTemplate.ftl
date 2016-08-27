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
    <body>
    <div class="masthead" role="banner">
        <div class="masthead-hd">
            <p class="masthead-hd-sub">Buskers Guide to the Universe</p>
        </div>
    </div>
        [#include "menu.ftl" /]
    <hr width="30"/>
        [#include "motd.ftl" /]

        [#include "${topLevelTemplate}" /]

    </body>
    </html>
    <script src="/js/bg.js"></script>
    [/#macro]
[/#escape]

