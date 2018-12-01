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
                        <th>Cluster ID</th>
                        <th>Cluster Name</th>
                        <th>No of smart nodes</th>
                        <th>Installation Date</th>
                        <th>Last Maintenance Date</th>
                        <th>Status</th>
                        <th>Location</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${clusterList}" var="data">
					<tr>
						<td><c:out value="${data.id}" /></td>
						<td><c:out value="${data.clusterName}" /></td>
						<td align="center"><a href="${pageContext.request.contextPath}/cluster/1/getmappednodes" ><c:out value="${data.smartnodecount}" /></a></td> 
						<td><c:out value="${data.installationDate}" /></td>
						<td><c:out value="${data.lastMaintainedDate}" /></td>
						<td>
					
   							<c:if test="${data.clusterStatus == '1'}"><span style="color:green;">Active</span></c:if> <!-- if condition -->
   							<c:if test="${data.clusterStatus == '0'}"><span style="color:brown;">Inactive</span></c:if> <!-- else if condition -->
   							<c:if test="${data.clusterStatus == '2'}"><span style="color:red;">Out of Service</span></c:if> <!-- else if condition -->
   							<c:if test="${data.clusterStatus == '3'}"><span style="color:yellow;">Low Battery</span></c:if> <!-- else if condition -->
						</td>
						<td><button class="mapview" onclick="showMap(${data.clusterLongitude},${data.clusterLatitude})"><i class="fa fa-map-marker" style="font-size:30px;color:red"></i></button></td>

						<td> <button type="button" id="addnode" class="btn btn-primary" data-toggle="modal" data-target="#contact-modal" onclick="ajaxGet()">Add Smart Node</button> <button type="button" class="btn btn-danger">Delete</button> </td>
						
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
         		<div class="maploc" id="map"></div>
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
					<input type="submit" class="btn btn-success" id="submit">
				</div>
			</form>
		</div>
	</div>
</div>
<script>
$(function () {
    // DO GET
    $("#addsensor").click(function () {
    			$.ajax({
    				type : "GET",
    				url : window.location + "/node/1/getunmappedsensors",
    				success: function(result){
    					if(result.status == "Done"){
    						alert(result);
    						console.log("Success: ", result);
    					}else{
    						alert('sorry');
    						console.log("Fail: ", result);
    					}
    				},
    				error : function(e) {
    					console.log("ERROR: ", e);
    				}
    			});	
    });
});  
	function showMap(longitude,latitude) {
    var mapLatLng = {lat:Number(latitude), lng: Number(longitude)};

    var map = new google.maps.Map(document.getElementById('showMap'), {
      zoom: 4,
      center: mapLatLng
    });

    var marker = new google.maps.Marker({
      position: mapLatLng,
      map: map,	
    });
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC25YLyuryOygu1l8aI8N6mTASid2wJ-Mo&callback=myMap"></script>
      
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