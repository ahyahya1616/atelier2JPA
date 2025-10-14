<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/includes/headerHtml.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="container mt-5 text-center">
    <h3 class="text-success mb-4">${message}</h3>
    <p>Merci pour votre achat, ${sessionScope.internaute.nom} </p>

    <a href="produit?action=list" class="btn btn-primary mt-3">Retour à la boutique</a>
</div>

<%@ include file="/WEB-INF/includes/footerHtml.jsp" %>
