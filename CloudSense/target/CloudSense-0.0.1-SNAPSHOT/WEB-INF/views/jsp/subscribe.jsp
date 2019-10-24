<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Subscribe for sensor 
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Sensor</a></li>
            <li class="active">View Sensor</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-body">
                <h3>Select sensor start and end time</h3>
                 <form role="form" action="${pageContext.request.contextPath}/activatesensor"  method="POST">
                  <div class="box-body">
                     <!-- text input -->
                    <div class="form-group">               
                	<label>Sensor Name &nbsp : &nbsp </label>  ${sensor.sensorName} <br/>
                	<label>Sensor Frequency &nbsp : &nbsp </label>  
                	 <form:input path="sensor.sensorFrequency"/>
                	<br/>
					<label for="start">Choose sensor start time</label>
					<input id="start-time" type="time" name="starttime" value="12:00"><br/>
					<label for="end">Choose sensor end time</label>
					<input id="end-time" type="time" name="endtime" value="12:00">
					</div>
					</div>
 				  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Subscribe for Sensor</button>                  
                  </div>
                  					
					</form>

              </div><!-- /.box -->

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
width: 100%;
height: 100%;
font-family: Arial;
font-weight:bold;
}
.edit{
background-color: #145A32;
color: white;
border-radius: 7px;
width: 30%;
height: 100%;
 font-family: Arial;
  font-weight:bold;
}
input
{
    height: 25px;
}

 </style>