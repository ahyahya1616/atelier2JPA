<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ma.fstt.firstjpa.entities.Internaute" %>

<%
    Internaute internaute = (Internaute) session.getAttribute("internaute");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">🛒 e-Commerce</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <% if (internaute != null) { %>
                <li class="nav-item"><a class="nav-link" href="commande?action=listCommande">Mes commandes</a></li>
                <li class="nav-item"><a class="nav-link" href="internaute?action=logout">Déconnexion</a></li>
                <% } else { %>
                <li class="nav-item"><a class="nav-link" href="internaute?action=loginForm">Connexion</a></li>
                <li class="nav-item"><a class="nav-link" href="internaute?action=registerForm">Inscription</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
