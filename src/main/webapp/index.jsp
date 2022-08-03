<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Phase 2 Project</title>
  <link rel="stylesheet" href="stylesheets/login-page.css">
</head>
<body>
<main id="main-holder">
  <h1 id="login-header">Login</h1>
  <form id="login-form" action="login" method="POST">
    <label for="username-field">
      <input type="text" name="username" id="username-field" class="login-form-field" placeholder="Username">
    </label>
    <label for="password-field">
      <input type="password" name="password" id="password-field" class="login-form-field" placeholder="Password">
    </label>
    <input type="submit" value="Login" id="login-form-submit">
  </form>

</main>
</body>
</html>
