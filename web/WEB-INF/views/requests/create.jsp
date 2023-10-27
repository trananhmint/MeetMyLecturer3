<%-- 
    Document   : create
    Created on : Oct 24, 2023, 10:40:31 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
        <label>User ID: </label>
        <input type="text"><br><br>
        <label>Full name: </label>
        <input type="text"><br><br>
        <label>Email: </label>
        <input type="text"><br><br>
            <label>Role: </label>
            <select>  Ham if dat ngay day de hien option 
                <option value="3">Student</option>
                <option value="2">Lecturer</option>
                <option value="1">Admin</option>
            </select><br><br>
        <label>Password: </label>
        <input type="text"><br><br>
        <input type="submit" value="Create">
        </form>
    </body>
</html>-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Page</title>
        <!-- Thêm liên kết đến Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Include Font Awesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
        <style>
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
        <div class="container mt-5">
            <h2 style="display: flex; justify-content: center">Request Creation</h2>
            <form action="<c:url value="/requests/create_handler.do"/>">
                <div class="form-group row">
                    <label for="subjectCode" class="col-md-2 col-form-label"><strong>Subject Code:</strong></label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="subjectCode" placeholder="Subject Code" name="subjectCode" >
                    </div>
                </div>

                <div class="form-group row">
                    <label for="studentID" class="col-md-2 col-form-label"><strong>Student ID:</strong></label>
                    <div class="col-md-10">
                        <input disabled type="text" class="form-control" id="studentID" placeholder="Student ID" value="${users.userID}" >
                        <input type="hidden" name="studentID" value="${users.userID}">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lecturerID" class="col-md-2 col-form-label"><strong>Lecturer ID:</strong></label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="lecturerID" placeholder="Lecturer ID" name="lecturerID" >
                    </div>
                </div>

                <div class="form-group row">
                    <label for="day" class="col-md-2 col-form-label"><strong>Day:</strong></label>
                    <div class="col-md-8">
                        <input type="date" class="form-control" id="day" placeholder="Day" name="day">
                    </div>
                    <a class="btn btn-primary col-sm-2" href="<c:url value="/timetables/list.do"/>">View Timetable</a>
                </div>


                <div class="form-group row">
                    <label for="start" class="col-md-2 col-form-label"><strong>Start time:</strong></label>
                    <div class="col-md-10">
                        <input type="time" class="form-control" id="start" placeholder="Start Time" name="start">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="end" class="col-md-2 col-form-label"><strong>End time:</strong></label>
                    <div class="col-md-10">
                        <input type="time" class="form-control" id="end" placeholder="End Time" name="end">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="description" class="col-md-2 col-form-label"><strong>Description:</strong></label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="description" placeholder="Description" name="description">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="status" class="col-md-2 col-form-label"><strong>Status:</strong></label>
                    <div class="col-md-10">
                        <select class="form-control" id="status" name="status">
                            <option value="true">Yes</option>
                            <option value="false">No</option> 
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-10 offset-md-2">
                        <button type="submit" class="btn btn-success" name="op" value="create">Send Request</button>
                        <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel</button>
                    </div>
                </div>
            </form>
            <i style="color:red">${message}</i>
        </div>       <!-- Thêm liên kết đến Bootstrap JS và jQuery -->
        <script
            src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-KyZXEAg3QhqLMpG8r+J9pAEz6/LnYV5TOqDGIbpbzFq8qz5S7fF46kSEBzav6U7xj"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-xV6VaRqI1z7MOJwz5Mz6f3GC6A5wA5CKh5uFfxn5g5crf7Sc6Pe4OdU8paHdFuI"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
