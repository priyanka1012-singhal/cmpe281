
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mongodb.*" %>
<%@page import="java.util.*" %>
<%@page import="com.google.gson.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="smartstreet.reports.ReportingCharts" %>
   <script src='<c:url value="fusioncharts.js" />'></script>

    
    
   
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           View Energy Usage
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Monitor</a></li>
            <li class="active">View Energy Usage</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content">
        <div class="row">
            <!-- left column -->
            <div class="col-md-8">
         	<div id="chart-container"></div>
         	</div>
         	</div>
		</section><!-- /.content -->
      	</div><!-- /.content-wrapper -->
		<script>

	    FusionCharts.ready(function() {
	    var visitChart = new FusionCharts({
	    type: 'line',
	    renderAt: 'chart-container',
	    width: '700',
	    height: '400',
	    dataFormat: 'json',
	    dataSource: {
	      "chart": {
	        "theme": "fusion",
	        "caption": "Monthly Energy Usage of Sensors",
	        "subcaption": "Oak and South Street",
	        "xAxisName": "Month",
	        "yAxisName": "Energy used in KWH",
	        "lineThickness": "2",
	        "labelDisplay": "rotate",
	        "slantLabels": "1"
	      },
	      "data": [{
	          "label": "Nov 2017",
	          "value": "6300"
	        },
	        {
	          "label": "Jan 2018",
	          "value": "3849"
	        },
	        {
	          "label": "Feb 2018",
	          "value": "3453"
	        },
	        {
	          "label": "March 2018",
	          "value": "2748"
	        },
	        {
	          "label": "April 2018",
	          "value": "5473"
	        },
	        {
	          "label": "May 2018",
	          "value": "6839"
	        },
	        {
	          "label": "June 2018",
	          "value": "6384"
	        },
	        {
	          "label": "July 2018",
	          "value": "5438"
	        },
	        {
	          "label": "Aug 2018",
	          "value": "4564"
	        },
	        {
	          "label": "Sep 2018",
	          "value": "7635"
	        },
	        {
	          "label": "Oct 2018",
	          "value": "6739"
	        },
	        {
	          "label": "Nov 2018",
	          "value": "5678"
	        }

	      ],
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
	});
		
		
		</script>
