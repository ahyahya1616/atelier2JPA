<%@ include file="/WEB-INF/include/headerHtml.jsp" %>

<h2 class="text-2xl font-semibold mb-6">Ajouter un Produit au Panier</h2>

<form action="panier" method="post" class="bg-white p-6 rounded-lg shadow-md max-w-lg mx-auto">
    <input type="hidden" name="action" value="addLigne">

    <div class="mb-4">
        <label class="block font-medium mb-2">ID du produit :</label>
        <input type="number" name="idProduit" required placeholder="ex: 1"
               class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-purple-200">
    </div>

    <div class="mb-6">
        <label class="block font-medium mb-2">Quantité :</label>
        <input type="number" name="quantite" min="1" value="1"
               class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-purple-200">
    </div>

    <div class="flex justify-center space-x-4">
        <button type="submit" class="bg-purple-600 text-white px-5 py-2 rounded-lg hover:bg-purple-700 transition">Ajouter</button>
        <a href="panier?action=view" class="bg-gray-400 text-white px-5 py-2 rounded-lg hover:bg-gray-500 transition">Voir Panier</a>
    </div>
</form>

<%@ include file="/WEB-INF/include/footerHtml.jsp" %>
