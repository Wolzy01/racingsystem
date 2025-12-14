<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
    <h1><i class="fa-solid fa-list-ol"></i> Список забегов</h1>
    <div class="page-actions">
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/controller?command=listRaces">
            <i class="fa-solid fa-rotate-right"></i> Обновить
        </a>
    </div>
</div>

<c:choose>
    <c:when test="${empty races}">
        <div class="empty">
            <i class="fa-regular fa-calendar-xmark"></i>
            <p>Пока нет запланированных забегов.</p>
        </div>
    </c:when>
    <c:otherwise>
        <div class="cards-grid">
            <c:forEach var="race" items="${races}">
                <div class="card">
                    <div class="card-header">
                        <h3><c:out value="${race.name}"/></h3>

                        <c:set var="status" value="${race.status}"/>
                        <span class="badge
                            <c:out value='${status == "SCHEDULED" ? "badge-scheduled" :
                                           status == "ONGOING"   ? "badge-ongoing"   :
                                                                   "badge-finished"}'/>">
                            <c:out value="${race.status}"/>
                        </span>
                    </div>

                    <div class="card-body">
                        <div class="meta">
                            <i class="fa-regular fa-clock"></i>
                            <span><c:out value="${race.startTimeFormatted}"/></span>
                        </div>

                        <div class="card-actions">
                            <!-- У тебя нет команды raceDetails, поэтому ведём на placeBet -->
                            <a class="btn btn-secondary"
                               href="${pageContext.request.contextPath}/controller?command=placeBet&id=${race.id}">
                                <i class="fa-regular fa-circle-info"></i> Подробнее
                            </a>

                            <!-- У тебя нет команды register (она у тебя не зарегистрирована),
                                 поэтому чтобы не кидало на главную — ведём на placeBet -->
                            <a class="btn btn-accent"
                               href="${pageContext.request.contextPath}/controller?command=placeBet&id=${race.id}">
                                <i class="fa-solid fa-user-plus"></i> Регистрация
                            </a>

                            <a class="btn btn-primary"
                               href="${pageContext.request.contextPath}/controller?command=placeBet&id=${race.id}">
                                <i class="fa-solid fa-coins"></i> Сделать ставку
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
