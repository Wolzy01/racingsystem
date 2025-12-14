<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="page-header">
    <h1><i class="fa-solid fa-triangle-exclamation"></i> Ошибка</h1>
    <div class="page-actions">
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controller?command=home">
            ← На главную
        </a>
    </div>
</div>

<div class="card">
    <div class="card-body">
        <div class="alert alert-error">
            <c:out value="${error}" default="Неизвестная ошибка"/>
        </div>
        <div class="card-actions">
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controller?command=listRaces">
                К списку забегов
            </a>
        </div>
    </div>
</div>