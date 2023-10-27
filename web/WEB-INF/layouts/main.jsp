<%-- 
    Document   : main.jsp
    Created on : Oct 7, 2023, 3:59:59 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meet My Lecturer</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            >
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css"/>
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

            @media screen and (max-width: 600px) {
                .cus {
                    background: none!important;
                    color: #333!important;
                }
            }
        </style>
    </head>
    <body>
        <c:if test="${users==null}">
            <jsp:forward page="/users/login.do" />
        </c:if>
        <c:if test="${users!=null}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-light">
                <a class="navbar-brand" href="#">
                    <img src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png" width="100" class="d-inline-block align-top" alt="Logo">
                </a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <c:if test="${roleID.equals('1')}"> 
                                <a class="cus nav-link" href="<c:url value="/bookings/list.do" />">
                                    <i class="fas fa-calendar-alt"></i> View Bookings
                                </a>
                            </c:if>

                            <c:if test="${roleID.equals('2 ')}"> 
                                <a class="cus nav-link" href="<c:url value="/bookings/listOfLecturer.do" />">
                                    <i class="fas fa-calendar-alt"></i> View Bookings
                                </a>
                            </c:if>

                            <c:if test="${roleID.equals('3 ')}"> 
                                <a class="cus nav-link" href="<c:url value="/bookings/listOfStudent.do" />">
                                    <i class="fas fa-calendar-alt"></i> View Bookings
                                </a>
                            </c:if>

                        </li>
                        <li class="nav-item">
                            <c:choose>
                                <c:when test="${roleID.equals('1')}">
                                    <a class="cus nav-link" href="<c:url value="/requests/list.do" />">
                                        <i class="fas fa-file"></i> Requests
                                    </a>
                                </c:when>

                                <c:when test="${roleID.equals('2 ')}">
                                    <a class="cus nav-link" href="<c:url value="/requests/listOfLecturer.do" />">
                                        <i class="fas fa-file"></i> Requests
                                    </a>

                                </c:when>

                                <c:when test="${roleID.equals('3 ')}">
                                    <a class="cus nav-link" href="<c:url value="/requests/listOfStudent.do" />">
                                        <i class="fas fa-file"></i> Requests
                                    </a>
                                </c:when>
                            </c:choose>


                        </li>

                        <li class="nav-item">
                            <c:if test="${roleID.equals('1')}"> 
                                <a class="cus nav-link" href="<c:url value="/freeSlots/list.do" />">
                                    <i class="fas fa-calendar-alt"></i> Free Slots
                                </a>
                            </c:if>

                            <c:if test="${roleID.equals('2 ')}"> 
                                <a class="cus nav-link" href="<c:url value="/freeSlots/listOfLecturer.do" />">
                                    <i class="fas fa-calendar-alt"></i> Free Slots
                                </a>
                            </c:if>

                            <c:if test="${roleID.equals('3 ')}"> 
                                <a class="cus nav-link" href="<c:url value="/freeSlots/listOfStudent.do" />">
                                    <i class="fas fa-calendar-alt"></i> Free Slots
                                </a>
                            </c:if>
                        </li>

                        <li class="nav-item">
                            <a class="cus nav-link" href="<c:url value="/users/logout.do" />">
                                <i class="fas fa-sign-out-alt"></i> Logout
                            </a>
                        </li>
                        <li class="nav-item" id="user-icon">
                            <c:if test="${roleID.equals('1')}">
                                <a class="nav-link text-black" href="<c:url value="/users/list.do"/>">
                                    <i class="fas fa-user"></i> Users
                                </a>
                            </c:if>

                        </li>
                    </ul>
                </div>
            </nav>
            <div class="btn-group ml-5 mt-3">
                <a href="https://www.example.com" class="btn btn-primary btn-sm fixed-bottom fixed-right mb-4 mr-4">
                    <i class="fas fa-arrow-left"></i> Back
                </a>
            </div>
            <!--view-->
            <div class="row content">
                <div class="col">
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
                </div>
            </div>
        </c:if>
        <!--footer-->
        <!--        <div class="row footer">
                    <div class="col">
                        Copyright &copy; by FPT Students
                    </div>
                </div>-->
        <!-- Thêm liên kết đến Bootstrap JS và jQuery -->
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

