<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un patient</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="date"],
        textarea {
            width: calc(100% - 22px); /* Ajuster la largeur du champ pour prendre en compte la bordure */
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="radio"] {
            margin: 0 5px;
            display: inline-block;
            vertical-align: middle;
        }
        .gender-label {
            display: inline-block;
            margin-right: 15px;
            vertical-align: middle;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
            width: 100%;
            display: block;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Ajouter un patient</h2>
    <form action="/To-health/formpatient" method="post">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required>

        <label for="prenom">Prenom :</label>
        <input type="text" id="prenom" name="prenom" required>
        <label for="cin">cin :</label>
        <input type="text" id="cin" name="cin" required>

        <label for="telephone">Telephone :</label>
        <input type="text" id="telephone" name="telephone" required>

        <label for="date_naissance">Date de naissance :</label>
        <input type="date" id="date_naissance" name="date_naissance" required>

        <label>Genre :</label>
        <div style="display: inline-block;">
            <input type="radio" id="homme" name="genre" value="homme" required>
            <label for="homme">Homme</label>
        </div>
        <div style="display: inline-block;">
            <input type="radio" id="femme" name="genre" value="femme" required>
            <label for="femme">Femme</label>
        </div>
        
        <label for="derniere_visite">Derniere visite :</label>
        <input type="date" id="derniere_visite" name="derniere_visite" style="width: 100%; margin-bottom: 10px;">

        <label for="acte_medicale">Acte medical :</label>
        <textarea id="acte_medicale" name="acte_medicale" rows="4" style="width: calc(100% - 22px);"></textarea>

        <input type="submit" value="Ajouter">
    </form>
</div>

</body>
</html>
