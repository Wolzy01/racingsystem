<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="hero">
    <h1><i class="fa-solid fa-person-running"></i> Racing System</h1>
    <p>Современная платформа для забегов, регистрации и ставок.</p>
    <div class="hero-actions">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/controller?command=listRaces">
            <i class="fa-regular fa-flag"></i> Смотреть забеги
        </a>
        <a class="btn btn-accent" href="${pageContext.request.contextPath}/controller?command=login">
            <i class="fa-solid fa-user"></i> Войти
        </a>
    </div>
</div>