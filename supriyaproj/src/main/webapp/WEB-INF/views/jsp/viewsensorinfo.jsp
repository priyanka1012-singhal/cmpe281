<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Sensor Details
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
 

 				 <label>Sensor Name &nbsp : &nbsp </label>  ${sensor.sensorName} <br/>
 				 <label>Sensor Desc &nbsp : &nbsp </label>  ${sensor.sensorDesc} <br/>
				 <label>Sensor Status &nbsp : &nbsp </label>  ${sensor.sensorStatus}<br/>
				 <label>Sensor Type &nbsp : &nbsp </label>  ${sensor.sensorType}<br/>
				 <label>Sensor Frequency &nbsp : &nbsp </label>  ${sensor.sensorFrequency}<br/>
 				 <label>Sensor Provider  &nbsp : &nbsp </label>  ${sensor.sensorProviderName}<br/>
 				 <label>Sensor Address  &nbsp : &nbsp </label>  ${sensor.sensorAddress}<br/>
 				 <label>Sensor City  &nbsp : &nbsp </label>  ${sensor.sensorCity}<br/>
 				 <label>Sensor State  &nbsp : &nbsp </label>  ${sensor.sensorState}<br/>
 				 <label>Sensor Country  &nbsp : &nbsp </label>  ${sensor.sensorCountry}<br/>
 				 <label>Installed By  &nbsp : &nbsp </label>  ${sensor.installedBy}<br/>
 				 <label>Installation Date  &nbsp : &nbsp </label>  ${sensor.installationDate}<br/>
 				 <label>Last Maintained By Date  &nbsp : &nbsp </label>  ${sensor.lastMaintainedBy}<br/>
 				 <label>Last Maintenance Date  &nbsp : &nbsp </label>  ${sensor.lastMaintainedDate	}<br/>
 				 </div>
 				  <div class="box-footer">
                    <button type="submit" onclick="window.open('${pageContext.request.contextPath}/viewsensor', '_self')" class="btn btn-primary">Back to Sensor List</button>                  
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
background-color: green;
color: white;
border-radius: 7px;
width: 30%;
height: 100%;

}
.delete{
background-color: red;
color: white;
border-radius: 7px;
width: 35%;
height: 100%;
}
.view{
background-color: purple;
color: white;
border-radius:7px;
width: 30%;
height: 100%;
}
.mapview{	
background-color: #307D7E;
color: white;
border-radius: 7px;
width: 100%;
height: 100%;
}
 </style>