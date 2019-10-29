<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<body>
<form:form method="post" modelAttribute="reg">
    <p>
        Email: <form:input path="email" type="email"/>
        <form:errors path="email"/>
    </p>
    <p>
        Haslo: <form:password path="password"/>
        <form:errors path="password"/>
    </p>
    <p>
        Powtórz hasło: <form:password path="rePassword"/>
        <form:errors path="rePassword"/>
    </p>
    <p>
        Imie: <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </p>
    <p>
        Nazwisko: <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </p>
    <p>
        Nr telefonu: <form:input path="phone"/>
        <form:errors path="phone"/>
    </p>
    <p>
        Rola:
        <form:select path="role">
            <form:option value="ROLE_ADMIN">ADMIN</form:option>
            <form:option value="ROLE_USER">USER</form:option>
        </form:select>
        <form:errors path="role"/>
    </p>

    <p>
        <input type="submit" value="Zarejestruj">
        <input type="reset" value="Wyczysc">
    </p>
</form:form>
<br>
</body>
<jsp:include page="footer.jsp"/>