<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="/WEB-INF/includes/headerHtml.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="container mt-5" style="padding-bottom: 80px;">
  <h3 class="text-center mb-4">Bienvenue, ${sessionScope.internaute.nom} </h3>

  <h4 class="mb-3">Liste des produits</h4>
  <div class="row">
    <c:forEach var="p" items="${produits}">
      <div class="col-md-4 mb-4">
        <div class="card shadow-sm">
          <div class="card-body">
            <h5 class="card-title">${p.nom}</h5>
            <p class="card-text">${p.description}</p>
            <p class="card-text fw-bold">${p.prix} MAD</p>
            <a href="produit?action=addToCart&id=${p.id}" class="btn btn-primary w-100">
              Ajouter au panier
            </a>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>

  <hr/>
  <h5>🛍️ Votre panier</h5>
  <c:if test="${not empty sessionScope.panier}">
  <table class="table">
    <thead>
    <tr>
      <th>Produit</th>
      <th>Quantité</th>
      <th>Sous-total</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ligne" items="${sessionScope.panier}">
      <tr>
        <td>${ligne.produit.nom}</td>
        <td>${ligne.quantite}</td>
        <td>${ligne.sousTotal} MAD</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <div class="text-end">
    <form action="commande" method="post">
      <button type="submit" class="btn btn-success">
        Confirmer l'achat
      </button>
    </form>
  </div>
  </c:if>


<%@ include file="/WEB-INF/includes/footerHtml.jsp" %>
