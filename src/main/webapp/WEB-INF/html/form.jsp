<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire</title>
</head>
<body>

<h2>prendre un rendez-vous </h2>

<form action="#" method="post">
    <label for="nom">Nom :</label><br>
    <input type="text" id="nom" name="nom"><br><br>

    <label for="prenom">Prénom :</label><br>
    <input type="text" id="prenom" name="prenom"><br><br>

    <label for="cin">CIN :</label><br>
    <input type="text" id="cin" name="cin"><br><br>

    <label for="age">Âge :</label><br>
    <input type="number" id="age" name="age"><br><br>

    <label for="telephone">Téléphone :</label><br>
    <input type="tel" id="telephone" name="telephone"><br><br>

    <label for="handicape">Handicapé :</label><br>
    <input type="radio" id="handicape_oui" name="handicape" value="oui">
    <label for="handicape_oui">Oui</label><br>
    <input type="radio" id="handicape_non" name="handicape" value="non">
    <label for="handicape_non">Non</label><br><br>

    <input type="submit" value="Soumettre">
</form>

</body>
</html>
