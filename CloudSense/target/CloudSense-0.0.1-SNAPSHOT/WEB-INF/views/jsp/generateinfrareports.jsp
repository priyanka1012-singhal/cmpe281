
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="smartstreet.reports.ReportingCharts" %>
<%@page import="java.util.*" %>
<%@page import="com.google.gson.*" %>

<%Gson gson = new Gson(); %>

<script src='<c:url value="fusioncharts.js" />'></script>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Generate Infrastructure Reports
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Generate Reports</a></li>
            <li class="active">Generate Infrastructure Reports</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-6">
        	<!-- Default unchecked -->
				<div class="custom-control custom-radio">
  					<input type="radio" class="custom-control-input" id="defaultUnchecked" onchange="getreportbysensortype()" name="defaultExampleRadios">
  					<label class="custom-control-label" for="defaultUnchecked">Report by Sensor Type</label>
  					
				</div>
				<div class="custom-control custom-radio">
  					<input type="radio" class="custom-control-input" id="defaultUnchecked" onchange="getreportbysensorstatus()" name="defaultExampleRadios">
  					<label class="custom-control-label" for="defaultUnchecked">Report by Sensor Status</label>
  					
				</div>
				<div class="custom-control custom-radio">
  					<input type="radio" class="custom-control-input" id="defaultUnchecked" onchange="getreportbyblockname()" name="defaultExampleRadios">
  					<label class="custom-control-label" for="defaultUnchecked">Report by Block Name</label>
  					
				</div>
			</div>
			</div>
		    <div class="row">
        	<div class="col-xs-12">
              <div class="box">
              <div class="box-body">
                <div class="box-header"> 
                  <h3 class="box-title">
                    Reports
                  </h3> 
                  </div><!-- /.box-header -->
         		<div id="chart-container"></div>
         		</div><!-- /.box-body -->
              </div><!-- /.box -->
           </div><!-- /.col -->
         </div><!-- /.row -->
   
		</section><!-- /.content -->
      	</div><!-- /.content-wrapper -->
		<script>
	    //FusionCharts.ready(function() {
	  function getreportbysensortype() {
	  
	   	var chartData = [];
	   		$.ajax({
	    	        url: '${pageContext.request.contextPath}/getreportbysensortype',
	    	        type: 'GET',
	    	        success : function(data) {
	    	      		
	    	      		$.each(data, function(i, val) {
	    	      			chartData.push( {"value":val.value, "label": val.label});
	    				});
	    	      		 var visitChart = new FusionCharts({
	    	      		    type: 'pie2d',
	    	      		    renderAt: 'chart-container',
	    	      		    width: '700',
	    	      		    height: '400',
	    	      		    dataFormat: 'json',
	    	      		    dataSource: {
	    	      		      "chart": {
	    	      		        "theme": "fusion",
	    	      		        "caption": "Report By Sensor Type",
	    	      		        "xAxisName": "Month",
	    	      		        "yAxisName": "Energy used in KWH",
	    	      		        "lineThickness": "2",
	    	      		        "labelDisplay": "rotate",
	    	      		        "slantLabels": "1"
	    	      		      },
	    	      		      "data": chartData,
	    	      		      "trendlines": [{
	    	      		        "line": [{
	    	      		          "startvalue": "18500",
	    	      		          "color": "#29C3BE",
	    	      		          "displayvalue": "Average{br}weekly{br}footfall",
	    	      		          "valueOnRight": "1",
	    	      		          "thickness": "2"
	    	      		        }]
	    	      		      }]
	    	      		    }
	    	      		  });

	    	      		  visitChart.render();
	    	      		
	    	          
	    	        }  
	    		});
	   
	}
	  
	  function getreportbysensorstatus() {
		  
		   	var chartData = [];
		   		$.ajax({
		    	        url: '${pageContext.request.contextPath}/getreportbysensorstatus',
		    	        type: 'GET',
		    	        success : function(data) {
		    	      		
		    	      		$.each(data, function(i, val) {
		    	      			chartData.push( {"value":val.value, "label": val.label});
		    				});
		    	      		 var visitChart = new FusionCharts({
		    	      		    type: 'pie2d',
		    	      		    renderAt: 'chart-container',
		    	      		    width: '700',
		    	      		    height: '400',
		    	      		    dataFormat: 'json',
		    	      		    dataSource: {
		    	      		      "chart": {
		    	      		        "theme": "fusion",
		    	      		        "caption": "Report By Sensor Status",
		    	      		        "xAxisName": "Month",
		    	      		        "yAxisName": "Energy used in KWH",
		    	      		        "lineThickness": "2",
		    	      		        "labelDisplay": "rotate",
		    	      		        "slantLabels": "1"
		    	      		      },
		    	      		      "data": chartData,
		    	      		      "trendlines": [{
		    	      		        "line": [{
		    	      		          "startvalue": "18500",
		    	      		          "color": "#29C3BE",
		    	      		          "displayvalue": "Average{br}weekly{br}footfall",
		    	      		          "valueOnRight": "1",
		    	      		          "thickness": "2"
		    	      		        }]
		    	      		      }]
		    	      		    }
		    	      		  });

		    	      		  visitChart.render();
		    	      		
		    	          
		    	        }  
		    		});
		   
		}
	  function getreportbyblockname() {
		  
		   	var chartData = [];
		   		$.ajax({
		    	        url: '${pageContext.request.contextPath}/getreportbyblockname',
		    	        type: 'GET',
		    	        success : function(data) {
		    	      		
		    	      		$.each(data, function(i, val) {
		    	      			chartData.push( {"value":val.value, "label": val.label});
		    				});
		    	      		 var visitChart = new FusionCharts({
		    	      		    type: 'pie2d',
		    	      		    renderAt: 'chart-container',
		    	      		    width: '700',
		    	      		    height: '400',
		    	      		    dataFormat: 'json',
		    	      		    dataSource: {
		    	      		      "chart": {
		    	      		        "theme": "fusion",
		    	      		        "caption": "Report By Block Name",
		    	      		        "xAxisName": "Month",
		    	      		        "yAxisName": "Energy used in KWH",
		    	      		        "lineThickness": "2",
		    	      		        "labelDisplay": "rotate",
		    	      		        "slantLabels": "1"
		    	      		      },
		    	      		      "data": chartData,
		    	      		      "trendlines": [{
		    	      		        "line": [{
		    	      		          "startvalue": "18500",
		    	      		          "color": "#29C3BE",
		    	      		          "displayvalue": "Average{br}weekly{br}footfall",
		    	      		          "valueOnRight": "1",
		    	      		          "thickness": "2"
		    	      		        }]
		    	      		      }]
		    	      		    }
		    	      		  });

		    	      		  visitChart.render();
		    	      		
		    	          
		    	        }  
		    		});
		   
		}
				
		
		
		</script>
