<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:form="http://www.w3.org/1999/html">
<head>
    <!--<meta charset="UTF-8">-->
    <title>secretSanta</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <style>
        .button1 {
            border: none;
            border-radius: 20px;
            color: rgb(255, 255, 255);
            padding: 15px 30px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 20px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
        .button1 {
            background-color: #71cdf5;
            color: black;
            border: 2px solid #008CBA;
        }
        .button1:hover {
            background-color: #008CBA;
            color: white;
        }
    </style>
    <style>
        .button2 {
            border: none;
            border-radius: 20px;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 32px;
            margin: 8px 4px;
            cursor: pointer;
        }
        .button2 {
            background-color: rgba(232, 199, 86, 0.53);
            color: black;
            border: 2px solid rgb(124, 99, 9);
        }
        .button2:hover {
            background-color: #c4921d;
            color: white;
        }
    </style>

</head>
<body style="background-color:hsla(47, 43%, 51%, 0.53);">
<div class="container mt-5" >
<%--    <h1 style="color:#f60b0b">SECRET_SANTA</h1>--%>
    <br>
    <form action="${pageContext.request.contextPath}/participant/info" method="get">
        <input style="float:right" class="button2 button2" type="submit" value="Cancel/Back"/>
    </form>


    <hr>
    <h2 style="color:#044265">Choose a participant!</h2>
    <form action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
        First Name: <label><input type="text" name="firstName" value="${participant.firstName}"></label><br>
        <br>
        Last Name: <label><input type="text" name="lastName" value="${participant.lastName}"></label><br>
        <br>
        Email: <label><input type="text" name="email" value="${participant.email}"></label><br>
        <br>
        <input type="hidden" name="id" value="${participant.id}">
        <input class="button1 button1" type="submit" value="UPDATE"/>
    </form>
</div>
</body>
</html>
