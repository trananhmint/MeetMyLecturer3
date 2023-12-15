<%-- 
    Document   : update
    Created on : Oct 24, 2023, 10:08:29 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Form Page</title>
        <!-- Thêm liên kết đến Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Include Font Awesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

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
    <body >
        <h2 style="display: flex; justify-content: center">Changing Booking</h2>
        <div class="container mt-5">
            <form action="<c:url value="/bookings/update_handler.do"/>">
                <div class="form-group">
                    <label for="ID"> ID:</label>
                    <input disabled type="text" class="form-control" id="ID" value="${bookings.ID}">
                    <input type="hidden" name="ID" value="${bookings.ID}">
                </div>

                <div class="form-group">
                    <label for="bookingID"> Booking ID:</label>
                    <input disabled type="text" class="form-control" id="bookingID" value="${bookings.bookingID}">
                    <input type="hidden" name="bookingID" value="${bookings.bookingID}">
                </div>

                <div class="form-group">
                    <label for="studentID"> Student ID:</label>
                    <input disabled type="text" class="form-control" id="studentID" value="${bookings.studentID}">
                    <input type="hidden" name="studentID" value="${bookings.studentID}">
                </div>

                <div class="form-group">
                    <label for="freeSlotID"> Free Slot ID:</label>
                    <input disabled type="text" class="form-control" id="freeSlotID" value="${bookings.freeSlotID}">
                    <input type="hidden" name="freeSlotID" value="${bookings.freeSlotID}">
                </div>
                <c:choose>
                    <c:when test="${roleID.equals('1')}">
                        <div class="form-group">
                            <label for="stuPresence">Student Presence:</label>
                            <select class="form-control" id="stuPresence" name="stuPresence" value="${bookings.stuPresence}">
                                <option value="true">Attended</option>
                                <option value="false">Absent</option> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="lecPresence">Lecturer Presence:</label>
                            <select class="form-control" id="lecPresence" name="lecPresence" value="${bookings.lecPresence}">
                                <option value="true">Attended</option>
                                <option value="false">Absent</option> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="status">Status:</label>
                            <select class="form-control" id="status" name="status" value="${bookings.status}">
                                <option value="true">Accepted</option>
                                <option value="false">Declined</option> 
                            </select>
                        </div>
                    </c:when>

                    <c:when test="${roleID.equals('2 ')}">
                        <div class="form-group">
                            <label for="stuPresence">Student Presence:</label>
                            <select class="form-control" id="stuPresence" name="stuPresence" value="${bookings.stuPresence}">
                                <option value="true">Attended</option>
                                <option value="false">Absent</option> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="lecPresence">Lecturer Presence:</label>
                            <select class="form-control" id="lecPresence" name="lecPresence" value="${bookings.lecPresence}">
                                <c:if test="${bookings.lecPresence==true}">
                                    <option value="true">Attended</option>
                                </c:if>
                                <c:if test="${bookings.lecPresence==false}">
                                    <option value="false">Absent</option>
                                </c:if>

                            </select>
                        </div>
                        <div class="form-group">
                            <label for="status">Status:</label>
                            <select class="form-control" id="status" name="status" value="${bookings.status}">
                                <c:if test="${bookings.status==true}">
                                    <option value="true">Accepted</option>
                                </c:if>

                                <c:if test="${bookings.status==false}">
                                    <option value="false">Declined</option> 
                                </c:if>s
                            </select>
                        </div>

                    </c:when> 

                    <c:when test="${roleID.equals('3 ')}">
                        <div class="form-group">
                            <label for="lecPresence">Lecturer Presence:</label>
                            <select class="form-control" id="lecPresence" name="lecPresence" value="${bookings.lecPresence}">
                                <option value="true">Attended</option>
                                <option value="false">Absent</option> 
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="stuPresence">Student Presence:</label>
                            <select class="form-control" id="stuPresence" name="stuPresence" value="${bookings.stuPresence}">
                                <c:if test="${bookings.stuPresence==true}">
                                    <option value="true">Attended</option>
                                </c:if>
                                <c:if test="${bookings.stuPresence==false}">
                                    <option value="false">Absent</option>
                                </c:if>

                            </select>
                        </div>
                        <div class="form-group">
                            <label for="status">Status:</label>
                            <select class="form-control" id="status" name="status" value="${bookings.status}">
                                <c:if test="${bookings.status==true}">
                                    <option value="true">Accepted</option>
                                </c:if>

                                <c:if test="${bookings.status==false}">
                                    <option value="false">Declined</option> 
                                </c:if>s
                            </select>
                        </div>
                    </c:when>
                </c:choose>




                <button type="submit" class="btn btn-success" name="op" value="update">Update</button>
                <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel</button>
            </form>
        </div>
        <!-- Thêm liên kết đến Bootstrap JS và jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+J9pAEz6/LnYV5TOqDGIbpbzFq8qz5S7fF46kSEBzav6U7xj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-xV6VaRqI1z7MOJwz5Mz6f3GC6A5wA5CKh5uFfxn5g5crf7Sc6Pe4OdU8paHdFuI" crossorigin="anonymous"></script>
    </body>
</html>

