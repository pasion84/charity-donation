<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<h1>strona logowania</h1>
<c:choose>
    <c:when test="${param.error != null}">
        <p>Błędne dane logowania!</p>
    </c:when>
    <c:when test="${param.logout != null}">
        <p>Poprawnie wylogowano</p>
    </c:when>
</c:choose>
<form:form method="post" modelAttribute="data">
    <sec:csrfInput/>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                    placeholder="Enter email"/>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <form:password path="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
<br>
<jsp:include page="footer.jsp"/>