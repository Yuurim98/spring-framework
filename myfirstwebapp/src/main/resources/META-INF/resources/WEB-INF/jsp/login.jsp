<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Page</title>
    </head>

    <body>
        Login page
        <pre> ${errorMessage} </pre>
        <form method="post">
            Name: <input type="text" name="name">
            Password: <input type="password" name="password">
            <input type="submit">
        </form>
    </body>
</html>