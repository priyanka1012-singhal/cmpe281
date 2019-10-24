<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>CloudSense | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
     <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">
 <div>
      <div >
        <a href="#"><b>SignIn</b> to </a><b>CloudSense</b>
      </div><!-- /.login-logo -->
      <div >
        <p >Sign in to start your session</p>
 
    <form name='login' action="login" method='POST'>
      <center>
        <table>
       
            <tr>
                <td><label>UserName:</label></td>
                <td><input class="form-control" type='text' name='username' ></td>
            </tr>
            <tr>
               <td>Password:</td>
                <td><input class="form-control" type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><button type="submit" value="submit" />Login</button></td>
            </tr>
            
        </table>
        </center>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
     <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->
 </div>
</body>
<style>    
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    text-align: center;
}

button:hover {
    opacity: 0.8;
}
.container {
   margin: auto;
   text-align: center;
    width: 50%;
    border: 3px solid green;
    padding: 10px;
}
label{
	text-align: center;
}
</style>

</html>