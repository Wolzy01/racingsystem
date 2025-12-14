<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
    <h1><i class="fa-solid fa-coins"></i> Мои ставки</h1>
</div>

<c:if test="${empty bets}">
    <div class="empty">
        <i class="fa-solid fa-circle-info"></i>
        У вас пока нет ставок.
    </div>
</c:if>

<c:if test="${not empty bets}">
    <div class="cards-grid">
        <c:forEach var="bet" items="${bets}">
            <div class="card">
                <div class="card-header">
                    <h3>Ставка на участника #${bet.participantId}</h3>
                    <span class="badge">${bet.type}</span>
                </div>
                <div class="card-body">
                    <div class="meta">
                        <i class="fa-solid fa-coins"></i>
                        Сумма: ${bet.amount}
                    </div>
                    <div class="meta">
                        <i class="fa-solid fa-flag-checkered"></i>
                        Забег: #${bet.raceId}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>