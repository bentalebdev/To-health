<!-- WEB-INF/html/success.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 20px;
            background-color: #f5f5f5;
        }
        h1 {
            color: #4CAF50;
        }
        button {
            background-color: #4CAF50; /* Green */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Rendezvous Successfully Taken!</h1>
    <p>Your appointment has been created successfully.</p>
    <button onclick="window.location.href='/To-health/accueil'">Go to Accueil</button>
</body>
</html>
