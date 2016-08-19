[#ftl]
[#escape x as x?html]
[#macro pageTemplate title]
<!DOCTYPE html>
<html lang="en" >
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <title>${title}</title>

    <!-- META DATA -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
 <body>
    <div class="masthead" role="banner">
        <div class="masthead-hd">
            <h1 class="hdg hdg_1 mix-hdg_extraBold"><a href="/">Buskers Guide</a>
            </h1>
            <p class="masthead-hd-sub">Buskers Guide to the Universe</p>
        </div>
        <br /><i> Obviously a work in progress.  Send feedback/suggestions/rants to info@buskersguidetotheuniverse.org</i>
    <br /><i>8/17/16:  New: Select search radius.</i>
    <br /><br />
        [#if !userName??]
            <script lang="javascript">var loggedIn = false;</script>
        [#else]
            <script lang="javascript">var loggedIn = true;</script>
            Logged in as: ${userName}
        </div>
        [/#if]

    <div class="masthead-nav" role="navigation">
                 <!--- masthead -->
                <div class="wrapper">
                    [#nested]
                </div>
                <!-- /wrapper -->
        </div>
    </div>
</body>
</html>
<script src="/js/bg.js"></script>
[/#macro]
[/#escape]

