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
            <th>id instytucji</th>
            <th>nazwa instytucji</th>
            <th>opis instytucji</th>
            <th>akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${institutionList}" var="institution">
            <tr>
                <td>${institution.id}</td>
                <td>${institution.name}</td>
                <td>${institution.description}</td>
                <td>
                    <button class="btn btn--small">
                        <a href="<c:url value="organizations/edit"><c:param name="id" value="${institution.id}"/></c:url> ">
                            Edytuj
                        </a>
                    </button>
                </td>

                <td>
                    <button class="btn btn--small">
                        <a href="<c:url value="organizations/delete"><c:param name="id" value="${institution.id}"/></c:url> ">
                            Usun
                        </a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <button class="btn btn--small">
            <a href="${mainURL}admin/organizations/add">Dodaj</a>
        </button>
    </div>
</section>
<jsp:include page="footer.jsp"/>