<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Add Cluster Node
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Manage Cluster Node</a></li>
            <li class="active">Add Cluster Node</li>
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
                <form:form role="form" action="${pageContext.request.contextPath}/cluster/add" method="post" modelAttribute="cluster">
                  <div class="box-body">
                  	
                     <!-- text input -->
                    <div class="form-group">
                      <label>Cluster Name</label>
                      <form:input type="text" class="form-control" path="clusterName" placeholder="Cluster Name"/>
                    </div>
                    <div class="form-group">
                      <label>Description</label>
                      <form:input type="text" class="form-control"  path="clusterDesc" placeholder="Description"/>
                    </div> 
                     <div class="form-group">
                      <label>Status</label>
                       <form:select class="form-control" path="clusterStatus">
                      	<form:option  value="Turn On">Turn On</form:option>
                        <form:option  value="Turn Off">Turn Off</form:option>
                        <form:option  value="Active">Active</form:option>
                        <form:option  value="Inactive">Inactive</form:option>
                        <form:option  value="Maintenance">Maintenance</form:option>
                      </form:select>
                    </div>  
                    <div class="form-group">
                      <label>Address</label>
                      <form:input type="text" path="clusterAddress" class="form-control" placeholder="Address"/>
                    </div>
                    <div class="form-group">
                      <label>City</label>
                      <form:input type="text" class="form-control"  path="clusterCity" placeholder="City"/>
                    </div>
                     <div class="form-group">
                      <label>State</label>
                      <form:input type="text" class="form-control"  path="clusterState" placeholder="State"/>
                    </div>
                     <div class="form-group">
                      <label>Country</label>
                      <form:input type="text" class="form-control"  path="clusterCountry" placeholder="Country"/>
                    </div> 
                     <div class="form-group">
                      <label>Group</label>
                      <form:input type="text" class="form-control"  path="clusterBlock" placeholder="Group"/>
                    </div>                 
                    <div class="form-group">
                      <label>Zip</label>
                      <form:input type="text" path="clusterZip" class="form-control" placeholder="Zip"/>
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