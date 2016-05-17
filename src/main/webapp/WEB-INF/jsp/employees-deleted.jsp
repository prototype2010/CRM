<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<div class="controlPanel">
    <input class="controlPanelButton" type="button" value="Add new" onclick="location.href='/admin-employees-new.php'">
    <br/>
    <input class="controlPanelButton" type="button" value="Modify" onclick=""> <br/>
    <input class="controlPanelButton" type="button" value="Recover" onclick=""> <br/>
    <input class="controlPanelButton" type="button" value="Active" onclick="location.href='/admin-employees.php'"> <br/>

</div>
<div class="dataField">

    <h2 class="tableHeader"> Deleted Employees List</h2>
    <table class="commonTable">
        <tr>
            <th class="employeesCheckbox"></th>
            <th class="textColumn">Name</th>
            <th class="textColumn">Surname</th>
            <th class="textColumn">Rank</th>
            <th class="textColumn">Sign Date</th>
        </tr>
        <c:forEach items="${employees}" var="emp">
            <tr>
                <td class="employeesCheckbox"><input type="checkbox"></td>
                <td><c:out value="${emp.name}"></c:out></td>
                <td><c:out value="${emp.surname}"></c:out></td>
                <td><c:out value="${emp.rank}"></c:out></td>
                <td><c:out value="${emp.signDate}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

</div>

