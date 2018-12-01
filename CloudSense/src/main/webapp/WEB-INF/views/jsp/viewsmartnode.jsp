<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           View Smart Node List
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Smart Node</a></li>
            <li class="active">View Smart Node</li>
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
                        <th>Node ID</th>
                        <th>Node Name</th>
                        <th>No of Sensors</th>
                        <th>Installation Date</th>
                        <th>Last Maintenance Date</th>
                        <th>Status</th>
                        <th>Location</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${nodeList}" var="data">
					<tr>
						<td><c:out value="${data.id}" /></td>
						<td><c:out value="${data.nodeName}" /></td>
						<td align="center"><a href="${pageContext.request.contextPath}/viewsmartnode/node/${data.id}/getmappedsensors" ><c:out value="${data.sensorIdCount}" /></a></td>
						<td><c:out value="${data.installationDate}" /></td>
						<td><c:out value="${data.lastMaintainedDate}" /></td>
						<td>
					
   							<c:if test="${data.nodeStatus == '1'}"><span style="color:green;">Active</span></c:if> <!-- if condition -->
   							<c:if test="${data.nodeStatus == '0'}"><span style="color:brown;">Inactive</span></c:if> <!-- else if condition -->
   							<c:if test="${data.nodeStatus == '2'}"><span style="color:red;">Out of Service</span></c:if> <!-- else if condition -->
   							<c:if test="${data.nodeStatus == '3'}"><span style="color:yellow;">Low Battery</span></c:if> <!-- else if condition -->
						</td>
						<td><button class="mapview" onclick="document.getElementById('map').style.height = '400px';document.getElementById('map').style.width = '100%';showMap(${data.id})"><i class="fa fa-map-marker" style="font-size:30px;color:red"></i></button></td>
						
						<td> <button type="button" id="addsensor" class="btn btn-success" onclick="ajaxGet(${data.id})">Add Sensor</button> <button type="button" id="updatesensor" class="btn btn-primary" onclick="ajaxUpdate(${data.id})">Edit</button> <button type="button" class="btn btn-danger" onclick="ajaxDelete(${data.id})">Delete</button> </td>
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
      
    <div id="contact-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">×</a>
				<h3>Add Sensors</h3>
			</div>
			<form id="addsensorForm" role="form">
				<div class="modal-body">				
					<!-- <div class="form-group">
						<label for="name">Smart Node Name</label>
						<input type="text" value="<c:out value="${node.nodeName}" />" disabled class="form-control">
					</div>
					<div class="form-group">
						 <c:forEach items="${node.sensors}" var="data">
						<label><input type="checkbox" class="form-control"/> <c:out value="${data.sensorName}" /></label>
						</c:forEach>
					</div>	 -->			
				</div>
				<div class="modal-footer">					
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-success" id="submit" onclick="send()">
				</div>
			</form>
		</div>
	</div>
</div>

<div id="update-modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">×</a>
				<h3>Edit Smart Node</h3>
			</div>
			<form id="addsensorForm" role="form">
				<div class="modal-body">					
				</div>
				<div class="modal-footer">					
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-success" id="submit" onclick="update()">
				</div>
			</form>
		</div>
	</div>
</div>
      
<script>

    // Ajax Get
    function ajaxGet(id) {
    			$.ajax({
    				type : "GET",
    				url : "http://localhost:8080/CloudSense/viewsmartnode/node/"+id+"/getunmappedsensors",
    				success: function(result){
    					
    						var response = "<div class=\"form-group\"><label for=\"name\">Smart Node Name</label>"+
    						"<input type=\"text\" value=\""+result.nodeName+"\" disabled class=\"form-control\"></div>"+
    						"<div class=\"form-group\"><input type=\"hidden\" name=\"id\" value=\""+id+"\">";
    						
    						$.each(result.sensors, function(i, sensor){
    							
    							// Add response in Modal body
    							response = response + "<input type=\"checkbox\" name=\"sensor\" value=\""+sensor.id+"\" />  " + sensor.sensorName +"</br>";
    	      					
    	       				 });
    						response = response + "</div>";
    						$('.modal-body').html(response);
    						// Display Modal
    			      		$('#contact-modal').modal('show'); 
    						console.log("Success: ", result);
    						
    				},
    				error : function(e) {
    					console.log("ERROR: ", e);
    				}
    			});	
    }
 	// Ajax update
    function ajaxUpdate(id) {
    			$.ajax({
    				type : "GET",
    				url : "http://localhost:8080/CloudSense/viewsmartnode/node/"+id,
    				success: function(result){
    					
    						var response = "<div class=\"form-group\"><label for=\"id\">Smart Node ID</label><input type=\"text\" class=\"form-control\" name=\"nodeid\" disabled value=\""+id+"\">"+
    						"</div>"+
    						"<div class=\"form-group\"><label for=\"name\">Smart Node Name</label>"+
    						"<input type=\"text\" value=\""+result.nodeName+"\" disabled class=\"form-control\"></div>"+
    						
    						"<div class=\"form-group\"><label for=\"status\">Status</label>"+
    						"<select id=\"nodeStatus\" class=\"form-control\"><option value=\"1\" label=\"Active\"/><option value=\"0\" label=\"Inactive\"/>"+
    						"</select></div>"+
    						"<div class=\"form-group\"><label>Address</label><input type=\"text\" name=\"nodeAddress\" class=\"form-control\" value=\""+result.nodeAddress+"\"/></div>"+
    	                    "<div class=\"form-group\"><label>City</label><select id=\"nodeCity\" class=\"form-control\"><option value=\""+result.nodeCity+"\" label=\""+result.nodeCity+"\" />"+
    	                    "<option value=\"Chicago\" label=\"Chicago\"/><option value=\"San Jose\" label=\"San Jose\"/><select></div>"+
    	                    "<div class=\"form-group\"><label>State</label><select id=\"nodeState\" class=\"form-control\"><option value=\""+result.nodeState+"\" label=\""+result.nodeState+"\" />"+
    	                    "<option value=\"IL\" label=\"IL\"/><option value=\"CAL\" label=\"CAL\"/><select></div>"+ 
    	                    "<div class=\"form-group\"><label>Zip</label><input type=\"text\" class=\"form-control\" name=\"nodeZip\" value=\""+result.nodeZip+"\"/></div>";
    	                  
                          
    						response = response + "</div>";
    						$('.modal-body').html(response);
    						// Display Modal
    			      		$('#update-modal').modal('show'); 
    						console.log("Success: ", result);
    						
    				},
    				error : function(e) {
    					console.log("ERROR: ", e);
    				}
    			});	
    }
    //Ajax delete
    function ajaxDelete(id){
			$.ajax({
				type : "GET",
				url : "http://localhost:8080/CloudSense/node/"+id+"/delete",
				success: function(result){
						location.reload();
						console.log("Success: ", result);
						
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});	
    	
    }
    
    function initMap(sensorlocations, nodelocations, clusterlocations) {
    	
    	 var iconBase = 'http://maps.google.com/mapfiles/ms/icons/';
         var icons = {
           smartnode: {
             icon: iconBase + 'green-dot.png'
           },
           cluster: {
             icon: iconBase + 'blue-dot.png'
           },
           sensor: {
             icon: iconBase + 'red-dot.png'
           }
         };
    	
        if (sensorlocations instanceof Array || nodelocations instanceof Array || clusterlocations instanceof Array ) {
        	
        	var features = [];
        	for (i = 0; i < sensorlocations.length; i++) { 
        		features.push(  {
                    position: new google.maps.LatLng(sensorlocations[i][0], sensorlocations[i][1]),
                    type: 'sensor'
                  });
        	}
        	
        	for (i = 0; i < nodelocations.length; i++) { 
        		features.push(  {
                    position: new google.maps.LatLng(nodelocations[i][0], nodelocations[i][1]),
                    type: 'smartnode'
                  });
        	}
        	
        	for (i = 0; i < clusterlocations.length; i++) { 
        		features.push(  {
                    position: new google.maps.LatLng(clusterlocations[i][0], clusterlocations[i][1]),
                    type: 'cluster'
                  });
        	}
        	
        	

       	    var centerOfMap = {lat: sensorlocations[0][0], lng: sensorlocations[0][1]};
            // The map, centered at Uluru
            var map = new google.maps.Map(
            document.getElementById('map'), {zoom: 10, center: centerOfMap});

            // The marker, positioned at center
            var marker, i;

            // var marker = new google.maps.Marker({position: center, map: map});

            // Create markers.
        	features.forEach(function(feature) { 
            marker = new google.maps.Marker({
            	position: feature.position,
                icon: icons[feature.type].icon,
                map: map
            });

            google.maps.event.addListener(marker, 'click', (function(marker, i) {
              return function() {
                infowindow.setContent(marker.getPosition());
                infowindow.open(map, marker);
              }
            })(marker, i));
          });
        } else {
            return 0;
        }
    	



     }

/*function initMap(locations) {
	
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
	



 }*/

function showMap(id) {
	
/* 	  var mapLatLng = {lat:Number(latitude), lng: Number(longitude)};
	alert(Number(latitude));
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 4,
      center: mapLatLng
    });

    var marker = new google.maps.Marker({
      position: mapLatLng,
      map: map,	
    }); */
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/CloudSense/node/"+id+"/getmappedsensors",
		success: function(result){
				
			    var sensorMapInput = [];
			    var nodeMapInput = [];
			    var clusterMapInput = [];
				
				$.each(result, function(i, val) {
					sensorMapInput[i] = [parseFloat(val.sensorLatitude), parseFloat(val.sensorLongitude)];
					//alert(val.sensorLatitude);
/* 					  $.each(this, function(k, v) {
					    /// do stuff]
					    alert(k);
					    alert(v);
					    
					  }); */
				}); 
				initMap(sensorMapInput,nodeMapInput,clusterMapInput);
				console.log("Success: ", sensorMapInput);
				
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});	
    
}
</script>

<script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzHhALhcJS-Q5LVYzbTkS9zb1rNhwUeOU&callback=initMap">
</script>
<script type="text/javascript">
    function send() {
    	var sensorList1 = [];
        $.each($("input[name='sensor']:checked"), function(){            
        	sensorList1.push($(this).val());
        }); 
        var id1 = $("input[name='id']").val();
        var apiBody = {
            id: id1,
            sensorList:sensorList1,
        }        
       
       
        $.ajax({
            url: 'http://localhost:8080/CloudSense/node/addsensors',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            error: function (request, error) {
        		//alert(" Can't do because: " + error);
    		},
            success: function (data) {
            	location.reload();
            },
            data: JSON.stringify(apiBody)
        });
    }
    function update() {
    	
        var id = $("input[name='nodeid']").val();
        var address = $("input[name='nodeAddress']").val();
        var city = document.getElementById("nodeCity").value;
		alert(city);
      	
      	var state = document.getElementById("nodeState").value;
      
      	 var e = document.getElementById("nodeStatus");
         var status = e.options[e.selectedIndex].value;
      	var zip = $("input[name='nodeZip']").val();
        var apiBody = {
            id: id,
            nodeAddress:address,
            nodeCity:city,
            nodeState: state,
            nodeStatus: status,
            nodeZip: zip
        }        
       
       
        $.ajax({
            url: 'http://localhost:8080/CloudSense/node/update',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            error: function (request, error) {
    		},
            success: function (data) {
            	console.log("Success: ");
            	location.reload();
            },
            data: JSON.stringify(apiBody)
        });
    }
</script>
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC25YLyuryOygu1l8aI8N6mTASid2wJ-Mo&callback=showMap"></script>  
 -->      