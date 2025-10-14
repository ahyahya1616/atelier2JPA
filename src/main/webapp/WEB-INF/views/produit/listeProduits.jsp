<%@ page import="ma.fstt.firstjpa.entities.Produit" %>
<%@ page import="java.util.List" %>
<%@ include file="/WEB-INF/include/headerHtml.jsp" %>

<h2 class="text-2xl font-semibold mb-6">Liste des Produits</h2>

<%
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>

<% if (produits == null || produits.isEmpty()) { %>
<p class="text-center text-gray-600">Aucun produit trouvé.</p>
<% } else { %>
<div class="overflow-x-auto">
    <table class="min-w-full bg-white border border-gray-200 rounded-lg shadow-md">
        <thead class="bg-blue-600 text-white">
        <tr>
            <th class="py-3 px-4 text-left">ID</th>
            <th class="py-3 px-4 text-left">Nom</th>
            <th class="py-3 px-4 text-left">Description</th>
            <th class="py-3 px-4 text-left">Prix</th>
            <th class="py-3 px-4 text-left">Stock</th>
            <th class="py-3 px-4 text-center">Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Produit p : produits) { %>
        <tr class="border-b hover:bg-gray-50">
            <td class="py-2 px-4"><%= p.getId() %></td>
            <td class="py-2 px-4"><%= p.getNom() %></td>
            <td class="py-2 px-4"><%= p.getDescription() %></td>
            <td class="py-2 px-4"><%= p.getPrix() %></td>
            <td class="py-2 px-4"><%= p.getStock() %></td>
            <td class="py-2 px-4 text-center">
                <a href="produit?action=delete&id=<%= p.getId() %>"
                   class="bg-red-600 text-white px-3 py-1 rounded hover:bg-red-700 transition"
                   onclick="return confirm('Voulez-vous vraiment supprimer ce produit ?');">
                    Supprimer
                </a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<% } %>

<%@ include file="/WEB-INF/include/footerHtml.jsp" %>
