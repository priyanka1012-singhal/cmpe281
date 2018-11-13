
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
                  <h3 class="box-title">1st Street, San Jose, CA-95113</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="example2" class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Sensor ID</th>
                        <th>Sensor Name</th>
                        <th>Serial Number</th>
                        <th>Model Number</th>
                        <th>Sensor Type</th>
                        <th>Sensor Status</th>
                        <th>Installation Date</th>
                        <th>Last Maintenance Date</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Sensor1</td>
                        <td>Smart Sensor</td>
                        <td>ABCxxxxxxx</td>
                        <td>xxxxxxxx</td>
                        <td>temperature</td>
                        <td>active</td>
                        <td>04/12/2017</td>
                        <td>06/24/2018</td>
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