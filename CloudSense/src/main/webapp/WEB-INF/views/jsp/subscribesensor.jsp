<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="java.util.*" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           View Sensor List
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Sensor</a></li>
            <li class="active">Subscribe Sensor</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                <h3 class="box-title">Sensor Data</h3>
                
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="example2" class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Sensor Name</th>
                        <th>Sensor Type</th>
                        <th>Location</th>
                        <th>Sensor Status</th>
                        <th>Subscribe</th>
                      </tr>
                    </thead>
                    <tbody>
						<c:forEach var="sensor" items="${listSensors}" >
							<tr class="back">
								<td>${sensor.sensorName}</td>
								<td>${sensor.sensorType}</td>
								<td> <button class="mapview" onclick="showMap(${sensor.sensorLongitude},${sensor.sensorLatitude})"><i class="fa fa-map-marker" style="font-size:30px;color:red"></i>mapview</button></td>
								<td>${sensor.sensorStatus}</td>
								<td>
								<button class="delete"   onclick="window.open('${pageContext.request.contextPath}/subscribe/${sensor.id}', '_self')">Subscribe</button>
								</td>		
							</tr>
						</c:forEach>
                      </tbody>
                  </table>
                </div><!-- /.box-body -->
                <div class="box-header">
                <div class="box-body">
                <h3 class="box-title">View On Map</h3>
                </div><!-- /.box-header -->
                <div class="maploc" id="showMap" style="width:500px;height:400px;"></div>
				<div id="map"></div>
				</div>
              </div><!-- /.box -->
		<div id="myForm" class="form-popup">
		<form action="/subscribe" method="POST"  class="form-container">
		<h1>Subscribe for sensor</h1>		
		<label for="email"><b>Email</b></label>
		<input type="text" placeholder="Enter Email" name="email" required>	
		<label for="psw"><b>Password</b></label>
		<input type="password" placeholder="Enter Password" name="psw" required>
		<input type="text" id="datetime12" data-format="DD-MM-YYYY h:mm a" data-template="DD / MM / YYYY     hh : mm a" name="datetime" value="21-12-2012 8:30 pm">
		<button type="submit" class="btn">Login</button>
		<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
		</form>
		</div>
			
           </div><!-- /.col -->
         </div><!-- /.row -->
       </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

	             
      <!-- DATA TABES SCRIPT -->
    <script src="../../plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
    <script src="../../plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
   <!-- page script -->
    <script type="text/javascript">
      $(function () {
        $("#example1").dataTable();
        $('#example2').dataTable({
          "bPaginate": true,
          "bLengthChange": false,
          "bFilter": false,
          "bSort": true,
          "bInfo": true,
          "bAutoWidth": false
        });
      });
    </script>
<script>
$(function(){
    $('#datetime12').combodate();  
});
</script>
<script>

function openForm() {
    document.getElementById("myForm").style.display = "block";
}
function closeForm() {
    document.getElementById("myForm").style.display = "none";
}
</script>                        
<script>
function showMap(longitude,latitude) {
    var mapLatLng = {lat:latitude, lng: longitude};

    var map = new google.maps.Map(document.getElementById('showMap'), {
      zoom: 10,
      center: mapLatLng
    });

    var marker = new google.maps.Marker({
      position: mapLatLng,
      map: map,	
    });
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC25YLyuryOygu1l8aI8N6mTASid2wJ-Mo&callback=myMap"></script>
 <style>
.mapview{	
background-color: #2E86C1;
color: white;
border-radius: 7px;
width: 60%;
height: 100%;
font-family: Arial;
font-weight:bold;
}
.delete{
background-color: #145A32;
color: white;
border-radius: 7px;
 font-family: Arial;
  font-weight:bold;
}
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}

 </style>