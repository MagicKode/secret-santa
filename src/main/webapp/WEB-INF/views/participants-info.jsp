<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <!--<meta charset="UTF-8">-->
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
    <h1>SECRET_SANTA</h1>
    <hr>

    <br>
    <form action="/" method="get">
        <input style="float:right" type="submit" value="Home"/>
    </form>
    <br>

    <h4>Participant list</h4>
    <table class="center">
        <th colspan="4">Participants</th>
        <tr>
            <th>First name Last name</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="participant" items="${participants}">
            <tr>
                <td>${participant.firstName} ${participant.lastName}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/get/${participant.id}" method="get">
                        <button type="submit">UPDATE</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/delete/${participant.id}" method="get">
                        <button type="submit">DELETE</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <%--create button--%>
    <form action="${pageContext.request.contextPath}/create" method="get">
        <button type="submit">ADD</button>
    </form>
    <br>
    <%--GENERATE button--%>
    <form action="${pageContext.request.contextPath}/generate" method="get">
        <button type="submit" <%--disabled="${notEnoughParticipants}"--%>>GENERATE</button>
    </form>
</body>
