<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Sign Up</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style type="text/css">

	.login-form {
		
    	width: 350px;
    	height:150px;
    	top:50px;
    	left:50px;
    	margin: 180px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>
<body>
<%
response.setHeader("cache-control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("username")==null)
	response.sendRedirect("Login.html");
%>
<div class="login-form">
    <form action="SignUpOtp" method="post">
        <h2 class="text-center">Enter OTP</h2>       
        <div class="form-group">
            <input type="text" id="1" class="form-control" placeholder="OTP sent to registered mail id" name="otp" >
        </div>
 		<div class="form-group">
            <button type="submit" name="sign-up" class="btn btn-primary btn-block" >Submit</button>
        </div>        
    </form>
</div>
</body>
</html>      