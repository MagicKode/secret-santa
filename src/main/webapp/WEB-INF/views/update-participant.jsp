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
</head>
<body>
<div class="container mt-5">

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>

    <br>
    <form action="${pageContext.request.contextPath}/participant/info" method="get">
        <input style="float:right" type="submit" value="Cancel/Back"/>
    </form>

    <hr>
    <h3>Choose a participant!</h3>
    <form action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
        First Name: <label><input type="text" name="firstName" value="${participant.firstName}"></label><br>
        <br>
        Last Name: <label><input type="text" name="lastName" value="${participant.lastName}"></label><br>
        <br>
        Email: <label><input type="text" name="email" value="${participant.email}"></label><br>
        <br>
        <input type="hidden" name="id" value="${participant.id}">
        <input type="submit" value="UPDATE"/>
    </form>
</div>
</body>
</html>
