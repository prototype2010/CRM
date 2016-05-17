<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<div class="controlPanel">
  <input  class="controlPanelButtonHirarchy" type="button" value="Make CEO" onclick=""> <br/>
  <input class="controlPanelButtonHirarchy" type="button" value="Make Manager" onclick=""> <br/>
  <input class="controlPanelButtonHirarchy" type="button" value="Make Clerk" onclick=""> <br/>
</div>
<div class="dataField">

  <h2 class="tableHeader">Top-rank</h2>

  <table class="commonTable">
    <tr>
      <th class="employeesCheckbox"> </th>
      <th class="textColumn">Surname</th>
      <th class="textColumn">Name</th>
      <th class="textColumn">Rank</th>
      <th class="textColumn">Bonus</th>
    </tr>
    <c:forEach items="${ceos}" var="c" >
    <tr>
      <td class="employeesCheckbox"><input type="checkbox"> </td>
      <td><c:out value="${c.surname}"></c:out></td>
      <td><c:out value="${c.name}"></c:out></td>
      <td><c:out value="${c.rank}"></c:out></td>
      <td><c:out value="${c.bonus}"></c:out></td>
    </tr>
    </c:forEach>
  </table>

  <h2 class="tableHeader">Managers</h2>

  <table class="commonTable">
    <tr>
      <th class="employeesCheckbox"> </th>
      <th class="textColumn">Surname</th>
      <th class="textColumn">Name</th>
      <th class="textColumn">Rank</th>
      <th class="textColumn">Bonus</th>
    </tr>
    <c:forEach items="${managers}" var="m" >
      <tr>
        <td class="employeesCheckbox"><input type="checkbox"> </td>
        <td><c:out value="${m.surname}"></c:out></td>
        <td><c:out value="${m.name}"></c:out></td>
        <td><c:out value="${m.rank}"></c:out></td>
        <td><c:out value="${m.bonus}"></c:out></td>
      </tr>
    </c:forEach>
  </table>

  <h2 class="tableHeader">Clerks</h2>

  <table class="commonTable">
    <tr>
      <th class="employeesCheckbox"> </th>
      <th class="textColumn">Surname</th>
      <th class="textColumn">Name</th>
      <th class="textColumn">Rank</th>
      <th class="textColumn">Bonus</th>
    </tr>
    <c:forEach items="${clerks}" var="cl" >
      <tr>
        <td class="employeesCheckbox"><input type="checkbox"> </td>
        <td><c:out value="${cl.surname}"></c:out></td>
        <td><c:out value="${cl.name}"></c:out></td>
        <td><c:out value="${cl.rank}"></c:out></td>
        <td><c:out value="${cl.bonus}"></c:out></td>
      </tr>
    </c:forEach>

  </table>
  <form action="/admin-hierarchy.php" method="post">
    <fieldset class="hirarchyMotivationPanel">
      <legend>
        Motivation control panel, %
      </legend>
      <p class="motivationLine">CEO<input name="ceo" class="motivationInput" type="number" min="0" max="100" step="0.01" value="${ceo}"></p>
      <p class="motivationLine">Managers<input name="manager" class="motivationInput" type="number"  min="0" max="100" step="0.01" value="${manager}"></p>
      <p class="motivationLine">Clerks<input name="clerk" class="motivationInput" type="number" min="0" max="100" step="0.01" value="${clerk}"></p>
      <p class="changeMotivationButton"><input  type="submit" value="Change"></p>
    </fieldset>
  </form>
</div>

