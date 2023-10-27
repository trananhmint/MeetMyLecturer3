<%-- 
    Document   : update
    Created on : Oct 19, 2023, 3:02:57 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
        <h2 style="display: flex; justify-content: center">Free Slots Update</h2>
        <div class="container mt-5">
            <form action="<c:url value="/freeSlots/update_handler.do"/>">
                <div class="form-group">
                    <label for="ID"> ID:</label>
                    <input disabled type="text" class="form-control" id="ID" value="${freeSlots.ID}">
                    <input type="hidden" name="ID" value="${freeSlots.ID}">
                </div>
                <div class="form-group">
                    <label for="lecturerID">Lecturer ID:</label>
                    <input type="text" class="form-control" id="lecturerID" placeholder="Lecturer ID" name="lecturerID" value="${freeSlots.lecturerID}">
                </div>
                <div class="form-group">
                    <label for="subjectCode">Subject Code:</label>
                    <input type="text" class="form-control" id="subjectCode" placeholder="Subject Code" name="subjectCode" value="${freeSlots.subjectCode}">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="text" class="form-control" id="password" placeholder="Password" name="password" value="${freeSlots.password}">
                </div>

                <div class="form-group">
                    <label for="day">Day:</label>
                    <input type="date" class="form-control" id="day" placeholder="Day" name="day">
                </div>
                <div class="form-group">
                    <label for="start">Start Time:</label>
                    <input type="time" class="form-control" id="start" placeholder="Start Time" name="start">
                </div>
                <div class="form-group">
                    <label for="end">End Time:</label>
                    <input type="time" class="form-control" id="end" placeholder="End Time" name="end">
                </div>

                <div class="form-group">
                    <label for="capacity">Capacity:</label>
                    <input type="number" step="1" class="form-control" id="capacity" placeholder="Capacity" name="capacity" value="${freeSlots.capacity}">
                </div>
                <div class="form-group">
                    <label for="meetLink">Meet Link:</label>
                    <input type="text" class="form-control" id="meetLink" placeholder="Meet Link" name="meetLink" value="${freeSlots.meetLink}">
                </div>
                <div class="form-group">
                    <label for="count">Count:</label>
                    <input type="number" step="1" class="form-control" id="count" placeholder="Count" name="count" value="${freeSlots.count}">
                </div>


                <button type="submit" class="btn btn-success" name="op" value="update">Update</button>
                <button type="submit" class="btn btn-outline-danger" name="op" value="cancel">Cancel</button>
            </form>
        </div>
        <!-- Thêm liên kết đến Bootstrap JS và jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+J9pAEz6/LnYV5TOqDGIbpbzFq8qz5S7fF46kSEBzav6U7xj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-xV6VaRqI1z7MOJwz5Mz6f3GC6A5wA5CKh5uFfxn5g5crf7Sc6Pe4OdU8paHdFuI" crossorigin="anonymous"></script>
    </body>
</html>
