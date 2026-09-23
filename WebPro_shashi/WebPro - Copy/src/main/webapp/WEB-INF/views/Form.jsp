<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Here!!</title>
</head>
<body>

<h1>Registration Form</h1>

    <form action="registerCustomer" method="post">

        <label>First Name:</label>
    <input type="text" name="fname" required>
    <br><br>

    <label>Last Name:</label>
    <input type="text" name="lname" required>
    <br><br>

    <label>Email:</label>
    <input type="email" name="email" required>
    <br><br>

    <label>Password:</label>
    <input type="password" name="pass" required>
    <br><br>

    <input type="submit" value="Submit">
    <input type="reset" value="Reset">

</form>

</body>
</html>