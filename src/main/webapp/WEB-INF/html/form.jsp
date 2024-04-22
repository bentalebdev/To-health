<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulaire de rendez-vous</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/crypto-js.js"></script>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #0F52D1; /* Modification de la couleur de fond */
    }
    form {
        background-color: #6495ED;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 400px;
    }
    input[type="text"], input[type="tel"], input[type="date"], select, input[type="number"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        background-color: #1E90FF;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #4169E1;
    }
    label {
        font-weight: bold;
        color: white;
    }
    #captcha-image {
        margin-top: 10px;
        max-width: 100%;
        height: auto;
    }
</style>
</head>
<body>
    <form action="#" method="post" onsubmit="return validateForm()">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required>

        <label for="prenom">Prenom :</label>
        <input type="text" id="prenom" name="prenom" required>

        <label for="cin">CIN :</label>
        <input type="text" id="cin" name="cin" required>

        <label for="telephone">Telephone :</label>
        <input type="tel" id="telephone" name="telephone" required>

        <label for="date">Date :</label>
        <input type="date" id="date" name="date" required>

        <label for="heure">Heure :</label>
        <select id="heure" name="heure" required>
            <option value="" disabled selected>Choisissez une heure</option>
            <option value="09:00">09:00</option>
            <option value="09:30">09:30</option>
            <option value="10:00">10:00</option>
            <option value="10:30">10:30</option>
            <option value="11:00">11:00</option>
            <option value="11:30">11:30</option>
            <option value="12:00">12:00</option>
            <option value="12:30">12:30</option>
            <option value="13:00">13:00</option>
            <option value="13:30">13:30</option>
            <option value="14:00">14:00</option>
            <option value="14:30">14:30</option>
            <option value="15:00">15:00</option>
        </select>

        <label for="captcha">Entrez le nombre affiche sur l'image ci-dessous :</label>
        <input type="number" id="captcha" name="captcha" required>
        <img id="captcha-image" src="https://dummyimage.com/150x50/000/fff&text=" alt="Captcha Image">
        <input type="submit" value="Prendre rendez-vous">
    </form>

    <script>
        function generateCaptchaNumber() {
            var captchaNumber = Math.floor(Math.random() * (300 - 100 + 1) + 100);
            return captchaNumber;
        }

        function validateForm() {
            var captcha = document.getElementById("captcha").value;
            if (captcha != document.getElementById("captcha-image").getAttribute("data-captcha")) {
                alert("Veuillez r�pondre correctement � la question de s�curit�.");
                return false;
            }
            // Clear form fields after submission
            document.getElementById("nom").value = "";
            document.getElementById("prenom").value = "";
            document.getElementById("cin").value = "";
            document.getElementById("telephone").value = "";
            document.getElementById("date").value = "";
            document.getElementById("heure").value = "";
            document.getElementById("captcha").value = "";
            document.getElementById("captcha-image").setAttribute("data-captcha", generateCaptchaNumber());
            document.getElementById("captcha-image").src = "https://dummyimage.com/150x50/000/fff&text=" + document.getElementById("captcha-image").getAttribute("data-captcha");
            return true;
        }

        document.addEventListener('DOMContentLoaded', function() {
            // Generate random captcha number
            var captchaNumber = generateCaptchaNumber();
            document.getElementById("captcha-image").setAttribute("data-captcha", captchaNumber);
            document.getElementById("captcha-image").src = "https://dummyimage.com/150x50/000/fff&text=" + captchaNumber;

            // Set minimum date for the date input to tomorrow
            const tomorrow = new Date();
            tomorrow.setDate(tomorrow.getDate() + 1);

            const year = tomorrow.getFullYear();
            let month = tomorrow.getMonth() + 1;
            let day = tomorrow.getDate();

            if (month < 10) {
                month = '0' + month;
            }

            if (day < 10) {
                day = '0' + day;
            }

            const minDate = year + '-' + month + '-' + day;
            document.getElementById('date').setAttribute('min', minDate);
        });
    </script>
</body>
</html>
