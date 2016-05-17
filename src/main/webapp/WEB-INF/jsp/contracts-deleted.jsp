<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<div class="controlPanel">

    <input class="controlPanelButton" type="button" value="Add new" onclick="location.href='/admin-contracts-new.php'">
    <br/>
    <input class="controlPanelButton" type="button" value="Modify" onclick=""> <br/>
    <input class="controlPanelButton" type="button" value="Recover" onclick=""> <br/>
    <input class="controlPanelButton" type="button" value="Active" onclick="location.href='/admin-contracts.php'"> <br/>
</div>
<div class="dataField">

    <h2 class="tableHeader">Deleted Contracts</h2>
    <table class="commonTable">
        <tr>
            <th class="employeesCheckbox"> </th>
            <th class="textColumn">Company name</th>
            <th class="textColumn">Company info</th>
            <th class="textColumn">Sales to this company</th>
            <th class="textColumn">Sales sum</th>
        </tr>
        <c:forEach items="${agents}" var="ag">
            <tr>
                <td class="employeesCheckbox"><input type="checkbox" > </td>
                <td><c:out value="${ag.name}"></c:out></td>
                <td><c:out value="${ag.info}"></c:out></td>
                <td><c:out value="${ag.sales}"></c:out></td>
                <td><c:out value="${ag.sum}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
