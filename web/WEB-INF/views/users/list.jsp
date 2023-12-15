<%-- 
    Document   : list
    Created on : Oct 17, 2023, 6:18:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!--<link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css"/>-->
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

        <style>
            .card-body > div {
                margin-bottom: 0.2rem;
            }

            .card-body > .btn-book {
                margin-top: 1rem;
            }

            .form-group {
                margin: 0.4rem;
                border-radius: 35px;
            }

            .form-control {
                border-radius: 35px;
            }

            .cus {
                background-color: #f27125;
                margin: 0 0.5rem;
                border-radius: 5px;
                color: #fff!important;
            }

            .text-black {
                color: #333!important;
                font-size: 18px;
            }

            .navbar {
                padding: 2rem;
                border-bottom: 1px solid black;
            }

            .thead-orange {
                background-color: #f27125;
            }

            @media screen and (max-width: 980px) {
                .cus {
                    background: none!important;
                    color: #333!important;
                }
            }
        </style>
    </head>
    <body>
        <!--        <nav class="navbar navbar-expand-lg navbar-dark bg-light">
                    <a class="navbar-brand" href="#">
                        <img src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png" width="100" class="d-inline-block align-top" alt="Logo">
                    </a>
        
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
        
                    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="cus nav-link" href="#">
                                    <i class="fas fa-calendar-alt"></i> View Booking
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="cus nav-link" href="#">
                                    <i class="fas fa-file"></i> Request
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="cus nav-link" href="#">
                                    <i class="fas fa-sign-out-alt"></i> Logout
                                </a>
                            </li>
                            <li class="nav-item" id="user-icon">
                                <a class="nav-link text-black" href="#">
                                    <i class="fas fa-user"></i> User
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="btn-group ml-5 mt-3">
                    <a href="https://www.example.com" class="btn btn-primary btn-sm fixed-bottom fixed-right mb-4 mr-4">
                        <i class="fas fa-arrow-left"></i> Back
                    </a>
                </div>-->

        <c:choose>
            <c:when test="${roleID.equals('1')}">
                <div class="container mt-5">
        <!--            <h1>Lecture: LamNN15${lecturename} | Semester: ${semseter} Fall23 ${date}</h1>
                    <div class="row align-items-center">
                        <div class="form-group">
                            <input type="text" class="form-control " placeholder="Search name of lecture...">
                        </div>
                        <div class="form-group">
                            <select class="form-control">
                                <option>Subject</option>
                                <option>Shoes</option>
                                <option>Clothing</option>
                                <option>Accessories</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <select class="form-control">
                                <option>Semester</option>
                                <option>Small</option>
                                <option>Medium</option>
                                <option>Large</option>
                                <option>X-Large</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary form-control">Search</button>
                        </div>
                    </div>-->

                    <div class="row justify-content-center mt-5">

                        <table class="table text-center table-striped table-bordered">
                            <thead class="thead-orange">
                                <tr>
                                    <th>No.</th>
                                    <th>User ID</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Status</th>
                                    <th>Role Name</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="users" items="${list}" varStatus="loop">
                                    <tr>
                                        <td>${loop.count}</td>
                                        <td>${users.userID}</td>
                                        <td>${users.userName}</td>
                                        <td>${users.userEmail}</td>
                                        <td>${users.statusText}</td>
                                        <td>${users.roleName}</td>
                                        <td>
                                            <div class="btn-group" role="group" aria-label="Accept Decline Buttons">
                                                <a class="btn btn-success" href="<c:url value="/users/update.do?userID=${users.userID}" />"><i class="bi bi-pencil-square"></i> Update</a>
                                                <a class="btn btn-danger" href="<c:url value="/users/delete.do?userID=${users.userID}" />"><i class="bi bi-trash3"></i>Delete</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <a style=" width: 70px" class="btn btn-primary" href="<c:url value="/users/create.do"/>"><i class="fa-solid fa-circle-plus"></i></a>
                    </div>

                </div>
            </c:when>
        </c:choose>
        <!-- Thêm liên kết đến Bootstrap JS và jQuery -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-xV6VaRqI1z7MOJwz5Mz6f3GC6A5wA5CKh5uFfxn5g5crf7Sc6Pe4OdU8paHdFuI" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>