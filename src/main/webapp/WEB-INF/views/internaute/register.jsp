<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/includes/headerHtml.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="container mt-5" style="padding-bottom: 80px;">
  <div class="card mx-auto" style="max-width: 400px;">
    <div class="card-body">
      <h4 class="text-center mb-4">Créer un compte</h4>

      <form action="internaute" method="post">
        <input type="hidden" name="action" value="register"/>

        <div class="mb-3">
          <label>Nom :</label>
          <input type="text" class="form-control" name="nom" required/>
        </div>

        <div class="mb-3">
          <label>Email :</label>
          <input type="email" class="form-control" name="email" required/>
        </div>

        <div class="mb-3">
          <label>Mot de passe :</label>
          <input type="password" class="form-control" name="password" required/>
        </div>

        <button class="btn btn-success w-100">S'inscrire</button>
      </form>

      <p class="text-center mt-3">
        Déjà inscrit ? <a href="internaute?action=loginForm">Se connecter</a>
      </p>
    </div>
  </div>
</div>

<%@ include file="/WEB-INF/includes/footerHtml.jsp" %>
