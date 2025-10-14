<%@ page import="ma.fstt.firstjpa.entities.Panier" %>
<%@ page import="ma.fstt.firstjpa.entities.LignePanier" %>
<%@ page import="java.util.List" %>
<%@ include file="/WEB-INF/include/headerHtml.jsp" %>

<h2 class="text-2xl font-semibold mb-6">Contenu du Panier</h2>

<%
    Panier panier = (Panier) request.getAttribute("panier");
%>

<% if (panier == null || panier.getLignesPanier() == null || panier.getLignesPanier().isEmpty()) { %>
<p class="text-center text-gray-600">Votre panier est vide pour le moment.</p>
<% } else { %>
<div class="overflow-x-auto mb-6">
    <table class="min-w-full bg-white border border-gray-200 rounded-lg shadow-md">
        <thead class="bg-purple-600 text-white">
        <tr>
            <th class="py-3 px-4 text-left">Produit</th>
            <th class="py-3 px-4 text-left">Quantité</th>
            <th class="py-3 px-4 text-left">Prix Unitaire</th>
            <th class="py-3 px-4 text-left">Sous-total</th>
        </tr>
        </thead>
        <tbody>
        <% for (LignePanier lp : panier.getLignesPanier()) { %>
        <tr class="border-b hover:bg-gray-50">
            <td class="py-2 px-4"><%= lp.getProduit().getNom() %></td>
            <td class="py-2 px-4"><%= lp.getQuantite() %></td>
            <td class="py-2 px-4"><%= lp.getProduit().getPrix() %></td>
            <td class="py-2 px-4"><%= lp.getSousTotal() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<div class="text-right font-bold text-xl text-purple-700">
    Total : <%= panier.getTotal() %> MAD
</div>
<% } %>

<div class="text-center mt-8">
    <a href="produit?action=list" class="bg-blue-600 text-white px-5 py-2 rounded-lg hover:bg-blue-700 transition">Continuer les achats</a>
    <a href="panier?action=view" class="bg-purple-600 text-white px-5 py-2 rounded-lg hover:bg-purple-700 transition">Actualiser</a>
</div>

<%@ include file="/WEB-INF/include/footerHtml.jsp" %>
