<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Wine Trade Distribution System" name="description">
    <meta content="australia wine distribution promotion procurement system" name="keywords">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous">
    <!-- Site-specific CSS -->
    <link href="assets/style/style.css" rel="stylesheet">

    <title>Wellnet Wine Trade - Nedved</title>
</head>

<body>
<%--//HEADER SECTION--%>
<header id="header" class="fixed-top d-flex align-items-center header-transparent">
    <div class="container d-flex justify-content-between align-items-center">

        <div id="logo">
            <h1><a href="#">Wellnet Wine Trade</a></h1>
        </div>

        <%-- //NAVIGATION --%>
        <nav id="navbar" class="navbar">
            <ul>
                <li><a class="nav-link scrollto active" href="#">Home</a></li>
                <li><a class="nav-link scrollto" href="#">About</a></li>
                <li><a class="nav-link scrollto" href="#">Services</a></li>
                <li><a class="nav-link scrollto" href="#">Contact</a></li>
            </ul>
        </nav>
        <%-- //end navigation --%>
    </div>
</header>
<%-- //end header section --%>

<%-- //MAIN SECTION --%>
<main id="hero">
    <div class="hero-container">
        <h1>Welcome to Wellnet</h1>
        <h2>A Wine Trade Management System for assistance with procurement, promotion <br>and
            distribution of fine
            Australian wine</h2>
        <a href="<%= request.getContextPath() %>/register" class="btn-get-started">Get Started</a>
    </div>
</main>
<%-- //end main section --%>

</body>

</html>