<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Phase 2 Project</title>
    <link rel="stylesheet" href="stylesheets/search-page.css">
</head>
<body onload="setMinDate()">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="scripts/search_flight_scripts.js"></script>
<h1>Airline Booking System</h1>
<div class="container">
    <form id=search-form action="search" method="POST">
        <div>
            <label for="date-of-travel">Date: </label><br>
            <input id="date-of-travel" type="date" name="date">
        </div>
        <div>
            <label for="source-location">From: </label><br>
            <input id="source-location" type="text" name="source">
        </div>
        <div>
            <label for="destination-location">To: </label><br>
            <input id="destination-location" type="text" name="destination">
        </div>
        <div>
            <label for="number-people">Number of People: </label><br>
            <input id="number-people" type="number" min="1" max="10" step="1" name="people">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</div>
</body>
</html>