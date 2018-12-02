<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="example2" class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Serial Number</th>
                        <th>Sensor Name</th>
                        <th>Sensor Type</th>
                        <th>View on Map</th>
                        <th>Status</th>
                        <th>Address</th>
                       	<th>Installation Date</th>
                        <th>Last Maintenance Date</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${sensorList}" var="data">
					<tr>
						<td><c:out value="${data.deviceid}" /></td>
						<td><c:out value="${data.sensorName}" /></td>
						<td><c:out value="${data.sensorType}" /></td>
						<td><button class="mapview" onclick="document.getElementById('map').style.height = '400px';document.getElementById('map').style.width = '100%';showMap(${data.sensorLatitude}, ${data.sensorLongitude})"><i class="fa fa-map-marker" style="font-size:30px;color:red"></i></button></td>
						<td>
						<c:choose>
   							<c:when test="${data.sensorStatus == 'Active'}"><span style="color:green;">Active</span></c:when> 
   							<c:when test="${data.sensorStatus == 'Inactive'}"><span style="color:brown;">Inactive</span></c:when> 
   							<c:when test="${data.sensorStatus == 'Out of Service'}"><span style="color:red;">Out of Service</span></c:when> 
   							<c:when test="${data.sensorStatus == 'Low Battery'}"><span style="color:yellow;">Low Battery</span></c:when>
   							<c:otherwise><c:out value="${data.sensorStatus}" /></c:otherwise>
   						</c:choose>
						</td>
						<td>${data.sensorAddress}</td>
						<td><c:out value="${data.installationDate}" /></td>
						<td><c:out value="${data.lastMaintainedDate}" /></td>
						
						<td> <button class="edit" onclick="window.open('${pageContext.request.contextPath}/editsensor/${data.id}', '_self')">
								Edit</button> <button class= "delete" onclick="ajaxDelete(${data.id})">Delete</button> <button class="view"  onclick="window.open('${pageContext.request.contextPath}/sensor/${data.id}', '_self')">View</button>
						</td>
					</tr>
					</c:forEach>
                      </tbody>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
           </div><!-- /.col -->
         </div><!-- /.row -->
         <div class="row">
            <div class="col-xs-12">
              <div class="box">
              <div class="box-body">
                <div class="box-header"> Map View </div><!-- /.box-header -->
                <div id="map" style="width: 0px; height: 0px; "></div>
       			</div><!-- /.box-body -->
              </div><!-- /.box -->
           </div><!-- /.col -->
         </div><!-- /.row -->
       </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      


<script>

//Ajax delete
function ajaxDelete(id){
	
		$.ajax({
			type : "GET",
			url : "/CloudSense/sensor/"+id+"/delete",
			success: function(result){
				
					location.reload();
					console.log("Success: ", result);
					
			},
			error : function(e) {
				
				console.log("ERROR: ", e);
			}
		});	
	
}

function initMap(locations) {
	
    if (locations instanceof Array) {

   	    var centerOfMap = {lat: locations[0][0], lng: locations[0][1]};
        // The map, centered at Uluru
        var map = new google.maps.Map(
        document.getElementById('map'), {zoom: 10, center: centerOfMap});

        // The marker, positioned at center
        var marker, i;

        // var marker = new google.maps.Marker({position: center, map: map});

        for (i = 0; i < locations.length; i++) { 
        marker = new google.maps.Marker({
          position: new google.maps.LatLng(locations[i][0], locations[i][1]),
          map: map
        });

        google.maps.event.addListener(marker, 'click', (function(marker, i) {
          return function() {
            infowindow.setContent(locations[i][0]);
            infowindow.open(map, marker);
          }
        })(marker, i));
      }
    } else {
        return 0;
    }
 }
 
 
function showMap(latitude, longitude) {
	var mapApiInput = [];
	mapApiInput[0] = [parseFloat(latitude), parseFloat(longitude)];
	initMap(mapApiInput);

	    
	}
</script>
  <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzHhALhcJS-Q5LVYzbTkS9zb1rNhwUeOU&callback=initMap">
    </script>
    
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
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC25YLyuryOygu1l8aI8N6mTASid2wJ-Mo&callback=showMap"></script> -->