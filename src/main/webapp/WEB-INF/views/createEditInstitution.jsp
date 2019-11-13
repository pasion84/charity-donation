<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            dodaj instytucję/zaktualizuj dane instytucji
        </h1>

    </div>
</div>
</header>
<br>
<section class="nav--actions" style="font-size: large">
    <div class="description">
        <form:form method="post" modelAttribute="institutionFormDTO">
            <form:hidden path="id" value="${institutionFormDTO.id}"/>
            <h2>${institutionFormDTO.id}</h2>
            <div class="title">
                <p class="description">
                    Name: <form:input path="name"/>
                    <form:errors path="name"/>
                </p>
            </div>
            <div class="title">

                <p class="description">
                    Description: <form:input path="description"/>
                    <form:errors path="description"/>
                </p>
            </div>
            <div class="title">
                <p>
                    <input type="submit" value="Dodaj/Zaktualizuj">
                    <input type="reset" value="Wyczysc">
                </p>
            </div>
        </form:form>
    </div>
</section>
<jsp:include page="footer.jsp"/>