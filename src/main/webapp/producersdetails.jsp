<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: jake
  Date: 3/6/2021
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dbBean" scope="session" class="me.jakenedved.wellnetwine.dao.ProducersDao"/>

<%
    ResultSet rs = null;
%>

<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous">
    <!-- Site-specific CSS -->
    <link href="assets/style/style.css" rel="stylesheet">
    <title>You're Signed Up!</title>
</head>
<body>
<a href="<%= request.getContextPath() %>/droptables">
    <button class="w-20 btn btn-sm btn-danger">
        Drop Tables
    </button>
</a>
<a href="<%= request.getContextPath() %>/populatetables">
    <button class="w-20 btn btn-sm btn-success">
        Populate Tables
    </button>
</a>
<a href="<%= request.getContextPath() %>/register">
    <button class="w-20 btn btn-sm btn-primary">
        Add Another Producer
    </button>
</a>
<h1>Records in the database</h1>
<h4><code>Producers Table</code></h4>
<table class="table table-striped table-primary">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Region</th>
    </tr>
    </thead>
    <tbody>
    <%
        try {
            rs = dbBean.getProducersRS();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            while (true) {
                assert rs != null;
                if (!rs.next()) {
                    break;
                }
    %>
    <tr>
        <th scope="row"><%=rs.getString(1) %>
        </th>
        <td><%=rs.getString(2) %>
        </td>
        <td><%=rs.getString(3) %>
        </td>
        <td><%=rs.getString(4) %>
        </td>
    </tr>
    <%
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    %>
    </tbody>
</table>

<h4><code>Bottles Table</code></h4>
<table class="table table-striped table-primary">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Producer</th>
        <th scope="col">Varietal</th>
        <th scope="col">Size</th>
        <th scope="col">Year</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>
    <%
        try {
            rs = dbBean.getBottlesRS();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            while (true) {
                assert rs != null;
                if (!rs.next()) {
                    break;
                }
    %>
    <tr>
        <th scope="row"><%=rs.getString(1) %>
        </th>
        <td><%=rs.getString(2) %>
        </td>
        <td><%=rs.getString(3) %>
        </td>
        <td><%=rs.getString(4) %>
        </td>
        <td><%=rs.getString(5) %>
        </td>
        <td><%=rs.getString(6) %>
        </td>
        <td>$<%=rs.getString(7) %>
        </td>
    </tr>
    <%
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    %>
    </tbody>
</table>

<h4><code>ProducersBottles Table</code></h4>
<table class="table table-striped table-primary">
    <thead>
    <tr>
        <th scope="col">Producers ID</th>
        <th scope="col">Bottles ID</th>
    </tr>
    </thead>
    <tbody>
    <%
        try {
            rs = dbBean.getProducersBottlesRS();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            while (true) {
                assert rs != null;
                if (!rs.next()) {
                    break;
                }
    %>
    <tr>
        <th scope="row"><%=rs.getString(1) %>
        </th>
        <td><%=rs.getString(2) %>
        </td>
    </tr>
    <%
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    %>
    </tbody>
</table>
</body>
</html>
