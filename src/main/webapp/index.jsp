<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Phase 2 Project</title>
  <link rel="stylesheet" href="login-page.css">
</head>
<body>
<main id="main-holder">
  <h1 id="login-header">Login</h1>
  <div id="login-error-msg-holder">
    <p id="login-error-msg">Invalid Username <span id="error-msg-second-line">and/or password</span></p>
  </div>
  <form id="login-form" action="login" method="POST">
    <input type="text" name="username" id="username-field" class="login-form-field" placeholder="Username">
    <input type="password" name="password" id="password-field" class="login-form-field" placeholder="Password">
    <input type="submit" value="Login" id="login-form-submit">
  </form>

</main>
</body>
</html>
