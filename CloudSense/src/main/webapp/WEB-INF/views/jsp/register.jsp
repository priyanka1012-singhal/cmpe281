<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Sign Up to CloudSense</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="./dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="./plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="/index2.html"><b>SignUp </b></a> to <b>CloudSense</b>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Register to CloudSense</p>
        <form action="${pageContext.request.contextPath}/adduser" method="POST">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="First Name" name=firstName required/>
          </div>
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Last Name" name=lastName required/>
          </div>                  
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Username" name=userName required/>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="Password" name=password required/>
          </div>
           <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Email" name=userEmail required/>
          </div>
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Address" name= userAddress required/>
          </div>
           <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="City" name=userCity required/>
          </div>
           <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Zip" name= userZip required/>
          </div>          
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="State" name= userState required/>
          </div>  
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Country" name= userCountry required/>
          </div>
          <div class="form-group has-feedback">
         <select class="form-control" name="userRole">
           <option  value="Sensor Provider">I am a Sensor Provider</option>
           <option  value="Sensor Subscriber">I am a Sensor Subscriber</option>
         </select>            
          </div>                                                
          <div class="row">
            <div class="col-xs-8">    
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox"> Remember Me
                </label>
              </div>                        
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign Up</button>
            </div><!-- /.col -->
          </div>
        </form>
    </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.3 -->
    <script src="./plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="./bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="./plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>