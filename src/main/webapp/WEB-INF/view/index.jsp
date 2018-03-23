<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Hello from Vehicles World</h1><br />

<h2>All vehicles</h2><br />

<c:forEach var="vehicle" items="${requestScope.vehicles}">
    <ul>

        <li> <c:out value="${vehicle}"/></li>

    </ul>
    <hr />

</c:forEach>

<h2>Searching</h2><br />

<form method="post" action="">
    <tr>
        <td>Vechicle choice: </td>
        <td>
            <select name = "type">
                <option value = "vehicles">All Vehicles</option>
                <option value = "move">VehicleMove</option>
                <option value = "swim">VehicleSwim</option>
                <option value = "fly">VehicleFly</option>
                <%--<option value = "amfibia">Amfibia</option>--%>
                <%--<option value = "betMobile">BetMobile</option>--%>
            </select>
        </td>
    </tr>
    <br>


    Price: from <label><input type="number" name="priceFrom"></label> to
     <label><input type="number" name="priceTo"></label><br>

    Age: from <label><input type="number" name="ageFrom"></label> to
         <label><input type="number" name="ageTo"></label><br>

    Speed: from <label><input type="number" name="speed"></label><br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
