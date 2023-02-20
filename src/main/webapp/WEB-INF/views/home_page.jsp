<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SECRET_SANTA</title>
    <style>
        body {
            background-color: hsla(87, 32%, 58%, 0.44);
        }
    </style>
    <style>
        .button {
            border: none;
            color: white;
            padding: 30px 64px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 64px;
            margin: 16px 8px;
            cursor: pointer;
        }
        .button {
            background-color: white;
            color: black;
            border: 2px solid rgb(231, 16, 16);
        }
        .button:hover {
            background-color: rgb(231, 170, 16);
            color: white;
        }
        .button {border-radius: 50%;}
    </style>
</head>
<body>
<div style="text-align: center;">
    <h1 style="color:#f60b0b">SECRET_SANTA</h1>
    <h2 style="color:#35a807">Merry Christmas, ho-ho-ho !!</h2>
    <br/>
    <style type="text/css">
        button[name="_csrf"] {
            border: none;
            border-radius: 20px;
            padding: 40px 80px;
            background: #ff9900;
            cursor: pointer;
            text-transform: uppercase;
            font-weight: bold;
            color: white;
        }

        button[name="_csrf"]:hover {
            background: red;
        }
    </style>
    <form action="${pageContext.request.contextPath}/participant/info" method="get">
        <button class="button button5" type="submit" name="_csrf">Let's party begin!</button>
    </form>
</div>
</body>
</html>
