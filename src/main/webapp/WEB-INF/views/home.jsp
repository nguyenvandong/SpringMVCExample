<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Hello world!
    <table>
        <c:forEach items="${lists}" var="item">
        <tr>
            <td>${item.marketName}</td>
            <td>${item.last}</td>
        </tr>
        </c:forEach>
</h1>

<P> The time on the server is ${serverTime}. </P>
</body>
</html>
