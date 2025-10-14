<%@ page import="ma.fstt.firstjpa.entities.Commande" %>
<%@ page import="java.util.List" %>
<%@ include file="/WEB-INF/include/headerHtml.jsp" %>

<h2 class="text-2xl font-semibold mb-6">Liste des Commandes</h2>

<%
    List<Commande> commandes = (List<Commande>) request.getAttribute("commandes");
%>

<% if (commandes == null || commandes.isEmpty()) { %>
<p class="text-center text-gray-600">Aucune commande trouvée.</p>
<% } else { %>
<div class="overflow-x-auto">
    <table class="min-w-full bg-white border border-gray-200 rounded-lg shadow-md">
        <thead class="bg-green-600 text-white">
        <tr>
            <th class="py-3 px-4 text-left">ID</th>
            <th class="py-3 px-4 text-left">Date</th>
            <th class="py-3 px-4 text-left">Total</th>
            <th class="py-3 px-4 text-left">Statut</th>
            <th class="py-3 px-4 text-left">ID Internaute</th>
            <th class="py-3 px-4 text-center">Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Commande c : commandes) { %>
        <tr class="border-b hover:bg-gray-50">
            <td class="py-2 px-4"><%= c.getId() %></td>
            <td class="py-2 px-4"><%= c.getDateCommande() %></td>
            <td class="py-2 px-4"><%= c.getTotal() %></td>
            <td class="py-2 px-4"><%= c.getStatut() %></td>
            <td class="py-2 px-4"><%= c.getInternaute().getId() %></td>
            <td class="py-2 px-4 text-center">
                <a href="commande?action=delete&id=<%= c.getId() %>"
                   class="bg-red-600 text-white px-3 py-1 rounded hover:bg-red-700 transition"
                   onclick="return confirm('Voulez-vous vraiment supprimer cette commande ?');">
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
