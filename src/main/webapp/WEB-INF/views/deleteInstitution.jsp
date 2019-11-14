<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Uwaga
        </h1>

    </div>
</div>
</header>
<br>
<section class="nav--actions" style="font-size: large">
    <div class="description">
        <form:form method="post" modelAttribute="deleteInstitutionFormDTO">
            <form:hidden path="id" value="${deleteInstitutionFormDTO.id}"/>
            <div class="title">
                <p class="description">
                    Czy napewno chcesz usunac Instytucję o id ${deleteInstitutionFormDTO.id}?
                </p>
            </div>
            <div class="title">
                <p>
                    <a href="<c:url value="organizations/deleteInstitution"/> ">
                        <button class="btn btn-danger">Usuń</button>
                    </a>
                    <a href="<c:url value="organizations"/> ">
                        <button class="btn btn-primary">powrót do listy</button>
                    </a>
                </p>
            </div>
        </form:form>
    </div>
</section>
<jsp:include page="footer.jsp"/>