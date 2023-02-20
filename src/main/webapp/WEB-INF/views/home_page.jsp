<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            background-color: hsl(89, 43%, 51%);
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <h1>SECRET_SANTA</h1>
    <h2>Merry Christmas, ho-ho-ho !!</h2>
    <br/>
    <style type="text/css">
        button[name="_csrf"] {
            border: none;
            border-radius: 7px;
            padding: 10px 25px;
            background: #ff9900;
            cursor: pointer;
            text-transform: uppercase;
            font-weight: bold;
            color: white;
        }

        button[name="_csrf"]:hover {
            background: #ff6600;
        }
    </style>
    <form action="${pageContext.request.contextPath}/participant/info" method="get">
        <button type="submit" name="_csrf">Let's party begin!</button>
    </form>
</div>
</body>
</html>
