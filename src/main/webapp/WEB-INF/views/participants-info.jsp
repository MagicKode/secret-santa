<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <!--<meta charset="UTF-8">-->
    <title>SECRET_SANTA</title>
    <style>
        body {
            background-color: hsla(47, 43%, 51%, 0.53);
        }
    </style>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
        }
        table.center {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <style>
        .button {
            border: none;
            border-radius: 20px;
            color: rgb(255, 255, 255);
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
    </style>
    <style>
        .button1 {
            border: none;
            border-radius: 40px;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 24px;
            margin: 8px 4px;
            transition-duration: 0.4s;
            cursor: pointer;
        }
        .button1 {
            background-color: #ace836;
            color: black;
            border: 3px solid #4CAF50;
        }
        .button1:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
    <style>
        .button2 {
            background-color: #71cdf5;
            color: black;
            border: 2px solid #008CBA;
        }
        .button2:hover {
            background-color: #008CBA;
            color: white;
        }
        .button3 {
            background-color: #f6aeae;
            color: black;
            border: 2px solid #ba0000;
        }
        .button3:hover {
            background-color: #ba0000;
            color: white;
        }
    </style>
    <style>
        .button4 {
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 32px;
            margin: 8px 4px;
            cursor: pointer;
        }
        .button4 {
            background-color: #caa5e3;
            color: black;
            border: 2px solid rgba(159, 16, 231, 1);
        }
        .button4:hover {
            background-color: rgba(159, 16, 231, 1);
            color: white;
        }
        .button4 {border-radius: 50%;
        }
    </style>
    <style>
        .button5 {
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 32px;
            margin: 8px 4px;
            cursor: pointer;
        }
        .button5 {
            background-color: rgba(232, 199, 86, 0.53);
            color: black;
            border: 2px solid rgb(124, 99, 9);
        }
        .button5:hover {
            background-color: #c4921d;
            color: white;
        }
    </style>

</head>
<body>
<div style="text-align: center;">
    <h1 style="color:#f60b0b">SECRET_SANTA</h1>
    <hr>

    <br>
    <form action="/" method="get">
        <input style="float:right" class="button button5" type="submit" value="Home"/>
    </form>
    <br>

    <h2 style="color:#044265">Participant list</h2>
    <table class="center">
        <th colspan="4"><h2 style="color:#277309">Participants</h2></th>
        <tr>
            <th>First / Last name</th><th>Update</th><th>Delete</th>
        </tr>
        <c:forEach var="participant" items="${participants}">
            <tr>
                <td>${participant.firstName} ${participant.lastName}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/get/${participant.id}" method="get">
                        <button class="button button2" type="submit">UPDATE</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/delete/${participant.id}" method="get">
                        <button class="button button3" type="submit">DELETE</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <%--create button--%>
    <form action="${pageContext.request.contextPath}/create" method="get">
        <button class="button button1" type="submit">ADD</button>
    </form>
    <br>
    <%--GENERATE button--%>
    <form action="${pageContext.request.contextPath}/generate" method="get">
        <button  class="button button4" type="submit" <%--disabled="${notEnoughParticipants}"--%>>GENERATE</button>
    </form>
</body>
