<%-- 
    Document   : listOfLecturer
    Created on : Oct 24, 2023, 12:49:51 PM
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
            <c:when test="${roleID.equals('2 ')}">
                <div class="container mt-5">
                    <h1>Lecturer: ${users.userName} | Semester: ${semseter} Fall23 ${date}</h1>
                    <form action="<c:url value="/requests/searchByLecturer.do"/>">    
                        <div class="row align-items-center">
                            <div class="form-group">
                                <input type="text" class="form-control " placeholder="Search student or subject" name="ID">
                            </div>
                            <div class="form-group" >
                                <select class="form-control" name="select">
                                    <option value="subjectCode">Subject Code</option>
                                    <!--<option value="lecturer">Lecturer</option>--> 
                                    <option value="student">Student</option> 
                                </select>
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="semester">
                                    <option name="semester" value="SP22">SPRING2022</option>
                                    <option name="semester" value="SU22">SUMMER2022</option> 
                                    <option name="semester" value="FA22">FALL2022</option> 
                                    <option name="semester" value="SP23">SPRING2023</option>
                                    <option name="semester" value="SU23">SUMMER2023</option> 
                                    <option name="semester" value="FA23">FALL2023</option> 
                                </select>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary form-control" type="submit" name="select" value="${requestScope[select]}">Search</button>
                            </div>
                            <h5 style="color: red">${msg}</h5>
                        </div>

                        <div class="row justify-content-center mt-5">

                            <table class="table text-center table-striped table-bordered">
                                <thead class="thead-orange">
                                    <tr>
                                        <th>ID</th>
                                        <th>Subject Code</th>
                                        <th>Start Time</th>
                                        <th>End Time</th>
                                        <th>Description</th>
                                        <th>Student ID</th>
                                        <th>Lecturer ID</th>
                                        <th>Status</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="requests" items="${list}" varStatus="loop">
                                        <tr>
                                            <td>${requests.ID}</td>
                                            <!--<td>${requests.requestID}</td>-->
                                            <td>${requests.subjectCode}</td>
                                            <td>${requests.startTime}</td>
                                            <td>${requests.endTime}</td>
                                            <td>${requests.description}</td>
                                            <td>${requests.studentID}</td>
                                            <td>${requests.lecturerID}</td>
                                            <c:if test="${requests.status==0}">
                                                <td style="color: darkcyan; font-weight: 600">${requests.statusText}</td>
                                            </c:if>
                                            <c:if test="${requests.status==1}">
                                                <td style="color: green; font-weight: 600">${requests.statusText}</td>
                                            </c:if>
                                            <c:if test="${requests.status==2}">
                                                <td style="color: crimson; font-weight: 600">${requests.statusText}</td>
                                            </c:if>

                                            <td>
                                                <div class="btn-group" role="group" aria-label="Accept Decline Buttons">
                                                    <a class="btn btn-success" href="<c:url value="/requests/update_handlerByLecturer.do?ID=${requests.ID}&status=${1}&op=update" />"><i class="bi bi-pencil-square"></i> Accept</a>
                                                    <a class="btn btn-danger" href="<c:url value="/requests/update_handlerByLecturer.do?ID=${requests.ID}&status=${2}&op=update" />"><i class="bi bi-pencil-square"></i> Deny</a>
                                                    <!--<a class="btn btn-danger" href="<c:url value="/requests/delete.do?ID=${requests.ID}"/>"><i class="bi bi-trash3"></i>Delete</a>-->
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!--<a style=" width: 70px" class="btn btn-primary" href="<c:url value="/requests/create.do"/>"><i class="fa-solid fa-circle-plus"></i></a>-->
                        </div>
                    </form>
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
