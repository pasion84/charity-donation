<%@ c:taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>

<jsp:include page="header.jsp"/>
</header>
<sec:authorize access="isAuthenticated()">
<form:form modelAttribute="logout" method="post">
    <input class="nav nav--actions" type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</sec:authorize>
<jsp:include page="footer.jsp"/>