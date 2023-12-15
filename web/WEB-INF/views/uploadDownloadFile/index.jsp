<%-- 
    Document   : index
    Created on : Jun 26, 2023, 9:22:12 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="<c:url value="/css/fileInput.css"/>" rel="stylesheet" type="text/css"/>       
       <!--<link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css"/>-->
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>

    <i>${message}</i>
    <body>
        <div class="row bg-title">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Select Files to Upload: </h4>
                </div>
                <!--                <form method="post" enctype="multipart/form-data">
                                    Select File to Upload: 
                                    <br>
                                    <input type="file" name="fileName">
                                    <br>
                                    <input type="submit" value="Upload">
                                    <i style="color: orange">${message}</i>
                                </form>-->
                <form method="post" enctype="multipart/form-data">
                    <div class="container">
                        <div class="button-wrap">
                            <!-- Link the label to the input using the for and id attributes -->
                            <label class="button" for="upload">Upload File</label>
                            <input id="upload" type="file" name="fileName">
                            <br>
                            <button  class="btn btn-info btn-block mb-2 ml-2" value="Upload">
                                <i class="bi bi-file-earmark-spreadsheet"></i> Upload
                            </button>
                            <i style="color: orange">${message}</i>
                        </div>
                    </div>
                </form>
                <!--                <form class="form-inline" method="post" enctype="multipart/form-data">
                                    <div class="form-group mb-2">
                                        <div class="custom-file">
                                            <div class="input-group">
                                                <label class="input-group-btn">
                                                    <span class="btn btn-info">
                                                        Browse: <input type="file" style="display: none;" id="fileName" multiple name="fileName" onchange="updateFileName()">
                                                    </span>
                                                </label>
                                                <input type="text" class="form-control" id="inputBox" readonly name="fileName">
                                            </div>
                                        </div>
                                        <p></p>
                                        <button  class="btn btn-info btn-block mb-2 ml-2" value="Upload">
                                            <i class="bi bi-file-earmark-spreadsheet"></i> Upload
                                        </button>
                                    </div>
                                    <br>
                                    <i style="color: red">${message}</i>
                                </form>-->
            </div>
        </div>

        <!-- Thêm liên kết đến Bootstrap JS và jQuery -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-xV6VaRqI1z7MOJwz5Mz6f3GC6A5wA5CKh5uFfxn5g5crf7Sc6Pe4OdU8paHdFuI" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
