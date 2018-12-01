<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Generate Energy Usage Report
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Monitor</a></li>
            <li class="active">Energy Usage</li>
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
                <form action="${pageContext.request.contextPath}/generatenergyusagereports" class="inline">
                  <div class="box-body">
                  
                     <!-- text input -->
                    <div class="form-group">
                      <label>From Date</label>
                      <div class="input-group">
                      <div class="input-group-addon">
                        	<i class="fa fa-calendar"></i>
                      </div>
                  	  <input type="text"  class="form-control" data-provide="datepicker"/>
                    </div><!-- /.input group -->
                  </div><!-- /.form group -->
                  <div class="form-group">
                   <label>To Date</label>
                    <div class="input-group">
                      <div class="input-group-addon">
                        	<i class="fa fa-calendar"></i>
                      </div>
                  	  <input type="text" class="form-control" data-provide="datepicker"/>
   				  </div><!-- /.input group -->     
                 </div><!-- /.form group -->
                    <div class="form-group">
                      <label>Street Name</label>
                       <input type="text"  class="form-control" placeholder="Street Name"/>
                    </div>
                     <div class="form-group">
                      <label>Block Name</label>
                       <input type="text"  class="form-control" placeholder="Street Name"/>
                    </div>
                   
  						<label class="radio-inline"><input type="radio" name="yearly" value="Yearly"/>Yearly</label>
  					
  					
  						<label class="radio-inline"><input type="radio" name="monthly" value="Monthly"/>Monthly</label>
  					
  					
  						<label class="radio-inline"><input type="radio" name="weekly" value="Weekly"/>Weekly</label>
  					
  					
  						<label class="radio-inline"><input type="radio" name="daily" value="Daily"/>Daily</label>
					
                    
                </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary" value="Generate Report">Submit</button>
                  </div>
             </form>
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