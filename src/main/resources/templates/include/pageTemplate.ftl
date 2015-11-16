[#ftl]
[#escape x as x?html]
[#macro pageTemplate title]
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${title}</title>

    <!-- META DATA -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
    <div class="masthead" role="banner">
        <div class="masthead-hd">
            <h1 class="hdg hdg_1 mix-hdg_extraBold"><a href="/">Buskers Guide</a>
            </h1>
            <p class="masthead-hd-sub">Buskers Guide to the Universe</p>
        </div>
        <div class="masthead-nav" role="navigation">
            <ul>
                <li><a href="/">Login</a>
                </li>
            </ul>
        </div>
    </div>
    <!--- masthead -->
    <div class="wrapper">
    [#nested]
    </div>
    <!-- /wrapper -->
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="/js/bg.js"></script>
[/#macro]
[/#escape]

