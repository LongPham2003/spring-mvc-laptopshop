<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
            <meta name="author" content="Hỏi Dân IT" />
            <title>Dashboard - Hỏi Dân IT</title>
            <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
            <link href="/css/styles.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Dashboard</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                <li class="breadcrumb-item active">Product</li>
                            </ol>
                            <div>
                                <div class="row">
                                    <div class=" col-12 mx-auto ">
                                        <h3>Table Product</h3>
                                        <a href="/admin/product/create">Creat a Product</a>
                                        <hr>
                                    </div>
                                    <table class="table table-bordered table-hover ">
                                        <thead>
                                            <tr>
                                                <td>ID</td>
                                                <td>Name</td>
                                                <td>Price</td>
                                                <td>Factory</td>
                                                <td>Action</td>
                                            </tr>
                                        </thead>
                                        <!-- <tbody>
                                            <c:forEach var="user" items="${users1}">
                                                <tr>
                                                    <td>${user.id}</td>
                                                    <td>${user.email}</td>
                                                    <td>${user.fullname}</td>
                                                    <td>${user.address}</td>
                                                    <td>${user.role.name}</td>
                                                    <td>
                                                        <a href="/admin/user/${user.id}"><button
                                                                class="btn - btn-danger ">View</button></a>
                                                        <a href="/admin/user/update/${user.id}"><button
                                                                class="btn - btn-success  ">Update</button></a>
                                                        <a href="/admin/user/delete/${user.id}"><button
                                                                class="btn - btn-danger  ">Delete</button></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody> -->
                                    </table>
                                </div>
                            </div>
                        </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
        </body>

        </html>