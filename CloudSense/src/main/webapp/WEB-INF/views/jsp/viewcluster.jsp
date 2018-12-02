<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           View Cluster Node List
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Cluster Node</a></li>
            <li class="active">View Cluster Node</li>
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
                        <th>Cluster Name</th>
                        <th>Cluster Description</th>      
                      	<th>No of smart nodes</th>
						<th>View on map</th>  
						<th>Status</th>     
                        <th>Cluster Address</th>  
                        <th>Installation Date</th>
                        <th>Last Maintenance Date</th>                       
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${clusterList}" var="data">
					<tr class="back">
						<td><c:out value="${data.clusterName}" /></td>
						<td><c:out value="${data.clusterDesc}" /></td>
						<td align="center"><a href="${pageContext.request.contextPath}/viewcluster/cluster/${data.id}/getmappednodes" ><c:out value="${data.smartnodecount}" /></a></td> 
						<td><button class="mapview" onclick="document.getElementById('map').style.height = '400px';document.getElementById('map').style.width = '100%';showMap(${data.id})"><i class="fa fa-map-marker" style="font-size:30px;color:red"></i></button></td>
						<td>
						<c:choose>
   							<c:when test="${data.clusterStatus == 'Active'}"><span style="color:green;">Active</span></c:when> 
   							<c:when test="${data.clusterStatus == 'Inactive'}"><span style="color:brown;">Inactive</span></c:when> 
   							<c:when test="${data.clusterStatus == 'Out of Service'}"><span style="color:red;">Out of Service</span></c:when> 
   							<c:when test="${data.clusterStatus == 'Low Battery'}"><span style="color:yellow;">Low Battery</span></c:when>
   							<c:otherwise><c:out value="${data.clusterStatus}" /></c:otherwise>
   						</c:choose>
						</td>
						<td><c:out value="${data.clusterAddress}" /></td>
						<td><c:out value="${data.installationDate}" /></td>
						<td><c:out value="${data.lastMaintainedDate}" /></td>
						<td> <button type="button" id="addnode" class="view" data-toggle="modal" data-target="#contact-modal" onclick="ajaxGet(${data.id})">Add Node</button> <button class="edit"  onclick="window.open('/CloudSense/editcluster/${data.id}', '_self')">Edit</button>
								<button class= "delete" onclick="ajaxDelete(${data.id})">Delete</button> </td>
						
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
     
     <div id="contact-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">×</a>
				<h3>Add Smart Nodes</h3>
			</div>
			<form id="addnodeForm" role="form">
				<div class="modal-body">				
					<div class="form-group">
						<label for="name">Cluster Node Name</label>
						<input type="text" value="<c:out value="${cluster.clusterName}" />" disabled class="form-control">
					</div>
					<div class="form-group">
						 <c:forEach items="${cluster.nodes}" var="data">
						<label><input type="checkbox" class="form-control"/> <c:out value="${data.nodeName}" /></label>
						</c:forEach>
					</div>				
				</div>
				<div class="modal-footer">					
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-success" id="submit" onclick="send()"/>
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
    				url : "/CloudSense/cluster/"+id+"/getunmappednodes",
    				success: function(result){
    					
    						var response = "<div class=\"form-group\"><label for=\"name\">Cluster Name</label>"+
    						"<input type=\"text\" value=\""+result.clusterName+"\" disabled class=\"form-control\"></div>"+
    						"<div class=\"form-group\"><input type=\"hidden\" name=\"id\" value=\""+id+"\">";
    						
    						$.each(result.nodes, function(i, node){
    							
    							// Add response in Modal body
    							response = response + "<input type=\"checkbox\" name=\"node\" value=\""+node.id+"\" />  " + node.nodeName +"</br>";
    	      					
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
 	
    //Ajax delete
    function ajaxDelete(id){
			$.ajax({
				type : "GET",
				url : "/CloudSense/cluster/"+id+"/delete",
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
        	
        	

       	    var centerOfMap = {lat: nodelocations[0][0], lng: nodelocations[0][1]};
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

function showMap(id) {
	$.ajax({
		type : "GET",
		url : "/CloudSense/cluster/"+id+"/getmappednodes",
		success: function(result){
				
			    var sensorMapInput = [];
			    var nodeMapInput = [];
			    var clusterMapInput = [];
				
				$.each(result, function(i, val) {
					nodeMapInput[i] = [parseFloat(val.nodeLatitude), parseFloat(val.nodeLongitude)];
				}); 
				initMap(sensorMapInput,nodeMapInput,clusterMapInput);
				console.log("Success: ", nodeMapInput);
				
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
    	var nodeIdList1 = [];
        $.each($("input[name='node']:checked"), function(){            
        	nodeIdList1.push($(this).val());
        }); 
        var id1 = $("input[name='id']").val();
        var apiBody = {
            id: id1,
            nodeIdList:nodeIdList1,
        }        
       
       
        $.ajax({
            url: '/CloudSense/cluster/addnodes',
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
</script>
 
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
  <style>
 .edit{
background-color: #145A32;
color: white;
border-radius: 7px;
width: 25%;
height: 100%;
 font-family: Arial;
  font-weight:bold;
}
.delete{
background-color: red;
color: white;
border-radius: 7px;
width: 27%;
height: 100%;
font-family: Arial;
font-weight:bold;
}
.view{
background-color: #0000FF;
color: white;
border-radius:7px;
width: 45%;
height: 100%;
font-family: Arial;
font-weight:bold;
}
.mapview{	
background-color: #2E86C1;
color: white;
border-radius: 7px;
font-family: Arial;
font-weight:bold;
width: 100%;
height: 100%;
}
 </style>