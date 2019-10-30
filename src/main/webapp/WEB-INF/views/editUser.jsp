<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            zaktualizuj swoje dane<br>
            ${principalIsUser}
        </h1>

    </div>
</div>
</header>
<br>
<section class="nav--actions" style="font-size: large">
    <div class="description">
        <form:form method="post" modelAttribute="editFormDTO">
            <form:hidden path="id"/>
            <div class="title">
                <p class="description">
                    Email: <form:input path="email" type="email"/>
                    <form:errors path="email"/>
                </p>
            </div>
            <div class="title">

                <p class="description">
                    Haslo: <form:password path="password"/>
                    <form:errors path="password"/>
                </p>
            </div>
            <div class="title">
                <p class="description">
                    Powtórz hasło: <form:password path="rePassword"/>
                    <form:errors path="rePassword"/>
                </p>
            </div>
            <div class="title">
                <p class="description">
                    Imie: <form:input path="firstName"/>
                    <form:errors path="firstName"/>
                </p>
            </div>
            <div class="title">
                <p class="description">
                    Nazwisko: <form:input path="lastName"/>
                    <form:errors path="lastName"/>
                </p>
            </div>
            <div class="title">
                <p class="description">
                    Nr telefonu: <form:input path="phone"/>
                    <form:errors path="phone"/>
                </p>
            </div>
            <%--    <p>--%>
            <%--        Rola:--%>
            <%--        <form:select path="role">--%>
            <%--            <form:option value="ROLE_ADMIN">ADMIN</form:option>--%>
            <%--            <form:option value="ROLE_USER">USER</form:option>--%>
            <%--        </form:select>--%>
            <%--        <form:errors path="role"/>--%>
            <%--    </p>--%>
            <div class="title">
                <p>
                    <input type="submit" value="Zaktualizuj">
                    <input type="reset" value="Wyczysc">
                </p>
            </div>
        </form:form>
    </div>
</section>
<jsp:include page="footer.jsp"/>