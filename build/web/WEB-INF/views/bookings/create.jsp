<%-- 
    Document   : create
    Created on : Oct 24, 2023, 9:19:49 PM
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
        <h2 style="display: flex; justify-content: center">Booking Creation</h2>
        <div class="container mt-5">
            <form action="<c:url value="/bookings/create_handler.do"/>" >
                <div class="form-group row">
                    <label for="studentID" class="col-md-2 col-form-label">Student ID:</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="studentID" placeholder="Student ID" name="studentID"  value="${users.userID}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="freeSlotID" class="col-md-2 col-form-label">Free Slots ID:</label>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="freeSlotID" placeholder="Free Slot ID" name="freeSlotID">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="status" class="col-md-2 col-form-label">Status:</label>
                    <div class="col-md-10">
                        <select class="form-control" id="status" name="status">
                            <option value="true">Yes</option>
                            <option value="false">No</option> 
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-10 offset-md-2">
                        <button type="submit" class="btn btn-success btn-lg rounded-pill" name="op" value="create">Create</button>
                        <button type="submit" class="btn btn-outline-danger btn-lg rounded-pill" name="op" value="cancel">Cancel</button>
                    </div>
                </div>
                 <i style="color:red">${message}</i>
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

