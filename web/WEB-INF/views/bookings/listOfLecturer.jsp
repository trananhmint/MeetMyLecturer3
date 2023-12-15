<%-- 
    Document   : listOfLecturer
    Created on : Oct 24, 2023, 5:47:33 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <!--        <div class="btn-group ml-5 mt-3">
                    <a href="https://www.example.com" class="btn btn-primary btn-sm fixed-bottom fixed-right mb-4 mr-4">
                        <i class="fas fa-arrow-left"></i> Back
                    </a>
                </div>-->
        <c:choose>
            <c:when test="${roleID.equals('2 ')}">
                <div class="container mt-5">
                    <h1>Lecturer:${users.userName} | Semester: ${semseter} Fall23 ${date}</h1>
                    <form action="<c:url value="/bookings/searchByLecturer.do"/>">
                        <div class="row justify-content-center ">
                            <div class="form-group">
                                <input type="text" class="form-control " placeholder="Search student or subject" name="ID">
                            </div>
                            <div class="form-group">
                                <select class="form-control" name="select">
                                    <option name="select" value="subjectCode">Subject Code</option>
                                    <!--<option  name="select" value="lecturer">Lecturer</option>--> 
                                    <option  name="select" value="student">Student</option> 
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
                            <c:forEach var="bookings" items="${list}" varStatus="loop">
                                <div class="col-md-4">
                                    <div class="card" style="width: 260px; height: 300px; border-radius: 5%; margin-bottom:10px ">
                                        <div class="card-body">
                                            <!--<div class="d-flex justify-content-between"><strong>ID:</strong> <span class="ml-auto">${bookings.ID}</span></div>-->
                                            <div class="d-flex justify-content-between"><strong>Booking ID:</strong> <span class="ml-auto">${bookings.bookingID}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Subject Code:</strong> <span class="ml-auto">${bookings.subjectCode}</span></div>
                                            <!--<div class="d-flex justify-content-between"><strong>Lecturer ID:</strong> <span class="ml-auto">${bookings.lecturerID}</span></div>-->
                                            <div class="d-flex justify-content-between"><strong>Student ID:</strong> <span class="ml-auto">${bookings.studentID}</span></div>
                                            <div class="d-flex justify-content-between"><strong>Free Slots:</strong> <span class="ml-auto">${bookings.freeSlotID}</span></div>
                                                <c:if test="${bookings.presenceTextOfStu.equals('Attended')}">
                                                <div class="d-flex justify-content-between"><strong>Student Presence:</strong> <span class="ml-auto" style="color: green">${bookings.presenceTextOfStu}</span></div>
                                                </c:if>
                                                <c:if test="${bookings.presenceTextOfStu.equals('Absent')}">
                                                <div class="d-flex justify-content-between"><strong>Student Presence:</strong> <span class="ml-auto" style="color: crimson">${bookings.presenceTextOfStu}</span></div>
                                                </c:if>

                                            <c:if test="${bookings.presenceTextOfLec.equals('Attended')}">
                                                <div class="d-flex justify-content-between"><strong>Lecturer Presence:</strong> <span class="ml-auto" style="color: green">${bookings.presenceTextOfLec}</span></div>
                                                </c:if>
                                                <c:if test="${bookings.presenceTextOfLec.equals('Absent')}">
                                                <div class="d-flex justify-content-between"><strong>Lecturer Presence:</strong> <span class="ml-auto" style="color: crimson">${bookings.presenceTextOfLec}</span></div>
                                                </c:if>
                                            <!--<div class="d-flex justify-content-between"><strong>Start Time:</strong> <span class="ml-auto">${bookings.startTime}</span></div>-->
                                            <!--<div class="d-flex justify-content-between"><strong>End Time:</strong> <span class="ml-auto">${bookings.endTime}</span></div>-->
                                            <c:if test="${bookings.statusText.equals('Accepted')}">
                                                <div class="d-flex justify-content-between"><strong>Status:</strong> <span class="ml-auto" style="color: green; font-weight:700">${bookings.statusText}</span></div>
                                                </c:if>
                                                <c:if test="${bookings.statusText.equals('Declined')}">
                                                <div class="d-flex justify-content-between"><strong>Status:</strong> <span class="ml-auto" style="color: crimson; font-weight:700">${bookings.statusText}</span></div>
                                                </c:if>     
                                            <div class="d-flex justify-content-end btn-book">
                                                <!-- Added d-flex justify-content-between to create a flex container -->
                                                <a class="btn btn-success" href="<c:url value="/bookings/update.do?ID=${bookings.ID}"/>"><i class="bi bi-pencil-square"></i>Change</a>
                                                <!--<a class="btn btn-danger" href="<c:url value="/bookings/delete.do?ID=${bookings.ID}"/>"><i class="bi bi-trash3"></i>Delete</a>-->
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

