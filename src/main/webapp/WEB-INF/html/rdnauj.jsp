<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTL Tag Library -->
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8"> <!-- Character encoding -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Responsive design -->
    <title>Rendez-vous d'aujourd'hui</title> <!-- Page title -->
    <style>
        /* General styling for the page */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            text-align: center; /* Centered header */
        }

        #appointments {
            margin-top: 20px; /* Space at the top */
            border-collapse: collapse; /* Compact table */
            width: 100%; /* Full width */
        }

        #appointments th, #appointments td {
            border: 1px solid #ddd; /* Table borders */
            padding: 8px; /* Padding for cells */
            text-align: left; /* Align text to the left */
        }

        /* Custom style for the filter button */
        .button-71 {
            background-color: #0078d0; /* Blue background */
            border-radius: 56px; /* Rounded corners */
            color: #fff; /* White text */
            font-size: 18px; /* Font size */
            padding: 16px 21px; /* Padding */
            cursor: pointer; /* Pointer cursor on hover */
            transition: all 0.3s; /* Smooth transitions */
        }

        .button-71:hover {
            transform: scale(1.05); /* Slight zoom on hover */
            box-shadow: rgba(0, 0, 0, 0.1) 0 10px 13px; /* Hover shadow */
        }
    </style>
</head>
<body>
    <h1>Rendez-vous d'aujourd'hui</h1>

    <button class="button-71" id="filterButton">Filtrer les rendez-vous d'aujourd'hui</button> <!-- Filter button -->

    <table id="appointments"> <!-- Appointments table -->
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
        <tbody>
            <c:forEach var="r" items="${list}"> <!-- Loop through list -->
                <tr>
                    <td>${r.nom}</td>
                    <td>${r.prenom}</td>
                    <td>${r.cin}</td>
                    <td>${r.telephone}</td>
                    <td>${r.jour}</td>
                    <td>${r.date_heure}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        // Function to filter today's appointments
        document.getElementById("filterButton").addEventListener("click", function() {
            var today = new Date().toDateString(); // Get today's date
            var rows = document.querySelectorAll("#appointments tbody tr"); // Get all rows

            rows.forEach(row => {
                var date = new Date(row.querySelector("td:nth-child(5)").innerText).toDateString(); // Extract date
                row.style.display = (date === today) ? "table-row" : "none"; // Show/hide based on the date
            });
        });
    </script>
</body>
</html>
