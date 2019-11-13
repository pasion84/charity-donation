<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>
<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Lista zaufanych instytucji
        </h1>
    </div>
</div>

</header>
<section class="stats">
    <div class="container--85">
    <h2>Kto pomaga?</h2>
    <table style="font-size: large">
        <thead>
        <tr>
            <th>nazwa instytucji</th>
            <th>opis instytucji</th>
            <th>akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${institutionList}" var="institution">
            <tr>
                <td>${institution.name}</td>
                <td>${institution.description}</td>
                <td>
                    <button class="btn btn--small">
                        <a href="${mainURL}admin/organizations/addOrEdit" data-id="${institution.id}">Edytuj</a>
                    </button>
                </td>

                <td>
                    <button class="btn btn--small">
                    <a href="${mainURL}admin/organizations" data-id="${institution.id}">Usun</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <button class="btn btn--small">
            <a href="${mainURL}admin/organizations/addOrEdit">Dodaj</a>
        </button>
    </div>
</section>
<jsp:include page="footer.jsp"/>