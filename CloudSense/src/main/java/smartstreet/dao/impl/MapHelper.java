package smartstreet.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MapHelper {
	private static final String GEO_CODE_SERVER = "https://maps.googleapis.com/maps/api/geocode/json?";
	public String getGeoLocation(String address)
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
	public  String getUrl(String address)
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
	public  String[] parseLocationResponse(String response)
	{
	    String[] lines = response.split("\n");	
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
	public  String getCord(String latlong)
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
}
