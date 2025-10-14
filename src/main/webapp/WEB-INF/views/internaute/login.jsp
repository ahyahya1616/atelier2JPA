<%@ include file="/WEB-INF/includes/headerHtml.jsp" %>
<%@ include file="/WEB-INF/includes/navbar.jsp" %>

<div class="container mt-5">
    <div class="card mx-auto" style="max-width: 400px;">
        <div class="card-body">
            <h4 class="text-center mb-4">Connexion</h4>

            <form action="internaute" method="post">
                <input type="hidden" name="action" value="login"/>

                <div class="mb-3">
                    <label>Email :</label>
                    <input type="email" class="form-control" name="email" required/>
                </div>

                <div class="mb-3">
                    <label>Mot de passe :</label>
                    <input type="password" class="form-control" name="password" required/>
                </div>

                <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger">
                    <%= request.getAttribute("error") %>
                </div>
                <% } %>

                <button class="btn btn-primary w-100">Se connecter</button>
            </form>

            <p class="text-center mt-3">
                Pas encore inscrit ? <a href="internaute?action=registerForm">Créer un compte</a>
            </p>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/includes/footerHtml.jsp" %>
