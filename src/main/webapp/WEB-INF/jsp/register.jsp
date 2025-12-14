<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="page-header">
    <h1><i class="fa-solid fa-user-plus"></i> Регистрация на забег</h1>
    <div class="page-actions">
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controller?command=raceDetails&id=${race.id}">
            ← Назад к забегу
        </a>
    </div>
</div>

<div class="card">
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/controller?command=submitRegistration" method="post" class="form">
            <input type="hidden" name="raceId" value="${race.id}"/>

            <label class="form-label">Имя</label>
            <input type="text" name="name" class="form-control" required/>

            <label class="form-label">Контактный e-mail</label>
            <input type="email" name="email" class="form-control" required/>

            <button type="submit" class="btn btn-accent">
                <i class="fa-solid fa-user-check"></i> Зарегистрироваться
            </button>
        </form>
    </div>
</div>