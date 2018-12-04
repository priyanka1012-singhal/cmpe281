     <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Dashboard
            
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content connectedSortable">
          <div class="row">
            <div class="col-md-10">
              <div class="box box-default">
                <div class="box-header with-border">
                  <i class="fa fa-warning"></i>
                  <h3 class="box-title">Notifications & Alerts</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-ban"></i> 10 Out of Service Sensors</h4>
                  </div>
                  <div class="alert alert-info alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-info"></i> 14 Inactive sensors</h4>
                  </div>
                  <div class="alert alert-warning alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-warning"></i> 4 Out of battery Sensors</h4>
                  </div>
                  <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4>	<i class="icon fa fa-check"></i> 10% Less Energy Usage since last month</h4>
                  </div>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
        </div> <!-- /.row -->
         
          <!-- Main row -->
          <div class="row">
            <!-- Left col -->
            <section class="connectedSortable">
              <!-- Map box -->
              <div class="box box-solid bg-light-blue-gradient">
                <div class="box-header">
                  <!-- tools box -->
                  <div class="pull-right box-tools">
                    <button class="btn btn-primary btn-sm pull-right" data-widget='collapse' data-toggle="tooltip" title="Collapse" style="margin-right: 5px;"><i class="fa fa-minus"></i></button>
                  </div><!-- /. tools -->

                  <i class="fa fa-map-marker"></i>
                  <h3 class="box-title">
                    Map View
                  </h3>
                </div>
                <div class="box-body">
                  <div id="map" style="height: 400px; width: 100%;"></div>
                </div><!-- /.box-body-->
                <div class="box-footer no-border">
                </div>
              </div>
              <!-- /.box -->

            </section><!-- /.Left col -->
            <!-- right col (We are only adding the ID to make the widgets sortable)-->
            <section class="col-lg-6 connectedSortable">
            
             <!-- Custom tabs (Charts with tabs)-->
              <div class="nav-tabs-custom">
                <!-- Tabs within a box -->
                <ul class="nav nav-tabs pull-right">
                  <li class="active"><a href="#revenue-chart" data-toggle="tab">Area</a></li>
                  <li class="pull-left header"><i class="fa fa-inbox"></i> Temperature</li>
                </ul>
                <div class="tab-content no-padding">
                  <!-- Morris chart - Temperature -->
                  <div class="chart tab-pane active" id="revenue-chart" style="position: relative; height: 350px;"></div>
                  
                </div>
              </div><!-- /.nav-tabs-custom -->
			</section>
			<section class="col-lg-6 connectedSortable">
              <!-- solid temperature graph -->
              <div class="box box-solid bg-teal-gradient">
                <div class="box-header">
                  <i class="fa fa-th"></i>
                  <h3 class="box-title">Humidity Graph</h3>
                  <div class="box-tools pull-right">
                    <button class="btn bg-teal btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn bg-teal btn-sm" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div>
                </div>
                <div class="box-body border-radius-none">
                  <div class="chart" id="line-chart" style="height: 250px;"></div>
                </div><!-- /.box-body -->
                <div class="box-footer no-border">
                  <div class="row">
                    <div class="col-xs-4 text-center" style="border-right: 1px solid #f4f4f4">
                      <input type="text" class="knob" data-readonly="true" value="20" data-width="60" data-height="60" data-fgColor="#39CCCC"/>
                      <div class="knob-label"></div>
                    </div><!-- ./col -->
                    <div class="col-xs-4 text-center" style="border-right: 1px solid #f4f4f4">
                      <input type="text" class="knob" data-readonly="true" value="50" data-width="60" data-height="60" data-fgColor="#39CCCC"/>
                      <div class="knob-label"></div>
                    </div><!-- ./col -->
                    <div class="col-xs-4 text-center">
                      <input type="text" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgColor="#39CCCC"/>
                      <div class="knob-label"></div>
                    </div><!-- ./col -->
                  </div><!-- /.row -->
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
             </section>
			<section class="col-lg-5 connectedSortable">
              <!-- Calendar -->
              <div class="box box-solid bg-green-gradient">
                <div class="box-header">
                  <i class="fa fa-calendar"></i>
                  <h3 class="box-title">Calendar</h3>
                  <!-- tools box -->
                  <div class="pull-right box-tools">
                    <!-- button with a dropdown -->
                    <div class="btn-group">
                      <button class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bars"></i></button>
                      <ul class="dropdown-menu pull-right" role="menu">
                        <li><a href="#">Add new event</a></li>
                        <li><a href="#">Clear events</a></li>
                        <li class="divider"></li>
                        <li><a href="#">View calendar</a></li>
                      </ul>
                    </div>
                    <button class="btn btn-success btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-success btn-sm" data-widget="remove"><i class="fa fa-times"></i></button>
                  </div><!-- /. tools -->
                </div><!-- /.box-header -->
                <div class="box-body no-padding">
                  <!--The calendar -->
                  <div id="calendar" style="width: 100%"></div>
                </div><!-- /.box-body -->
                <div class="box-footer text-black">
                  <div class="row">
                    <div class="col-sm-6">
                      <!-- Progress bars -->
                      <div class="clearfix">
                        <span class="pull-left">Task #1</span>
                        <small class="pull-right">90%</small>
                      </div>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 90%;"></div>
                      </div>

                      <div class="clearfix">
                        <span class="pull-left">Task #2</span>
                        <small class="pull-right">70%</small>
                      </div>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 70%;"></div>
                      </div>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                      <div class="clearfix">
                        <span class="pull-left">Task #3</span>
                        <small class="pull-right">60%</small>
                      </div>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 60%;"></div>
                      </div>

                      <div class="clearfix">
                        <span class="pull-left">Task #4</span>
                        <small class="pull-right">40%</small>
                      </div>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 40%;"></div>
                      </div>
                    </div><!-- /.col -->
                  </div><!-- /.row -->
                </div>
              </div><!-- /.box -->

            </section><!-- right col -->
          </div><!-- /.row (main row) -->
		
		
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
<!--  Map -->
<script>
window.addEventListener('load', function () {
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/getMapNodes",
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
	 
}, false);

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
   	
   	

  	    var centerOfMap = {lat: sensorlocations[0][0], lng: sensorlocations[0][1]};
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
