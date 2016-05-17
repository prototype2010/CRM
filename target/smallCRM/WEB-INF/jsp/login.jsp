<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<form action="/login.php" method="post">
    <fieldset class="loginPassword">
        <legend class="loginPasswordLegend"> Authentication required</legend>
        <br>
        <label class="loginLabel"> Login <input name="login" class="loginPasswordDistance" type="text" required="required" placeholder="Enter your login">  </label> <br>
        <label class="loginLabel"> Password <input name="password" type="password" required="required" placeholder="Enter your password"> </label>
        <label class="loginLabel"> Role  <select name="role" class="roleSelector" required="required">
            <option selected="selected"> </option>
            <c:forEach items="${roles}" var="rl" >
                <option value="${rl.role}"><c:out value="${rl.role}"></c:out> </option>
            </c:forEach>
        </select>
        </label>
        <p class="signInParagraph"> <input class=""  type="submit" value="Sign in"></p>
    </fieldset>
</form>
<p class="errorMessage"><c:out value="${errorMessage}"></c:out> </p>
