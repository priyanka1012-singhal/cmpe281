<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Edit Sensor
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Sensor</a></li>
            <li class="active">Add Sensor</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-6">
              <!-- general form elements -->
              <div class="box box-primary">
                <!-- form start -->
                <form role="form" action="/CloudSense/editsave/"  method="POST">
                  <div class="box-body">
                     <!-- text input -->
                    <div class="form-group">
                      <label>Sensor Name</label>
                      <form:input path="sensor.sensorName" class="form-control"/>
                    </div>
                     <div class="form-group">
                      <label>Sensor Type</label>
                      <select class="form-control"  name= "sensorType">
                        <option>Temperature</option>
                        <option>Pressure</option>
                        <option>Humidity</option>
                        <option>Wind</option>
                        <option>Rain</option>
                        <option>Light</option>
                      </select>
                    </div>
                    
                    <div class="form-group">
                      <label>Sensor Desciption</label>
                      <form:input path="sensor.sensorDesc" class="form-control"/>
                    </div> 
                     <div class="form-group">
                      <label>Sensor Frequency</label>
                      <form:input path="sensor.sensorFrequency" class="form-control"/>
                    </div>                                       
                   <div class="form-group">
                      <label>Status</label>
                      <select class="form-control"   name="sensorStatus" >
                        <option  value="On">Turn On</option>
                        <option  value="Off">Turn Off</option>
                        <option  value="Active">Active</option>
                        <option  value="Inactive">Inactive</option>
                        <option  value="Maintenance">Maintenance</option>
                      </select>
                    </div>                    
                    <div class="form-group">
                      <label>Address</label>
                      <form:input path="sensor.sensorAddress" class="form-control"/>
                    </div>
                    <div class="form-group">
                      <label>City</label>
                      <form:input path="sensor.sensorCity" class="form-control"/>
                    </div>
                     <div class="form-group">
                      <label>State</label>
                      <form:input path="sensor.sensorState" class="form-control"/>
                    </div>
                     <div class="form-group">
                      <label>Country</label>
                      <form:input path="sensor.sensorCountry" class="form-control"/>
                    </div>                                                          
                    <div class="form-group">
                      <label>Zip</label>
                      <form:input path="sensor.sensorZip" class="form-control"/>
                    </div>
    


                  </div><!-- /.form group -->
                </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                  
                </form>
              </div><!-- /.box -->
            </div><!--/.col (left) -->
          </div>   <!-- /.row -->
        </section><!-- /.content -->
       
      </div><!-- /.content-wrap -->
      
      <!-- Page script -->
    <script type="text/javascript">
      $(function () {
        //Datemask dd/mm/yyyy
        $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
        //Datemask2 mm/dd/yyyy
        $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
        //Money Euro
        $("[data-mask]").inputmask();

        //Date range picker
        $('#reservation').daterangepicker();
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
        //Date range as a button
        $('#daterange-btn').daterangepicker(
                {
                  ranges: {
                    'Today': [moment(), moment()],
                    'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
                    'Last 7 Days': [moment().subtract('days', 6), moment()],
                    'Last 30 Days': [moment().subtract('days', 29), moment()],
                    'This Month': [moment().startOf('month'), moment().endOf('month')],
                    'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                  },
                  startDate: moment().subtract('days', 29),
                  endDate: moment()
                },
        function (start, end) {
          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
        }
        );

        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
          checkboxClass: 'icheckbox_minimal-blue',
          radioClass: 'iradio_minimal-blue'
        });
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
          checkboxClass: 'icheckbox_minimal-red',
          radioClass: 'iradio_minimal-red'
        });
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
          checkboxClass: 'icheckbox_flat-green',
          radioClass: 'iradio_flat-green'
        });

        //Colorpicker
        $(".my-colorpicker1").colorpicker();
        //color picker with addon
        $(".my-colorpicker2").colorpicker();

        //Timepicker
        $(".timepicker").timepicker({
          showInputs: false
        });
      });
    </script>