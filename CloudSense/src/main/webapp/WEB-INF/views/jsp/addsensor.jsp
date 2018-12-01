<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Add Sensor
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
                <form:form role="form" action="sensor/add" method="post" modelAttribute="sensor">
                  <div class="box-body">
                  	
                     <!-- text input -->
                    <div class="form-group">
                      <label>Sensor Name</label>
                      <form:input type="text" class="form-control" path="sensorName" placeholder="Sensor Name"/>
                    </div>
                     <div class="form-group">
                      <label>Device Type</label>
                      <form:select class="form-control" path="deviceType">
                      	<form:option value="NONE" label="--- Select ---"/>
                        <form:option value="Station" label="Station"/>
                         <form:option value="Controller" label="Controller"/>                 
                      </form:select>
                    </div>
                    <div class="form-group">
                      <label>Serial Number</label>
                       <form:input type="text" path="deviceid" class="form-control" placeholder="Serial Number"/>
                    </div>
                    <div class="form-group">
                      <label>Sensor Type</label>
                      <form:select class="form-control" path="sensorType">
                      	<form:option value="NONE" label="--- Select ---"/>
                      	<form:option value="Air Temperature" label="Air Temperature"/>
                      	<form:option value="Wet Bulb Temperature" label="Wet Bulb Temperature"/>
                      	<form:option value="Pressure" label="Pressure"/>
                      	<form:option value="Humidity" label="Humidity"/>
                      	<form:option value="Rain" label="Rain"/>                 
                      </form:select>
                    </div>
                    <div class="form-group">
                      <label>Status</label>
                       <form:select class="form-control" path="sensorStatus">
                      	<form:option value="1" label="Active"/>
                      	<form:option value="0" label="Inactive"/>
                      </form:select>
                    </div> 
                    <div class="form-group">
                      <label>Address</label>
                      <form:input type="text" path="sensorAddress" class="form-control" placeholder="Address"/>
                    </div>
                    <div class="form-group">
                      <label>City</label>
                       <form:select class="form-control" path="sensorCity">
                        <form:option value="NONE" label="--- Select ---"/>
                      	<form:option value="Chicago" label="Chicago"/>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <label>State</label>
                     <form:select class="form-control" path="sensorState">
                     	<form:option value="NONE" label="--- Select ---"/>
                      	<form:option value="IL" label="IL"/>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <label>Zip</label>
                      <form:input type="text" path="sensorZip" class="form-control" placeholder="Zip"/>
                    </div>
                    <div class="form-group">
                      <label>Installation Date</label>
                      <div class="input-group">
                      <div class="input-group-addon">
                        	<i class="fa fa-calendar"></i>
                      </div>
                  	  <form:input type="text" path="installationDate" class="form-control" data-provide="datepicker"/>
                    </div><!-- /.input group -->
                  </div><!-- /.form group -->
                  <div class="form-group">
                   <label>Maintenance Date</label>
                    <div class="input-group">
                      <div class="input-group-addon">
                        	<i class="fa fa-calendar"></i>
                      </div>
                  	  <form:input type="text" path="lastMaintainedDate" class="form-control" data-provide="datepicker"/>
   				  </div><!-- /.input group -->     
                 </div><!-- /.form group -->
                </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary" value="Save">Submit</button>
                  </div>
                </form:form> 
              </div><!-- /.box -->
            </div><!--/.col (left) -->
          </div>   <!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrap -->
      
      <!-- Page script -->
    <script type="text/javascript">
    $('#datepicker').datepicker({
        format: 'mm/dd/yyyy',
        startDate: '-3d'
    });
    </script>