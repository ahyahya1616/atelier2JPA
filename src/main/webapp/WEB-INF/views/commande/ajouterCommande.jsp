<%@ include file="/WEB-INF/include/headerHtml.jsp" %>

<h2 class="text-2xl font-semibold mb-6">Ajouter une Commande</h2>

<form action="commande" method="post" class="bg-white p-6 rounded-lg shadow-md max-w-lg mx-auto">
    <input type="hidden" name="action" value="add">

    <div class="mb-4">
        <label class="block font-medium mb-2">Date de commande :</label>
        <input type="date" name="dateCommande" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-green-200">
    </div>

    <div class="mb-4">
        <label class="block font-medium mb-2">Total :</label>
        <input type="number" step="0.01" name="total" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-green-200">
    </div>

    <div class="mb-4">
        <label class="block font-medium mb-2">Statut :</label>
        <select name="statut" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-green-200">
            <option value="En cours">En cours</option>
            <option value="Livrée">Livrée</option>
            <option value="Annulée">Annulée</option>
        </select>
    </div>

    <div class="mb-6">
        <label class="block font-medium mb-2">ID Internaute :</label>
        <input type="number" name="idInternaute" required class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-green-200">
    </div>

    <div class="flex justify-center space-x-4">
        <button type="submit" class="bg-green-600 text-white px-5 py-2 rounded-lg hover:bg-green-700 transition">Ajouter</button>
        <a href="commande?action=list" class="bg-gray-400 text-white px-5 py-2 rounded-lg hover:bg-gray-500 transition">Annuler</a>
    </div>
</form>

<%@ include file="/WEB-INF/include/footerHtml.jsp" %>
