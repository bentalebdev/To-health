<%@page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des patients</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2, h3 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }
        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .btn {
            background-color: #4caf50;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 5px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Boutons Dashboard et Ajouter un patient -->
    <button class="btn" onclick="window.location.href='/To-health/dashboard'">Dashboard</button>
    <button class="btn" onclick="window.location.href='/To-health/formpatient'">Ajouter un patient</button>

    <h2>Gestion des patients</h2>
    <form action="#" method="post">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" placeholder="Entrez le nom" required>

        <!-- Ajoutez les autres champs ici -->

        <input type="submit" value="Enregistrer">
    </form>

    <h3>Liste des patients</h3>
    <table id="patientTable">
        <!-- Vos en-têtes de tableau actuels ici -->
        <tbody>
        <!-- Les données des patients seront affichées ici -->
        <tr>
            <td>nom</td>
            <td>prenom</td>
            <td>cin</td>
            <td>genre</td>
            <td>date_naissance</td>
            <td>derniere_visite</td>
            <td>telehone</td>
            <td>acte_medicale</td>
            <td>
                <button class="btn" onclick="modifierPatient(this)">Modifier</button>
                <button class="btn" onclick="supprimerPatient(this)">Supprimer</button>
            </td>
        </tr>
        <!-- Ajoutez d'autres lignes pour d'autres patients -->
        </tbody>
        <tbody>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td>${patient.nom}</td>
                <td>${patient.prenom}</td>
                <td>${patient.cin}</td>
                <td>${patient.genre}</td>
                <td>${patient.date_naissance}</td>
                <td>${patient.derniere_visite}</td>
                <td>${patient.telephone}</td>
                <td>${patient.acte_medicale}</td>
                <td>
                    <button class="btn" onclick="modifierPatient(this)">Modifier</button>
                    <button class="btn" onclick="supprimerPatient(this)">Supprimer</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="text" id="recherche" placeholder="Rechercher un patient...">
    <button class="btn" onclick="rechercher()">Rechercher</button>
</div>

<script>
    function afficherPatient(btn) {
        // Logique pour afficher les détails du patient associé au bouton
        // par exemple, vous pouvez ouvrir une boîte de dialogue avec les détails du patient
        alert("Afficher les détails du patient");
    }

    function modifierPatient(btn) {
        // Logique pour modifier les détails du patient associé au bouton
        // par exemple, vous pouvez ouvrir un formulaire pré-rempli pour modifier les détails du patient
        alert("Modifier les détails du patient");
    }

    function supprimerPatient(btn) {
        // Obtenez la ligne du tableau parente du bouton
        var row = btn.parentNode.parentNode;
        // Supprimez la ligne du tableau
        row.parentNode.removeChild(row);
    }

    function rechercher() {
        // Logique de recherche actuelle
    }
</script>
</body>
</html>
