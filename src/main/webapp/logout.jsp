<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>

    <title>::Sign out::</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script type="text/javascript" src="script.js"></script>
    <link rel="shortcut icon" href="ukraine.jpeg" />

</head>

<body>
<% session.invalidate();%>
<center>
    <h1>You are currently Signed out<br>
        <a href="http://localhost:8080/cc_war_exploded/">Login</a> to continue..
    </h1>
</center>
</body>
</html>