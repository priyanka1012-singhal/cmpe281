package smartstreet.utiliy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Code for Google Maps API
 * 
 *
 */
public class GoogleMapHelper {
	
	private static final String GEO_CODE_SERVER = "https://maps.googleapis.com/maps/api/geocode/json?";
	
	public static String getGeoLocation(String address)
	{
		String urlAddress = getUrl(address);
		String response = null;
		try {
			URL url = new URL(urlAddress);
			BufferedReader bReader= null;
			try 
			{
				bReader=new BufferedReader(new InputStreamReader(url.openStream()));			
		        String inputLine;
		        while ((inputLine = bReader.readLine()) != null)
		        {
		        	response+=inputLine;
		        	response+="\n";
				}
		        bReader.close();
			}
			finally
			{
				bReader.close();
			}
		}
	    catch (IOException e)
	    {
	        throw new RuntimeException(e);
	    }
		return response;
	}
	private static String getUrl(String address)
	{
		StringBuilder builder = new StringBuilder();
        builder.append(GEO_CODE_SERVER);
        builder.append("address=");
        builder.append(address.replaceAll(" ", "+"));
        builder.append("&sensor=false");
        builder.append("&key=");
        builder.append("AIzaSyC25YLyuryOygu1l8aI8N6mTASid2wJ-Mo");
      
        return builder.toString();	
	}
	public static String[] getLatLongPositions(String address)
	{
	    String[] lines = address.split("\n");	
	    String lat = null;
	    String lng = null;	
	    for (int i = 0; i < lines.length; i++)
	    {
	        if (("\"location\" : {").equals(lines[i].trim()))
	        {
	            lat = getCord(lines[i+1]);
	            lng = getCord(lines[i+2]);
	            break;
	        }
	    }
	    return new String[] {lat, lng};
	}
	private static String getCord(String latlong)
	{
	    String[] str = latlong.trim().split(" ");		
		if (str.length < 1)
		{
		    return null;
		}	
		String cord = str[str.length - 1];
		
		if (cord.endsWith(","))
		{
			cord = cord.substring(0, cord.length() - 1);
		}
		Double.parseDouble(cord);
		return cord;
	}
	
	/*public static void main(String args[]) {
		String response = getGeoLocation("Oak Street" + "," +"Chicago"+","+"60610");
		String[] result = getLatLongPositions(response);	
		System.out.println(result[0]);
		System.out.println(result[1]);
	}*/	
	
}
	
	/*public static String[] getLatLongPositions(String address) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
	    System.out.println("URL : "+api);
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    if(responseCode == 200)
	    {
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
	         return new String[] {latitude, longitude};
	      }
	      else
	      {
	         throw new Exception("Error from the API - response status: "+status);
	      }
	    }
	    return null;
	  }*/


