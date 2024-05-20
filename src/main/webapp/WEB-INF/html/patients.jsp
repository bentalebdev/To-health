<%@page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des patients</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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
            text-decoration: none;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .btn-red {
            background-color: #f44336;
        }
        .btn-red:hover {
            background-color: #e53935;
        }
        .action-buttons a {
            margin-right: 5px;
        }
        .icon {
            width: 20px;
            height: 20px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Boutons Dashboard et Ajouter un patient -->
    <button class="btn" onclick="window.location.href='${pageContext.request.contextPath}/dashboard'">Dashboard</button>
    <button class="btn" onclick="window.location.href='${pageContext.request.contextPath}/formpatient'">Ajouter un patient</button>

    <h2>Gestion des patients</h2>

    <table id="patientTable">
        <thead>
        <tr>
            <th>id</th>
            <th>nom</th>
            <th>prenom</th>
            <th>cin</th>
            <th>genre</th>
            <th>date_naissance</th>
            <th>date rendezvous</th>
            <th>derniere_visite</th>
            <th>telephone</th>
            <th>acte_medicale</th>
            <th>etat</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.nom}</td>
                <td>${patient.prenom}</td>
                <td>${patient.cin}</td>
                <td>${patient.genre}</td>
                <td>${patient.date_naissance}</td>
                <td>${patient.daterendezvous}</td>
                <td>${patient.derniere_visite}</td>
                <td>${patient.telephone}</td>
                <td>${patient.acte_medicale}</td>
                <td>${patient.etat}</td>
                <td class="action-buttons">
                    <a href="${pageContext.request.contextPath}/patient/edit?id=${patient.id}" class="btn">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="${pageContext.request.contextPath}/patient/delete?id=${patient.id}" class="btn btn-red" onclick="return confirm('Etes-vous sûr ?');">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="text" id="recherche" placeholder="Rechercher un patient...">
    <button class="btn" onclick="rechercher()">Rechercher</button>
</div>

<script>
    function rechercher() {
        // Logique de recherche actuelle
    }
</script>
</body>
</html>
