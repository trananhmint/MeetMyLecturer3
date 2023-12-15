<%-- 
    Document   : list
    Created on : Oct 25, 2023, 2:59:50 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Thêm liên kết đến Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Include Font Awesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
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
                </nav>-->
        <c:choose>
            <c:when test="${roleID.equals('1')}">
                <div class="container mt-5">
                    <h1>Admin:${users.userName} | Semester: ${semseter} Fall23 ${date}</h1>
                    <form action="<c:url value="/freeSlots/search.do"/>">
                        <div class="row justify-content-center ">
                            <div class="form-group">
                                <input type="text" class="form-control " placeholder="Search lecturer or subject" name="ID">
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="select">
                                    <option name="select" value="subjectCode">Subject Code</option>
                                    <option  name="select" value="lecturer">Lecturer</option> 
                                    <!--<option  name="select" value="student">Student</option>--> 
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
                            <c:forEach var="freeSlots" items="${list}" varStatus="loop">
                                <div class="col-md-4">
                                    <div class="card" style="width: 370px; height: 350px; border-radius: 5%; margin-bottom:10px">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between"><strong>Free Slot ID:</strong> <span class="ml-auto">${freeSlots.freeSlotID}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Subject Code:</strong> <span class="ml-auto">${freeSlots.subjectCode}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Lecturer ID:</strong> <span class="ml-auto">${freeSlots.lecturerID}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Start Time:</strong> <span class="ml-auto">${freeSlots.startTime}</span></div>
                                            <div class="d-flex justify-content-between"><strong>End Time:</strong> <span class="ml-auto">${freeSlots.endTime}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Password:</strong> <span class="ml-auto">${freeSlots.password}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Capacity:</strong> <span class="ml-auto">${freeSlots.booked}/${freeSlots.capacity}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Meet Link:</strong> <span class="ml-auto">${freeSlots.meetLink}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Count:</strong> <span class="ml-auto">${freeSlots.count}</span></div>

                                            <div class="d-flex justify-content-between btn-book">
                                                <!-- Added d-flex justify-content-between to create a flex container -->
                                                <!--<a href="#" class="btn btn-primary">BOOK</a>-->
                                                <a class="btn btn-success" href="<c:url value="/freeSlots/update.do?ID=${freeSlots.ID}" />"><i class="bi bi-pencil-square"></i> Update</a>
                                                <a  class="btn btn-danger" href="<c:url value="/freeSlots/delete.do?ID=${freeSlots.ID}" />"><i class="bi bi-trash3"></i>Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
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