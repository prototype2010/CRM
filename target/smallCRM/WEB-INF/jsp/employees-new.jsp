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
    <div class="newSaleBlock">
        <form action="/admin-employees-new.php" method="post">
            <h2 class="tableHeader"> New employee</h2>

            <p class="insideInputField">Name <input name="name" type="text" required="required"
                                                    placeholder="Employee name"></p>

            <p class="insideInputField">Surname <input name="surname" type="text" required="required"
                                                       placeholder="Employee surname"></p>

            <p class="insideInputField">Sign date <input id="datepicker" name="date" type="text" required="required"
                                                         placeholder="Click to set the date"></p>

            <p class="insideInputField">Rank <select class="rankSelect" required="required" name="rank">
                <option selected="selected" value="">Choose rank</option>
                <c:forEach items="${ranks}" var="rn">
                    <option value="${rn.name}"><c:out value="${rn.name}"></c:out></option>
                </c:forEach>
            </select></p>
            <p class="insideInputField"><input type="submit" value="Add new"></p>
        </form>
    </div>
</div>
