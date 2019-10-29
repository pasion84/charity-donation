<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url value="/" var="mainURL"/>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="${mainURL}resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <c:if test="${principal != null}">
            <ul class="dropdown">
                <li>
                    <p class="btn btn--small btn--without-border">Witaj ${loggedUser.getEmail()}</p>
                    <a href="${mainURL}logout" class="btn btn--small btn--highlighted">Wyloguj</a>
                </li>
            </ul>
            <ul>
                <li><a href="${mainURL}" class="btn btn--without-border active">Start</a></li>
                <li><a href="${mainURL}#steps" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="${mainURL}donation" class="btn btn--without-border">Przekarz dary</a></li>
                <li><a href="${mainURL}#about" class="btn btn--without-border">O nas</a></li>
                <li><a href="${mainURL}#organizations" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="${mainURL}#kontakt" class="btn btn--without-border">Kontakt</a></li>
            </ul>


        </c:if>
        <c:if test="${principal == null}">
            <ul class="dropdown">
                <li><a href="${mainURL}login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="${mainURL}user/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </ul>

            <ul>
                <li><a href="${mainURL}" class="btn btn--without-border active">Start</a></li>
                <li><a href="${mainURL}#steps" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="${mainURL}#about" class="btn btn--without-border">O nas</a></li>
                <li><a href="${mainURL}#organizations" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="${mainURL}#kontakt" class="btn btn--without-border">Kontakt</a></li>
            </ul>
        </c:if>
    </nav>



