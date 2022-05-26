<%--
  Created by IntelliJ IDEA.
  User: Cường Dew
  Date: 26/05/2022
  Time: 09:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.t2010a.account.entity.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) request.getAttribute("account");
    if(account == null){
        account = new Account();
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/style.css">
    <meta name="robots" content="noindex, follow">
    <script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js" nonce="db61fff7-d192-4eda-bd24-2a3ce9d4b2ee"></script>
    </head>
<body>
<div class="main">
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <%
                    if(account.getListErrors().size() > 0){
                    %>
                    <h6 class="error_code">

                        Please enter information below
                        <ul>
                            <%for (int i = 0; i < account.getListErrors().size(); i++) {
                            %>
                            <li><%=account.getListErrors().get(i)%></li>
                            <%
                                }%>
                        </ul>
                    </h6>
                    <%}%>
                    <h2 class="form-title">Register</h2>
                    <form method="post" class="register-form" id="register-form">
                        <div class="form-group">
                            <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="username" id="username" placeholder="Userame" value="<%=account.getUsername()%>">
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" placeholder="Your Email" value="<%=account.getEmail()%>">
                        </div>
                        <div class="form-group">
                            <label for="password"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="password" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="Confirm Password"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="Confirm Password" id="Confirm Password" placeholder="Confirm Password">
                        </div>
                        <div class="form-group">
                            <label for="phone"><i class="zmdi zmdi-email"></i></label>
                            <input type="text" name="phone" id="phone" placeholder="Your Phone" value="<%=account.getPhone()%>">
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term">
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" value="Register">
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                    <a href="#" class="signup-image-link">I am already member</a>
                </div>
            </div>
        </div>
    </section>
</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
