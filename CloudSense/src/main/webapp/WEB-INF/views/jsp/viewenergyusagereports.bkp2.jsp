
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mongodb.*" %>
<%@page import="java.util.*" %>
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
      
        //to store the label values from the database
        ArrayList labelValue = new ArrayList();
        //to store the data values of first series from the database
        ArrayList<String> dataValue1 = new ArrayList<String>();
        //to store the data values pf second series from the database
        ArrayList<String> dataValue2 = new ArrayList<String>();
        // to store the categories from the database
        ArrayList category = new ArrayList();
        //fetching the collection from the database  
        DBCollection collection = db.getCollection("sensordata");
        //Selects the documents in a collection and returns a cursor to the selected documents
        DBCursor cursor = collection.find().limit(20);
         while(cursor.hasNext()) {
             DBObject o = cursor.next();
             String labeldata = (String) o.get("Block Name"); 
               //fetching the value
               String value1 = (String) o.get("Battery Life");
               //String value2 = (String) o.get("Measurement Timestamp");
               labelValue.add(labeldata);
               // insert into array list
               dataValue1.add(value1);
               //dataValue2.add(value2);
              //inserting the labels into the category 
               category.add(labelValue);
               
              
               
         }
         /*
         labelValue.add("Nov 2017");
       //inserting the labels into the category 
         category.add(labelValue);
         labelValue.add("Dec 2017");
       //inserting the labels into the category 
         category.add(labelValue);
         labelValue.add("Jan 2018");
       //inserting the labels into the category 
         category.add(labelValue);
         /*labelValue.add("Feb 2018");
         labelValue.add("March 2018");
         labelValue.add("April 2018");
         labelValue.add("May 2018");
         labelValue.add("June 2018");
         labelValue.add("Aug 2018");
         labelValue.add("Sep 2018");
         labelValue.add("Oct 2018");
         labelValue.add("Nov 2018");*/
         /*dataValue1.add("6300");
         dataValue1.add("5374");
         dataValue1.add("3849");
         dataValue1.add("3453");
         dataValue1.add("2748");
         dataValue1.add("5473");
         dataValue1.add("6839");
         dataValue1.add("63843");
         dataValue1.add("5438");
         dataValue1.add("4564");
         dataValue1.add("7635");
         dataValue1.add("6739");
         dataValue1.add("5678");*/
          
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
		<script src='<c:url value="fusioncharts.js" />'></script>
        
        
        
        <%
        
    
            Gson gson = new Gson();
            
            
          
            // The 'chartobj' map object holds the chart attributes and data.
            Map<String, String> chartobj = new HashMap<String, String>();//for getting key value pair
            
            chartobj.put("caption", "Energy Usage from year 2017-2018");
            chartobj.put("subCaption", "Oak Street");
            chartobj.put("captionFontSize", "14");
            chartobj.put("subcaptionFontSize", "14");
            chartobj.put("subcaptionFontBold", "0");
            chartobj.put("paletteColors", "#0075c2,#1aaf5d");
            chartobj.put("bgcolor", "#ffffff");
            chartobj.put("showBorder", "0");
            chartobj.put("showShadow", "0");
            chartobj.put("animation","0");
            chartobj.put("showCanvasBorder", "0");
            chartobj.put("usePlotGradientColor", "0");
            chartobj.put("legendBorderAlpha", "0");
            chartobj.put("legendShadow", "0");
            chartobj.put("showAxisLines", "0");
            chartobj.put("showAlternateHGridColor", "0");
            chartobj.put("divlineThickness", "1");
            chartobj.put("divLineDashed", "1");
            chartobj.put("divLineDashLen", "1");
            chartobj.put("divLineGapLen", "1");
            chartobj.put("xAxisName", "Day");
            chartobj.put("showValues", "0");
            
           //the categories object
           ArrayList categories= new ArrayList();
           
           ArrayList arrData = new ArrayList();
            
            for(int i=0;i<labelValue.toArray().length;i++)
                
            {
                Map<String, String> lv = new HashMap<String, String>();
                lv.put("label", labelValue.toArray()[i].toString() );
                arrData.add(lv);             
            }
         
            Map<String, ArrayList> innercategory = new HashMap<String, ArrayList>(); 
            innercategory.put("category",arrData);
            categories.add(innercategory);
           
            ArrayList dataset = new ArrayList();
            //For first data series
            Map<String, String> ds1 = new HashMap<String, String>();
            //For second dataseries
            Map<String,String> ds2 = new HashMap<String,String>(); 
            
            ds1.put("seriesname","Bakersfield Central");
            
           
            
             ArrayList data1= new ArrayList();
             for(String value1: dataValue1)
                {
                Map<String, String> dv1 = new HashMap<String, String>();
               
                dv1.put("value", value1 );
               
               data1.add(dv1); 
               
              // dataset.add(data);
            }
             ds1.put("data", gson.toJson(data1));
             
              ds2.put("seriesname","Los Angeles Topanga");
             
             ArrayList data2= new ArrayList();
           
            for(String value2: dataValue2)
                {
                Map<String, String> dv2 = new HashMap<String, String>();
               
                dv2.put("value", value2 );
               
               data2.add(dv2);
                }
            ds2.put("data",gson.toJson(data2));
            dataset.add(ds1);
            dataset.add(ds2);
             
            
            //cursor.close();
            //create 'dataMap' map object to make a complete FusionCharts datasource.
             Map<String, String> dataMap = new LinkedHashMap<String, String>();  
      
             dataMap.put("chart", gson.toJson(chartobj));
             dataMap.put("categories", gson.toJson(categories));
             dataMap.put("dataset", gson.toJson(dataset)); 
             //dataMap.put("data", gson.toJson(datasetseriesname)); 

            ReportingCharts mslineChart= new ReportingCharts(
            "msline",// chartType
                        "chart1",// chartId
                        "600","400",// chartWidth, chartHeight
                        "chart",// chartContainer
                        "json",// dataFormat
                        gson.toJson(dataMap) //dataSource
                    );
           
            %>
            
            
            
            
<!--    Step 5: Render the chart    -->                
            
        <%= mslineChart.render() %>
      


