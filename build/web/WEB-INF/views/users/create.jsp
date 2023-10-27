<%-- 
    Document   : create1
    Created on : Oct 23, 2023, 5:28:40 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Page</title>
        <!-- Thêm liên kết đến Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            >
        <!-- Include Font Awesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
       
    </head>
    <body>
       <h2 style="display: flex; justify-content: center">User Creation</h2>
        <div class="container mt-5">
            <form action="<c:url value="/users/create_handler.do"/>" >
                <div class="form-group row">
                    <label for="userID" class="col-md-2 col-form-label">User ID:</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="userID" placeholder="User ID" name="userID" >
                    </div>
                </div>
                <div class="form-group row">
                    <label for="userName" class="col-md-2 col-form-label">Full Name:</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="userName" placeholder="Full Name" name="userName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="userEmail" class="col-md-2 col-form-label">Email:</label>
                    <div class="col-md-10">
                        <input type="email" class="form-control" id="userEmail" placeholder="Email" name="userEmail">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="roleID" class="col-md-2 col-form-label">Role:</label>
                    <div class="col-md-10">
                        <select class="form-control" id="roleID" name="roleID">
                            <option value="3">Student</option>
                            <option value="2">Lecturer</option>
                            <option value="1">Admin</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-md-2 col-form-label">Password:</label>
                    <div class="col-md-10">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="userStatus" class="col-md-2 col-form-label">Status:</label>
                    <div class="col-md-10">
                        <select class="form-control" id="userStatus" name="userStatus">
                            <option value="true">Active</option>
                            <option value="false">Inactive</option> 
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-10 offset-md-2">
                        <button type="submit" class="btn btn-success btn-lg rounded-pill" name="op" value="create">Create</button>
                        <button type="submit" class="btn btn-outline-danger btn-lg rounded-pill" name="op" value="cancel">Cancel</button>
                    </div>
                </div>
            </form>
        </div>       
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

