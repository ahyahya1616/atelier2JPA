<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/includes/headerHtml.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="container mt-5" style="padding-bottom: 80px;">
    <h3 class="text-center mb-4">Mes commandes</h3>

    <c:if test="${empty commandes}">
        <p class="text-center">Vous n'avez encore passé aucune commande.</p>
    </c:if>

    <c:if test="${not empty commandes}">
        <table class="table table-bordered table-striped shadow-sm">
            <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Date</th>
                <th>Total (MAD)</th>
                <th>Statut</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cmd" items="${commandes}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${cmd.dateCommande}</td>
                    <td>${cmd.total}</td>
                    <td>${cmd.statut}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <div class="text-center mt-4">
        <a href="produit?action=list" class="btn btn-primary">Retour à la boutique</a>
    </div>
</div>

<%@ include file="/WEB-INF/includes/footerHtml.jsp" %>
