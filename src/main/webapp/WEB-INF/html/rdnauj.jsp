<%@page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rendez-vous d'aujourd'hui</title>
        <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>

    <style>
        /* Styling for better appearance (optional) */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            text-align: center;
        }
        #appointments {
            margin-top: 20px;
            border-collapse: collapse;
            width: 100%;
        }
        #appointments th, #appointments td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        /* Custom CSS for Button */
        .button-71 {
            background-color: #0078d0;
            border: 0;
            border-radius: 56px;
            color: #fff;
            cursor: pointer;
            display: inline-block;
            font-family: system-ui,-apple-system,system-ui,"Segoe UI",Roboto,Ubuntu,"Helvetica Neue",sans-serif;
            font-size: 18px;
            font-weight: 600;
            outline: 0;
            padding: 16px 21px;
            position: relative;
            text-align: center;
            text-decoration: none;
            transition: all .3s;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
        }

        .button-71:before {
            background-color: initial;
            background-image: linear-gradient(#fff 0, rgba(255, 255, 255, 0) 100%);
            border-radius: 125px;
            content: "";
            height: 50%;
            left: 4%;
            opacity: .5;
            position: absolute;
            top: 0;
            transition: all .3s;
            width: 92%;
        }

        .button-71:hover {
            box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
            transform: scale(1.05);
        }
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

        @media (min-width: 768px) {
            .button-71 {
                padding: 16px 48px;
            }
        }
    </style>
</head>
<body>
    <h1>affichage des rendez-vous </h1>

    <!-- Modified Button -->

    <label>Mot cle </label>
<form action="<c:url value='/reservation'/>" method="GET">
    <input type="text" name="indice"/>
    <button type="submit" class="button-33">chercher</button>
</form>


    <button onclick="window.location.href='/To-health/reserver'" class="button-33">Reserver un rendez-vous </button>



    <table id="appointments">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>CIN</th>
                <th>Téléphone</th>
                <th>Jour</th>
                <th>Heure</th>
            </tr>
        </thead>
        <tbody >
            <c:forEach items = "${list}" var="r">
            <tr>
                 <td>${r.nom}</td>
                 <td>${r.prenom}</td>
                 <td>${r.cin}</td>
                 <td>${r.telephone}</td>
                 <td>${r.date}</td>
                 <td>${r.date_heure}</td>
                 <td>
                 <a href="<c:url value='reservation/edit?cin=${r.cin}' />" class="btn-sm btn-primary"> <span data-feather="edit"></span></a>
                  <a onclick="return confirm('Etes vous sûr?!');" href="<c:url value='/reservation/delete?cin=${r.cin}' />" class="btn-sm btn-danger"> <span data-feather="trash-2"></span></a>

                  </td>
            </tr>
            </c:forEach>





        </tbody>
    </table>

    <script>
        // Fonction pour filtrer les rendez-vous d'aujourd'hui
        function filterAppointments() {
            var today = new Date();
            var appointments = document.querySelectorAll("#appointmentsBody tr");

            appointments.forEach(function(appointment) {
                var appointmentDate = new Date(appointment.getAttribute("data-date"));
                if (appointmentDate.toDateString() === today.toDateString()) {
                    appointment.style.display = "table-row";
                } else {
                    appointment.style.display = "none";
                }
            });
        }

        // Données fictives pour les rendez-vous
        var appointmentsData = [
            
            // Ajoutez autant de rendez-vous que nécessaire ici
        ];

        var appointmentsBody = document.getElementById("appointmentsBody");

        // Ajouter les rendez-vous à la table
        appointmentsData.forEach(function(appointment) {
            var row = document.createElement("tr");
            row.setAttribute("data-date", appointment.jour);
            row.innerHTML = "<td>" + appointment.nom + "</td><td>" + appointment.prenom + "</td><td>" + appointment.cin + "</td><td>" + appointment.telephone + "</td><td>" + appointment.jour + "</td><td>" + appointment.heure + "</td><td>" + appointment.titre + "</td><td>" + appointment.description + "</td>";
            appointmentsBody.appendChild(row);
        });

        // Filtrer les rendez-vous lors du clic sur le bouton
        document.getElementById("filterButton").addEventListener("click", filterAppointments);

        // Filtrer les rendez-vous lors du chargement de la page
        filterAppointments();
    </script>
    <script>
            feather.replace();
        </script>
</body>
</html>
