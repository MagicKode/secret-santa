<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>SECRET_SANTA</title>
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
</head>
<body>
<div style="text-align: center;">
    <h1>MERRY CHRISTMAS!!</h1>
    <hr>

    <br>
    <form action="${pageContext.request.contextPath}/participant/info" method="get">
        <input style="float:right" type="submit" value="Back"/>
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/generate" method="get">
        <table class="center">
            <th colspan="4">Participants</th>
            <tr>
                <th>First name Last name</th>
                <th>First name Last name</th>
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