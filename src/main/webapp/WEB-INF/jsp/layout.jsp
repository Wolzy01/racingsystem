<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title><c:out value="${pageTitle != null ? pageTitle : 'Racing System'}"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Основные стили -->
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
    <!-- Иконки FontAwesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<header class="site-header">
    <div class="container header-inner">
        <!-- Логотип -->
        <a href="${pageContext.request.contextPath}/controller?command=home" class="logo">
            <i class="fa-solid fa-person-running"></i> Racing System
        </a>

        <!-- Навигация -->
        <nav class="nav">
            <a href="${pageContext.request.contextPath}/controller?command=home"
               class="<c:out value='${activeTab == "home" ? "active" : ""}'/>">
                <i class="fa-solid fa-house"></i> Главная
            </a>
            <a href="${pageContext.request.contextPath}/controller?command=listRaces"
               class="<c:out value='${activeTab == "races" ? "active" : ""}'/>">
                <i class="fa-solid fa-list-ol"></i> Забеги
            </a>
            <a href="${pageContext.request.contextPath}/controller?command=myBets"
               class="<c:out value='${activeTab == "bets" ? "active" : ""}'/>">
                <i class="fa-solid fa-coins"></i> Мои ставки
            </a>
            <a href="${pageContext.request.contextPath}/controller?command=login"
               class="<c:out value='${activeTab == "login" ? "active" : ""}'/>">
                <i class="fa-solid fa-user"></i> Вход
            </a>
        </nav>
    </div>
</header>

<!-- Основной контент -->
<main class="container">
    <jsp:include page="${content}"/>
</main>

<!-- Футер -->
<footer class="site-footer">
    <div class="container footer-inner">
        <span>&copy; 2025 Racing System · Минск</span>
        <span><i class="fa-solid fa-heart"></i> бег объединяет</span>
    </div>
</footer>
</body>
</html>