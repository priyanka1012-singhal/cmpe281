<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           View Sensor List
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
                <div class="box-header">
                <h3 class="box-title">Sensor Data</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="example2" class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Sensor Name</th>
                        <th>Sensor Desc</th>
                        <th>Sensor Type</th>
                        <th>Location</th>
                        <th>Sensor Status</th>
                        <th>Sensor Address</th>
                        <th>Installation Date</th>
                        <th>Edit</th>
                      </tr>
                    </thead>
                    <tbody>
						<c:forEach var="sensor" items="${listSensors}" >
							<tr class="back">
								<td>${sensor.sensorName}</td>
								<td>${sensor.sensorDesc}</td>
								<td>${sensor.sensorType}</td>
								<td> <button class="mapview" onclick="showMap(${sensor.sensorLongitude},${sensor.sensorLatitude})">View On Map</button></td>
								<td>${sensor.sensorStatus}</td>
								<td>${sensor.sensorAddress}</td>
								<td>${sensor.installationDate}</td>
								<td>
								<button class="edit" onclick="window.open('${pageContext.request.contextPath}/editsensor/${sensor.id}', '_self')">
								Edit</button>
								<button class= "delete" onclick="window.open('${pageContext.request.contextPath}/deletesensor/${sensor.id}', '_self')">
								Delete</button>
								<button class="view"  onclick="window.open('${pageContext.request.contextPath}/sensordetails/${sensor.id}', '_self')">View</button>
								</td>		
							</tr>
						</c:forEach>
                      </tbody>
                  </table>
                </div><!-- /.box-body -->
                <div class="box-header">
                <h3 class="box-title">View On Map</h3>
                </div><!-- /.box-header -->
                <div class="maploc" id="showMap" style="width:700px;height:600px;"></div>
				
				</div>
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
 .edit{
background-color: #145A32;
color: white;
border-radius: 7px;
width: 30%;
height: 100%;
 font-family: Arial;
  font-weight:bold;
}
.delete{
background-color: red;
color: white;
border-radius: 7px;
width: 35%;
height: 100%;
font-family: Arial;
font-weight:bold;
}
.view{
background-color: #0000FF;
color: white;
border-radius:7px;
width: 30%;
height: 100%;
font-family: Arial;
font-weight:bold;
}
.mapview{	
background-color: #2E86C1;
color: white;
border-radius: 7px;
width: 100%;
height: 100%;
font-family: Arial;
font-weight:bold;
}
 </style>