<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to happy sales :)</title>
    <link rel="stylesheet" href="/resources/css/css.css"/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<header>
    <div>
        <h1 class="headerText">Happy sales company :)</h1>

        <p class="headerButtonsBlock">


            <%--//TODO  BUTTONS ON ROLE--%>


            <input type="button" value="Sales" class="headerButton" onclick="location.href='/admin-sales.php'">
            <input type="button" value="Employees" class="headerButton" onclick="location.href='/admin-employees.php'">
            <input type="button" value="Expenses" class="headerButton" onclick="location.href='/admin-expenses.php'">
            <input type="button" value="Salary" class="headerButton" onclick="location.href='/admin-salary.php'">
            <input type="button" value="Statistics" class="headerButton"
                   onclick="location.href='/admin-statistics.php'">
            <input type="button" value="Hierarchy" class="headerButton" onclick="location.href='/admin-hierarchy.php'">
            <input type="button" value="Contracts" class="headerButton" onclick="location.href='/admin-contracts.php'">
            <input type="button" value="Summary" class="headerButton" onclick="location.href='/admin-summary.php'">
            <input type="button" value="Logout" class="headerButton" onclick="location.href='/admin-logout.php'">
        </p>
    </div>
</header>
<div class="invisibleBlock"></div>


<jsp:include page="${currentPage}"></jsp:include>


<footer class="footer">
    <p class="footerText">All rights reserved. "Happy sales" is registered trademark ®. To contact the owner call
        +38-066-254-26-15 </p>
</footer>
</body>
</html>
