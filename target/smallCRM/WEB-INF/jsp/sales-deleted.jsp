<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<script>
  $(function () {
    $("#datepicker").datepicker({
      dateFormat: "yy-mm-dd"
    });
    $("#anim").change(function () {
      $("#datepicker").datepicker("option", "showAnim", $(this).val());
    });
  });
  var context = "${CONTEXT}";
  $(function () {
    $("#datepicker1").datepicker({
      dateFormat: "yy-mm-dd"
    });
    $("#anim").change(function () {
      $("#datepicker").datepicker("option", "showAnim", $(this).val());
    });
  });
  var context = "${CONTEXT}";
</script>

<div class="controlPanel">

  <input class="controlPanelButton" type="button" value="Add new" onclick="location.href='/admin-sales-new.php'">
  <br/>
  <input class="controlPanelButton" type="button" value="Modify" onclick=""> <br/>
  <input class="controlPanelButton" type="button" value="Delete" onclick=""> <br/>
  <input class="controlPanelButton" type="button" value="Active" onclick="location.href='/admin-sales.php'">
  <br/>
</div>
<div class="dataField">

  <h2 class="tableHeader">Deleted Sales</h2>

  <form action="/admin-sales-deleted.php" method="post">
    <p class="dateFilter">
      Load from <input name="lowDate" type="text" id="datepicker1" placeholder="click to set date"
                       required="required"
                       value="${lowDate}"> to
      <input name="highDate" type="text" id="datepicker" placeholder="click to set date" required="required"
             value="${highDate}">
      <input type="submit" value="Load">
    </p>
  </form>
  <table class="commonTable">
    <tr>
      <th class="employeesCheckbox"></th>
      <th class="textColumn">Name</th>
      <th class="textColumn">Surname</th>
      <th class="textColumn">Rank</th>
      <th class="textColumn">Company name</th>
      <th class="textColumn">Amount</th>
      <th class="textColumn">Date</th>
    </tr>
    <c:forEach items="${sales}" var="sl">
      <tr>
        <td class="employeesCheckbox"><input type="checkbox"></td>
        <td><c:out value="${sl.name}"></c:out></td>
        <td><c:out value="${sl.surname}"></c:out></td>
        <td><c:out value="${sl.rank}"></c:out></td>
        <td><c:out value="${sl.agent}"></c:out></td>
        <td><c:out value="${sl.sum}"></c:out></td>
        <td><c:out value="${sl.date}"></c:out></td>
      </tr>
    </c:forEach>
  </table>
</div>