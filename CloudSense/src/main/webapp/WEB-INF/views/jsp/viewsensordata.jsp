<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           View Sensor Data List
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Sensor</a></li>
            <li class="active">View Sensor Data</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">1st Street, Oak Street Weather Station, Chicago IL 60628</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="example2" class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Data ID</th>
                        <th>Station Name</th>
                        <th>Humidity</th>
                        <th>Temperature</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sensorDataList}" var="data">
					<tr>
						<td><c:out value="${data._id}" /></td>
						<td><c:out value="${data.stationName}" /></td>
						<td><c:out value="${data.humidity}" /></td>
						<td><c:out value="${data.wetBulbTemperature}" /></td>
					</tr>
					</c:forEach>
                      <tr>
                      </tr>
                      </tbody>
                  </table>
                </div><!-- /.box-body -->
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