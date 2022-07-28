<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Phase 2 Project</title>
</head>
<body>
<h1>Airline Booking System</h1>
<form action="search" method="POST">
    <div>
        <label for="date-of-travel">Date: </label><br>
        <input id="date-of-travel" type="date" min="2022-07-27" name="date">
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
</body>
</html>