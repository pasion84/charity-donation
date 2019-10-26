<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Oddaj rzeczy, których już nie chcesz.
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span>Wybierz rzeczy</span></div>
                </li>
                <li>
                    <div><em>2</em><span>Spakuj je</span></div>
                </li>
                <li>
                    <div><em>3</em><span>Wybierz fundację</span></div>
                </li>
                <li>
                    <div><em>4</em><span>Zamów kuriera</span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
</header>


<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h4>info</h4>
            <p data-step="1" class="active">
                twoje darowizny - szczegoly
            </p>
            <p data-step="2">
                twoje darowizny
            </p>
            <p data-step="3">
                wybierz instytucję
            </p>
            <p data-step="4">
                podaj dane i czas do odbioru
            </p>
        </div>
    </div>


    <div class="form--steps-container">
        <div class="form--steps-counter">Krok<span>1</span>/4</div>

        <form:form method="post" modelAttribute="createDonation" enctype="multipart/form-data">
        <div data-step="1" class="active">
            <p>wybierz kategorie</p>
            <c:forEach items="${categories}" var="category">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="categories" value="${category.id}" cssClass="category"
                                       data-name="${category.name}"/>
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
            </c:forEach>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn next-step">kolejny krok</button>
            </div>
        </div>

        <div data-step="2">
            <p>wybierz organizację</p>
            <c:forEach items="${institutions}" var="institutions">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institutions" value="${institutions.id}"
                                          data-name="${institutions.name}"/>
                        <span class="checkbox"></span>
                        <span class="description">
                        <div class="title">
                                ${institutions.name}
                        </div>
                    </span>
                    </label>
                </div>
            </c:forEach>
            <div class="form-group--buttons">
                <button type="button" class="btn prev-step">poprzedni krok</button>
                <button type="button" class="btn next-step">kolejny krok</button>
            </div>
        </div>

        <div data-step="3">
            <p>podaj ilość pakowanych worków</p>
            <div class="form-group form-group--inline">
                <label>
                    <form:input path="quantity" type="number" step="1" min="1"/>
                </label>
            </div>
            <div class="form-group--buttons">
                <button type="button" class="btn prev-step">poprzedni krok</button>
                <button type="button" class="btn next-step">kolejny krok</button>
            </div>
        </div>

        <div data-step="4">
            <p>podaj dane odbioru dla kuriera</p>
            <div class="form-section form-section--columns">
                <div class="form-section--column">
                    <p>adres do odbioru</p>
                    <div class="form-group form-group--inline">
                        <label>
                            Ulica
                            <form:input path="street" cssClass="street"/>
                        </label><br>
                    </div>
                    <div class="form-group form-group--inline">
                        <label>
                            Miasto
                            <form:input path="city" cssClass="city"/>
                        </label><br>
                    </div>
                    <div class="form-group form-group--inline">
                        <label>
                            Kod pocztowy
                            <form:input path="zipCode" cssClass="zipCode"/>
                        </label><br>
                    </div>

                    <div class="form-section--column">
                        <p>podaj termin odbioru przez kuriera</p>
                        <div class="form-group form-group--inline">
                            <label>
                                Data
                                <form:input path="pickUpDate" type="date" cssClass="date"/>
                            </label><br>
                        </div>
                        <div class="form-group form-group--inline">
                            <label>
                                Godzina
                                <form:input path="pickUpTime" type="time" cssClass="time"/>
                            </label><br>
                        </div>
                        <div class="form-group form-group--inline">
                            <label>
                                Informacje dla kuriera
                                <form:textarea path="pickUpComment" rows="3"/>
                            </label><br>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">poprzedni krok</button>

                <input type="submit" class="btn" value="zapisz">
            </div>
        </div>

            </form:form>
        </div>
</section>

<jsp:include page="footer.jsp"/>