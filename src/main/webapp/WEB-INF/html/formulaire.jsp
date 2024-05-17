<%@page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rendez-vous</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1, h2 {
            color: #333;
        }

        #heures_disponibles {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="time"] {
            padding: 8px;
            width: 200px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Renseignez les informations suivantes:

</h1>
    <form action="<c:url value='/rendezvous/formulaire'/>" method="post">

        <input type= 'hidden' id='jour' name="jour" , value=${jour}>
       <label for="heure">Choisir une heure :</label>
       <select id="heure" name="heure" required>
           <option value="">Sélectionnez une heure</option>
           <!-- Boucle pour afficher les heures disponibles -->
           <c:forEach items="${list}" var="heure">
               <option value="${heure}">${heure}</option>
           </c:forEach>
       </select>
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required>

        <label for="cin">CIN :</label>
        <input type="text" id="cin" name="cin" required>

        <label for="telephone">Téléphone :</label>
        <input type="tel" id="telephone" name="telephone" required>


       <button type="submit" class="btn btn-primary">Enregistrer</button>

    </form>
</div>
</body>
</html>
