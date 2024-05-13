<%@page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #37B6F5; /* Changement de la couleur de fond */
        }
        .dashboard {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            max-width: 600px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .info {
            margin-bottom: 20px;
        }
        .info p {
            margin: 0;
            padding: 5px 0;
        }
        .info span {
            font-weight: bold;
            color: #007bff;
        }
        .menu ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .menu ul li {
            display: inline;
            margin-right: 10px;
        }
        .menu ul li a {
            text-decoration: none;
            color: #333;
            padding: 5px 10px;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            display: inline-block;
            cursor: pointer;
        }
        .menu ul li a:hover {
            background-color: #0056b3;
        }
        /* Nouveau style pour les boutons */
        .button-33 {
            background-color: #c2fbd7;
            border-radius: 100px;
            box-shadow: rgba(44, 187, 99, .2) 0 -25px 18px -14px inset,rgba(44, 187, 99, .15) 0 1px 2px,rgba(44, 187, 99, .15) 0 2px 4px,rgba(44, 187, 99, .15) 0 4px 8px,rgba(44, 187, 99, .15) 0 8px 16px,rgba(44, 187, 99, .15) 0 16px 32px;
            color: green;
            cursor: pointer;
            display: inline-block;
            font-family: CerebriSans-Regular,-apple-system,system-ui,Roboto,sans-serif;
            padding: 7px 20px;
            text-align: center;
            text-decoration: none;
            transition: all 250ms;
            border: 0;
            font-size: 16px;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
        }
        .button-33:hover {
            box-shadow: rgba(44,187,99,.35) 0 -25px 18px -14px inset,rgba(44,187,99,.25) 0 1px 2px,rgba(44,187,99,.25) 0 2px 4px,rgba(44,187,99,.25) 0 4px 8px,rgba(44,187,99,.25) 0 8px 16px,rgba(44,187,99,.25) 0 16px 32px;
            transform: scale(1.05) rotate(-1deg);
        }
    </style>
</head>
<body>
    <div class="dashboard">
        <h1>Dashboard</h1>
        <div class="info">
            <p> nombre des rendez-vous aujourd hui : ${rdncount} </p>
            <p>Heure actuelle : <span id="currentTime"></span></p>
        </div>
        <div class="menu">
            <ul>
                <li><a href="index.htm" class="button-33" role="button">Accueil</a></li>
                <li><a href="/To-health/reservation" class="button-33" role="button">Rendez-vous</a></li>
                <li><a href="/To-health/patient" class="button-33" role="button">Patients</a></li>
            </ul>
        </div>
    </div>

    <script>
        function updateTime() {
            var now = new Date();
            var hours = now.getHours();
            var minutes = now.getMinutes();
            var seconds = now.getSeconds();
            // Ajoute un zéro devant les chiffres < 10 pour le format "hh:mm:ss"
            hours = hours < 10 ? '0' + hours : hours;
            minutes = minutes < 10 ? '0' + minutes : minutes;
            seconds = seconds < 10 ? '0' + seconds : seconds;
            var currentTimeString = hours + ':' + minutes + ':' + seconds;
            document.getElementById('currentTime').innerText = currentTimeString;
        }

        // Met à jour l'heure toutes les secondes
        setInterval(updateTime, 1000);

        // Mettre à jour l'heure dès le chargement de la page
        updateTime();
    </script>
</body>
</html>
