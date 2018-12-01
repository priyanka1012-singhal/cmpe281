<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Add Smart Node
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Smart Node</a></li>
            <li class="active">Add Smart Node</li>
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
                <form:form role="form" action="node/add" method="post" modelAttribute="node">
                  <div class="box-body">
                  	
                     <!-- text input -->
                    <div class="form-group">
                      <label>Smart Node Name</label>
                      <form:input type="text" class="form-control" path="nodeName" placeholder="Node Name"/>
                    </div>
                    <div class="form-group">
                      <label>Status</label>
                       <form:select class="form-control" path="nodeStatus">
                      	<form:option value="1" label="Active"/>
                      	<form:option value="0" label="Inactive"/>
                      </form:select>
                    </div> 
                    <div class="form-group">
                      <label>Address</label>
                      <form:input type="text" path="nodeAddress" class="form-control" placeholder="Address"/>
                    </div>
                    <div class="form-group">
                      <label>City</label>
                       <form:select class="form-control" path="nodeCity">
                        <form:option value="NONE" label="--- Select ---"/>
                      	<form:option value="Chicago" label="Chicago"/>
                      	<form:option value="San Jose" label="San Jose"/>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <label>State</label>
                     <form:select class="form-control" path="nodeState">
                     	<form:option value="NONE" label="--- Select ---"/>
                      	<form:option value="IL" label="IL"/>
                      	<form:option value="CAL" label="CAL"/>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <label>Zip</label>
                      <form:input type="text" path="nodeZip" class="form-control" placeholder="Zip"/>
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
    $('.datepicker').datepicker({
        format: 'mm/dd/yyyy',
        startDate: '-3d'
    });
    </script>