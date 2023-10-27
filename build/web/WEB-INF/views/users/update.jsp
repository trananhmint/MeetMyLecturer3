<%-- 
    Document   : update
    Created on : Oct 23, 2023, 10:45:15 PM
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
        <h2 style="display: flex; justify-content: center">User Update</h2>
        <div class="container mt-5">
            <form action="<c:url value="/users/update_handler.do"/>">
                <div class="form-group">
                    <label for="userID">User ID:</label>
                    <input disabled type="text" class="form-control" id="userID" placeholder=" User ID" value="${users.userID}">
                    <input type="hidden" name="userID" value="${users.userID}">
                </div>
                <div class="form-group">
                    <label for="userName">Full name:</label>
                    <input type="text" class="form-control" id="userName" placeholder="User Name" name="userName" value="${users.userName}">
                </div>
                <div class="form-group">
                    <label for="userEmail">Email:</label>
                    <input type="text" class="form-control" id="userEmail" placeholder="User Email" name="userEmail" value="${users.userEmail}">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="${users.password}">
                </div>
                <div class="form-group">
                    <label for="roleID">Role:</label>
                    <select class="form-control" id="roleID" name="roleID" value="${users.roleID}">
                        <option value="3">Student</option>
                        <option value="2">Lecturer</option>
                        <option value="1">Admin</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="userStatus">Status:</label>
                    <select class="form-control" id="userStatus" name="userStatus" value="${users.userStatus}">
                        <option value="true">Active</option>
                        <option value="false">Unactive</option> 
                    </select>
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
