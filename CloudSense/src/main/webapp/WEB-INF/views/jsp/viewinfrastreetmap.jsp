     <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            View Street Infrastructure
            
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">View Street Infrastructure</li>
          </ol>
        </section>

		
         <!-- Main Content -->
      <section class="content">
      <!--  search criteria -->
      	 <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                </div><!-- /.box-header -->
                <div class="box-body">
                 <div class="box-body">
                      <label>Location</label>
                      <input type="text" id="streetname"  class="inputbox" placeholder="Streetname or Block name or Zip"/>
                      <button class="btn btn-primary" onclick="document.getElementById('map').style.height = '400px';document.getElementById('map').style.width = '100%';showMap();">Search</button>
                 </div>
       		</div><!-- /.box-body -->
           </div><!-- /.box -->
          </div><!-- /.col -->
         </div><!-- /.row -->          	
      <!-- Map View -->
           <div class="row">
            <div class="col-xs-12">
              <div class="box">
              <div class="box-body">
                <div class="box-header bg-light-blue-gradient"> 
                <i class="fa fa-map-marker"></i>
                  <h3 class="box-title">
                    Map View
                  </h3> 
                  </div><!-- /.box-header -->
    				<div id="map" style="width: 0px; height: 0px; "></div>
         		
       			</div><!-- /.box-body -->
              </div><!-- /.box -->
           </div><!-- /.col -->
         </div><!-- /.row -->
          	<!--  Map -->
          	
          	
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

<script>
function showMap() {
	 var streetname = $("input[id='streetname']").val();
	 
	$.ajax({
		type : "GET",
		url : "/CloudSense/getMapNodesByStreet/"+streetname,	
		success: function(result){
			    var sensorMapInput = [];
			    var nodeMapInput = [];
			    var clusterMapInput = [];
		
				$.each(result.sensors, function(i, sensor) {
					sensorMapInput[i] = [parseFloat(sensor.sensorLatitude), parseFloat(sensor.sensorLongitude)];
				}); 
				$.each(result.smartnodes, function(i, node) {
					nodeMapInput[i] = [parseFloat(node.nodeLatitude), parseFloat(node.nodeLongitude)];
				});
				$.each(result.clusters, function(i, cluster) {
					clusterMapInput[i] = [parseFloat(cluster.clusterLatitude), parseFloat(cluster.clusterLongitude)];
				});
				initMap(sensorMapInput,nodeMapInput,clusterMapInput);
				console.log("Success: ", sensorMapInput);
				
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
	   console.log("Success: ", sensorlocations);
		
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
   	
   		if(sensorlocations.length!=0)
			var centerOfMap = {lat: sensorlocations[0][0], lng: sensorlocations[0][1]};
   		else if(nodelocations.length!=0)
   			var centerOfMap = {lat: nodelocations[0][0], lng: nodelocations[0][1]};
   		else if(clusterlocations.length!=0)
   			var centerOfMap = {lat: clusterlocations[0][0], lng: clusterlocations[0][1]};
   		else
   			var centerOfMap = {lat:0, lng: 0};
       // The map, centered at Uluru
       var map = new google.maps.Map(
       document.getElementById('map'), {zoom: 8, center: centerOfMap});

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
</script>
<script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzHhALhcJS-Q5LVYzbTkS9zb1rNhwUeOU&callback=initMap">
</script>
<style>
 .inputbox{
 	width:25%;
 	height:50%;
 	margin: 10px;
 }
 </style>
