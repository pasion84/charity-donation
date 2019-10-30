<%@ c:taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Lista zaufanych instytucji<br/>
            Oddaj im niechciane rzeczy
        </h1>
    </div>
</div>

</header>
<section class="icon--glasses">
    <h2>Kto pomaga?</h2>
    <table class="btn--highlighted">
        <thead>
        <tr>
            <th>nazwa instytucji</th>
            <th>opis instytucji</th>
            <th>akcje</th>
        </tr>
        </thead>
        <tbody>
        <form:form method="post" modelAttribute="list">
        <c:forEach items="${list}" var="institution">
            <tr>
                ${institution.name}
                ${institution.description}
            </tr>
        </c:forEach>
        </tbody>
        </form:form>
    </table>

    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>

        <ul class="help--slides-items">
            <c:forEach items="${institutions}" var="institution" varStatus="i">
            <c:if test="${(i.index+1)%2>0}">
            <li></c:if>
                <div class="col">
                    <div class="title">${institution.name}</div>
                    <div class="title">${institution.description}</div>
                </div>
                </c:forEach>

        </ul>
    </div>


</section>
<jsp:include page="footer.jsp"/>