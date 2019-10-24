
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mongodb.*" %>
<%@page import="java.util.*, java.text.SimpleDateFormat" %>
<%@page import="com.google.gson.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="smartstreet.reports.ReportingCharts" %>

<%

		MongoClientURI uri = new MongoClientURI(
	    "mongodb://iotcluster:iotcluster@iotcluster-shard-00-00-72f0t.mongodb.net:27017,iotcluster-shard-00-01-72f0t.mongodb.net:27017,iotcluster-shard-00-02-72f0t.mongodb.net:27017/admin?ssl=true&replicaSet=iotcluster-shard-0&authSource=admin");
      
		MongoClient mongoClient = new MongoClient(uri);
            //connecting to the database
        DB db = mongoClient.getDB( "iotcluster" );
        //System.out.println("Connected to database successfully");
      
        HashMap<String,String> labelValue = new HashMap<String,String>();
        //fetching the collection from the database  
       DBCollection collection = db.getCollection("sensordata");
       String pattern1 = "YYYY-MMM";
       String pattern2 = "YYYY";
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern1);
       BasicDBObject fields = new BasicDBObject();
   		//fields.put("Street Name", "Oak Street");
   		//fields.put("Block Name", "Oak and South Street");


   		//fields.put("Measurement Timestamp", BasicDBObjectBuilder.start("$gte", simpleDateFormat.parse("2016")).add("$lte", simpleDateFormat.parse("2018")).get());
        //Selects the documents in a collection and returns a cursor to the selected documents
        DBCursor cursor = collection.find(fields).limit(20000);
   		simpleDateFormat = new SimpleDateFormat(pattern1);
  
         while(cursor.hasNext()) {
             DBObject o = cursor.next();
             Date label = (Date) o.get("Measurement Timestamp") ; 
             //label = simpleDateFormat.format(label);
             String value = ((String) o.get("Battery Life"));
           	labelValue.put(simpleDateFormat.format(label), value);
               
         }
          
    %>
    
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
         	<div id="chart"></div>
         	</div>
         	</div>
		</section><!-- /.content -->
      	</div><!-- /.content-wrapper -->

 
        <script src='<c:url value="fusioncharts.js"  />'></script>
        <script src='<c:url value="fusioncharts.theme.fint.js"  />'></script>
        <script src='<c:url value="fusioncharts.charts.js"  />'></script>

        <%
         
            Gson gson = new Gson();
        // The 'chartobj' map object holds the chart attributes and data.
        Map<String, String> chartobj = new HashMap<String, String>();//for getting key value pair
            
            // The &apos;chartobj&apos; map object holds the chart attributes and data.
            chartobj.put("caption", "Battery Life of sensors");
            //chartobj.put("subCaption" , "Last year");
            chartobj.put("paletteColors" , "#0075c2");
            chartobj.put("bgColor" , "#ffffff");
            chartobj.put("showBorder" , "0");
            chartobj.put("theme","fint");
            chartobj.put("showPercentValues" , "1");
            chartobj.put("decimals" , "1");
            chartobj.put("captionFontSize" , "14");
            chartobj.put("subcaptionFontSize" , "14");
            chartobj.put("subcaptionFontBold" , "0");
            chartobj.put("toolTipColor" , "#ffffff");
            chartobj.put( "toolTipBorderThickness" , "0");
            chartobj.put("toolTipBgColor" , "#000000");
            chartobj.put("toolTipBgAlpha" , "80");
            chartobj.put("toolTipBorderRadius" , "2");
            chartobj.put("toolTipPadding" , "5");
            chartobj.put("showHoverEffect" , "1");
            chartobj.put("yAxisName", "Battery Life");
         
           // to store the entire data object
            ArrayList arrData = new ArrayList();
            for(Map.Entry m:labelValue.entrySet()) 
            {
                // to store the key value pairs of label and value object of the data object
                Map<String, String> lv = new HashMap<String, String>();
                lv.put("label", m.getKey().toString() );
                lv.put("value", m.getValue().toString());
                arrData.add(lv);             
            }
            //close the connection.
            //cursor.close();
 
            //create &apos;dataMap&apos; map object to make a complete FC datasource.
             Map<String, String> dataMap = new LinkedHashMap<String, String>();  
        /*
            gson.toJson() the data to retrieve the string containing the
            JSON representation of the data in the array.
        */
         dataMap.put("chart", gson.toJson(chartobj));
         dataMap.put("data", gson.toJson(arrData));

         ReportingCharts columnChart= new ReportingCharts(
            "line",// chartType
                        "chart2",// chartId
                        "600","400",// chartWidth, chartHeight
                        "chart",// chartContainer
                        "json",// dataFormat
                        gson.toJson(dataMap) //dataSource
                    );
            %>
            
<!--    Step 5: Render the chart    -->                
            <%=columnChart.render()%>

 
 
      