<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

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
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 32px;
            margin: 8px 4px;
            cursor: pointer;
        }
        .button {
            background-color: rgba(232, 199, 86, 0.53);
            color: black;
            border: 2px solid rgb(108, 85, 8);
        }
        .button:hover {
            background-color: #c4921d;
            color: white;
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <h1 style="color:#e71010">MERRY CHRISTMAS !!!</h1>
    <hr>

    <br>
    <form action="${pageContext.request.contextPath}/participant/info" method="get">
        <input style="float:right" class="button button" type="submit" value="Back"/>
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/generate" method="get">
        <table class="center">
            <th colspan="4"><h2 style="color:#277309">Participants</h2></th>
            <tr>
                <th>First / Last name</th>
                <th>First / Last name</th>
            </tr>
            <c:forEach var="assignment" items="${assignments}">
                <tr>
                    <td>${assignment.giver.firstName} ${assignment.giver.lastName}</td>

                    <td>${assignment.taker.firstName} ${assignment.taker.lastName}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>