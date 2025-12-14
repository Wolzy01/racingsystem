<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
    <h1><i class="fa-solid fa-user"></i> Вход</h1>
    <div class="page-actions">
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controller?command=home">
            ← На главную
        </a>
    </div>
</div>

<c:if test="${not empty error}">
    <div class="alert alert-error"><c:out value="${error}"/></div>
</c:if>

<div class="card">
    <div class="card-body">
        <form method="post" action="${pageContext.request.contextPath}/controller?command=authenticate" class="form">
            <label class="form-label">Логин</label>
            <input name="username" class="form-control" required/>

            <label class="form-label">Пароль</label>
            <input name="password" type="password" class="form-control" required/>

            <button type="submit" class="btn btn-accent">
                <i class="fa-solid fa-arrow-right-to-bracket"></i> Войти
            </button>
        </form>
    </div>
</div>