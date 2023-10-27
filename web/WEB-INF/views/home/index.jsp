<%-- 
    Document   : index
    Created on : Oct 16, 2023, 10:05:23 AM
    Author     : Dell
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

        <div class="container mt-5">
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
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Subject</th>
                            <th scope="col">Semester</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- foreach jstl o day -->
                        <tr>
                            <th scope="row">1 ${increase}</th>
                            <td>John Doe${username}</td>
                            <td>SWP391${email}</td>
                            <td>Fall23${Semester}</td>
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
