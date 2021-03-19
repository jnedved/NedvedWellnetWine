<%--
  Created by IntelliJ IDEA.
  User: jake
  Date: 3/6/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous">
    <!-- Site-specific CSS -->
    <link href="assets/style/style.css" rel="stylesheet">

    <title>Register Producers</title>
</head>
<body>
<div id="bodyFormatting">
    <main class="form-signin">
        <div>
            <h1><strong>Welcome to WWTMS!</strong></h1>
        </div>

        <form action="<%= request.getContextPath() %>/register" method="post">
            <h5 class="h4 mb-3 fw-normal">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor"
                     class="bi bi-clipboard-check" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                          d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
                    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
                </svg>
                <code>Please enter your details below</code>
            </h5>
            <div class="form-floating mb-3">
                <input type="text" id="inputID" class="form-control" name="id"
                       placeholder="ID" autocomplete="off" required autofocus>
                <label for="inputID">ID (ex: 12209812)</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" id="inputName" class="form-control" name="name"
                       placeholder="Name" required>
                <label for="inputName">Name</label>
            </div>
            <div class="form-floating mb-3">
                <input type="email" id="inputEmail" class="form-control" name="email"
                       placeholder="producer@winery.com" required>
                <label for="inputEmail">Email address</label>
            </div>

            <h6 class="region-check">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-arrow-down-right-circle" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                          d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.854 5.146a.5.5 0 1 0-.708.708L9.243 9.95H6.475a.5.5 0 1 0 0 1h3.975a.5.5 0 0 0 .5-.5V6.475a.5.5 0 1 0-1 0v2.768L5.854 5.146z"/>
                </svg>
                Region
            </h6>
            <div class="form-check">
                <input type="radio" class="btn-check" name="region" id="option1"
                       value="Western Australia"
                       autocomplete="off">
                <label class="btn btn-outline-danger btn-sm" for="option1">Western Australia</label>

                <input type="radio" class="btn-check" name="region" id="option2"
                       value="South Australia"
                       autocomplete="off">
                <label class="btn btn-outline-danger btn-sm" for="option2">South Australia</label>

                <input type="radio" class="btn-check" name="region" id="option3" value="Tasmania"
                       autocomplete="off">
                <label class="btn btn-outline-danger btn-sm" for="option3">Tasmania</label>

                <input type="radio" class="btn-check" name="region" id="option4" value="Queensland"
                       autocomplete="off">
                <label class="btn btn-outline-danger btn-sm" for="option4">Queensland</label>

                <input type="radio" class="btn-check" name="region" id="option5" value="Victoria"
                       autocomplete="off">
                <label class="btn btn-outline-danger btn-sm" for="option5">Victoria</label>
                <input type="radio" class="btn-check" name="region" id="option6"
                       value="New South Wales"
                       autocomplete="off">
                <label class="btn btn-outline-danger btn-sm" for="option6">New South Wales</label>
            </div>
            <div class="form-buttons">
                <button class="w-20 btn btn-lg btn-outline-primary" type="submit">
                    Sign up
                </button>
                <button class="w-20 btn btn-lg btn-outline-primary" type="reset">Clear</button>
            </div>
        </form>
    </main>
</div>
</body>
</html>
