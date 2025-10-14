<%@ include file="/WEB-INF/include/headerHtml.jsp" %>

<h2 class="text-2xl font-semibold mb-6">Ajouter un Produit</h2>

<form action="produit" method="post" class="bg-white p-6 rounded-lg shadow-md max-w-lg mx-auto">
    <input type="hidden" name="action" value="add">

    <div class="mb-4">
        <label class="block font-medium mb-2">Nom :</label>
        <input type="text" name="nom" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-200">
    </div>

    <div class="mb-4">
        <label class="block font-medium mb-2">Description :</label>
        <textarea name="description" rows="3" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-200"></textarea>
    </div>

    <div class="mb-4">
        <label class="block font-medium mb-2">Prix :</label>
        <input type="number" step="0.01" name="prix" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-200">
    </div>

    <div class="mb-6">
        <label class="block font-medium mb-2">Stock :</label>
        <input type="number" name="stock" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-200">
    </div>

    <div class="flex justify-center space-x-4">
        <button type="submit" class="bg-blue-600 text-white px-5 py-2 rounded-lg hover:bg-blue-700 transition">Ajouter</button>
        <a href="produit?action=list" class="bg-gray-400 text-white px-5 py-2 rounded-lg hover:bg-gray-500 transition">Annuler</a>
    </div>
</form>

<%@ include file="/WEB-INF/include/footerHtml.jsp" %>
