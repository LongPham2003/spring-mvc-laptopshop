<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarfile");
                        const orgImage = "${newProduct.image}"
                        if (orgImage) {
                            const urlImage = "/images/product/" + orgImage;
                            $("#avatarPreview").attr("src", urlImage);
                            $("#avatarPreview").css({ "display": "block" });
                        }

                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manager product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">product</li>
                                </ol>
                                <div class="row">
                                    <div class="col-md-6 col-12 mx-auto ">
                                        <h3>Create a Product</h3>
                                        <hr>
                                        <form:form method="post" action="/admin/product/update"
                                            modelAttribute="newProduct" class="row" enctype="multipart/form-data">
                                            <div class="mb-3" style="display: none;">
                                                <label class="form-label">Id:</label>
                                                <form:input type="text" class="form-control" path="id" />
                                            </div>

                                            <div class="mb-3 col-12 col-md-6">
                                                <label for="exampleInputPassword1" class="form-label">Name</label>
                                                <form:input type="" class="form-control" id="exampleInputPassword1"
                                                    path="name" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <label for="exampleInputEmail1" class="form-label">Price</label>
                                                <form:input type="" class="form-control" id="exampleInputEmail1"
                                                    aria-describedby="emailHelp" path="price" />
                                            </div>
                                            <div class="mb-3 ">
                                                <label for="exampleInputPassword1" class="form-label">Detail
                                                    description</label>
                                                <form:input type="text" rows="5" class="form-control"
                                                    id="exampleInputPassword1" path="detailDesc" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <label for="exampleInputEmail1" class="form-label">Short
                                                    description</label>
                                                <form:input type="" class="form-control" id="exampleInputEmail1"
                                                    aria-describedby="emailHelp" path="shortDesc" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-6 ">
                                                <label for="exampleInputPassword1" class="form-label">Quantity</label>
                                                <form:input type="" class="form-control" id="exampleInputPassword1"
                                                    path="quantity" />
                                            </div>
                                            <div class=" mb-3 col-12 col-md-6 ">
                                                <label for="exampleInputPassword1" class="form-label">Factory</label>
                                                <form:select class="form-select" id="inputGroupSelect01" path="factory">
                                                    <form:option value="Apple">Apple</form:option>
                                                    <form:option value="Asus">Asus</form:option>
                                                    <form:option value="Asus">Lennovo</form:option>
                                                </form:select>
                                            </div>
                                            <div class=" mb-3 col-12 col-md-6 ">
                                                <label for="exampleInputPassword1" class="form-label">Target</label>
                                                <form:select class="form-select" id="inputGroupSelect01" path="target">
                                                    <form:option value="gamming">Gaming</form:option>
                                                    <form:option value="office">Văn Phòng</form:option>
                                                </form:select>
                                            </div>
                                            <div class="mb-3  ">
                                                <label for="exampleInputPassword1" class="form-label">Avatar</label>
                                                <input type="file" class="form-control" id="avatarfile"
                                                    aria-describedby="inputGroupFileAddon04" aria-label="Upload"
                                                    accept=".png, .jpg, .jpeg" name="productImgFile" />
                                            </div>
                                            <div class="mb-3 col-12 col-md-3">
                                                <img style="max-height: 350px; display: none;" src="" alt="avatar"
                                                    id="avatarPreview">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                        </form:form>
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