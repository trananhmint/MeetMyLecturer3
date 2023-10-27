<%-- 
    Document   : StudentSearch
    Created on : Oct 20, 2023, 12:31:14 PM
    Author     : overw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
            .thead-orange {
                background-color: #f27125;
            }
        </style>
    </head>
    <body>
        
        <div class="btn-group ml-5 mt-3">
            <a href="https://www.example.com" class="btn btn-primary btn-sm fixed-bottom fixed-right mb-4 mr-4">
                <i class="fas fa-arrow-left"></i> Back
            </a>
        </div>
        <div class="container mt-5">
            <h1>Lecture: LamNN15${lecturename} | Semester: ${semseter} Fall23 ${date}</h1>
            <div class="row align-items-center">
                <div class="form-group">
                    <input type="text" class="form-control " placeholder="Search name of lecture...">
                </div>
                <div class="form-group">
                    <select class="form-control">
                        <option>Subject</option>
                        <option>Shoes</option>
                        <option>Clothing</option>
                        <option>Accessories</option>
                    </select>
                </div>
                <div class="form-group">
                    <select class="form-control">
                        <option>Semester</option>
                        <option>Small</option>
                        <option>Medium</option>
                        <option>Large</option>
                        <option>X-Large</option>
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary form-control">Search</button>
                </div>
            </div>
            <div class="row justify-content-center mt-5">
                <table class="table table-striped table-bordered">
                    <thead class="thead-orange">
                        <tr>
                            <th scope="col">Slot</th>
                            <th scope="col">Subject</th>
                            <th scope="col">Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- foreach jstl o day -->
                        <tr>
                            <td>A1${slot}</td>
                            <td>SWP391${email}</td>
                            <td>Monday & Thursday${dateBookedInDb},9:00 - 10:00${timeInDB}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- Thêm liên kết đến Bootstrap JS và jQuery -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-xV6VaRqI1z7MOJwz5Mz6f3GC6A5wA5CKh5uFfxn5g5crf7Sc6Pe4OdU8paHdFuI" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>