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
</script>

<div class="controlPanel">


</div>
<div class="dataField">

  <h2 class="tableHeader"> New Sale</h2>
  <form action="admin-sales-new.php" method="post">
    <div class="newSaleBlock">
      <p class="newSateInputField"> Employee <select class="insideSelectField" name="employee">
      <c:forEach var="emp" items="${employees}">
        <option value="${emp.id}"><c:out value="${emp.name}"></c:out> <c:out value="${emp.surname}"></c:out> (<c:out value="${emp.rank}"></c:out>) </option>
      </c:forEach>

      </select>
      </p>
      <p class="newSateInputField"> Company name <select class="insideSelectField" name="agent" required="required" >
      <c:forEach var="ag" items="${agents}" >
        <option value="${ag.id}"><c:out value="${ag.name}"></c:out></option>
      </c:forEach>
      </select>
      </p>
      <p class="newSateInputField"> Amount <input class="insideInputField" type="text" name="sum" required="required"> </p>
      <p class="newSateInputField"> Date <input class="insideInputField" type="text" name="date" id="datepicker" required="required" placeholder="Click to set date"> </p>
      <p class="newSateInputField"> Comment <input class="insideInputField" type="text" name="comment"> </p>
      <p class="newSateInputField"><input  type="submit" value="Add new"></p>

    </div>
  </form>

</div>

