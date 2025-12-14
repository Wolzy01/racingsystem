<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
    <h1><i class="fa-solid fa-coins"></i> Сделать ставку</h1>
    <div class="page-actions">
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controller?command=raceDetails&id=${race.id}">
            ← Назад к забегу
        </a>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controller?command=listRaces">
            ← К списку забегов
        </a>
    </div>
</div>

<div class="card">
    <div class="card-body">
        <div class="meta">
            <span><i class="fa-regular fa-flag"></i> Забег: <c:out value="${race.name}"/></span>
            <span class="meta-item"><i class="fa-regular fa-clock"></i> <c:out value="${race.startTimeFormatted}"/></span>
            <span class="badge
                <c:out value='${race.status == "SCHEDULED" ? "badge-scheduled" :
                               race.status == "ONGOING"   ? "badge-ongoing"   :
                                                             "badge-finished"}'/>">
                <c:out value="${race.status}"/>
            </span>
        </div>

        <form action="${pageContext.request.contextPath}/controller?command=submitBet" method="post" class="form">
            <input type="hidden" name="raceId" value="${race.id}"/>

            <label class="form-label">Участник</label>
            <select name="participantId" class="form-control" required>
                <c:forEach var="p" items="${participants}">
                    <option value="${p.id}"><c:out value="${p.name}"/></option>
                </c:forEach>
            </select>

            <label class="form-label">Тип ставки</label>
            <select name="type" class="form-control" required>
                <option value="WIN">Победа (WIN)</option>
                <option value="PLACE">Призовое место (PLACE)</option>
                <option value="EXACTA">Экзакта (EXACTA)</option>
            </select>

            <label class="form-label">Сумма</label>
            <input type="number" name="amount" class="form-control" min="1" step="1" required/>

            <button type="submit" class="btn btn-primary">
                <i class="fa-solid fa-check"></i> Подтвердить ставку
            </button>
        </form>
    </div>
</div>