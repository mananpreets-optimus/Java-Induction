package com.bingintergration.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Class MainController : The dispatcher will redirect the request to this class
 * when request for /calculate comes
 */
@Controller
@RequestMapping("/calculate")
public class MainController extends AbstractController {

	public static final String bingAuthenticationKey = "AglaMOH0NMycoQcSEXqAWnyIDj-SMwkcLAm4ikEXjH81L_G6OcjW9pc9jHCOoD9R";
	public static final String bingUrl = "http://dev.virtualearth.net/REST/V1/Routes/Driving";
	
	/**
	 * Method handleRequestInternal : Process the request and return a ModelAndView object which the
	 * DispatcherServlet will use and render.
	 */
	@Override
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		
		/** session */
		@SuppressWarnings("unused")
		HttpSession session = request.getSession(false);
		
		/** getting source parameter from request*/
		String source = request.getParameter("Source");
		
		/** getting destination parameter from request*/
		String destination = request.getParameter("Destination");
		
		/** creating URL dynamically based on source and destination */
		String url = prepareDynamicURL(source, destination);
		
		/** received data from bing API*/
		String jsonResponse = getResultHttpAsStream(url);
		String[] travelInfo=null;
		if(jsonResponse.charAt(0)=='{')
		{
			travelInfo = parseResponse(jsonResponse);
		}
		ModelAndView model = new ModelAndView("hello");
		model.addObject("response", travelInfo);
		model.addObject("source", source);
		model.addObject("destination", destination);
		return model;

	}
	
	/**
	 * 
	 * @param jsonResponse response received from Bing API
	 * @return travelInfo String array containing information retrieved from response
	 */
	protected String[] parseResponse(String jsonResponse) 
	{
		JSONObject jsonObject = new JSONObject(jsonResponse);
		JSONArray jsonArr = jsonObject.getJSONArray("resourceSets");
		JSONObject jsonObj1 = jsonArr.getJSONObject(0);
		JSONArray jsonArr2 = jsonObj1.getJSONArray("resources");
		JSONObject jsonObj2 = jsonArr2.getJSONObject(0);
		String travelDistance = String.valueOf(jsonObj2.get("travelDistance"));
		String traveltime = String.valueOf(jsonObj2.get("travelDuration"));
		String travelTimeDuringTraffic =  String.valueOf(jsonObj2.get("travelDurationTraffic"));
		System.out.println("travelDistance : " + travelDistance);
		System.out.println("traveltime : " + traveltime);
		System.out.println("travelTimeDuringTraffic : "+travelTimeDuringTraffic);
		String[] travelInfo = { travelDistance, traveltime, travelTimeDuringTraffic };
		return travelInfo;

	}
	
	/**
	 * Method getResultHttpAsStream : receive response from bing API
	 * @param url URL of bing API
	 * @return response response from bing API
	 * @throws IOException
	 */
	protected String getResultHttpAsStream(String url) throws IOException {
		
		HttpURLConnection conn = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = new StringBuffer();
		URL urlString = new URL(url);
		conn = (HttpURLConnection) urlString.openConnection();
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			System.out.println(conn.getResponseCode());
			bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) 
			{
				stringBuffer.append(line);
			}
			bufferedReader.close();
		}
		else {
			return "Enter a valid location";
		}
		return stringBuffer.toString();
	}

	/**
	 * Method prepareDynamicURL : prepared URL based on parameters received from user
	 * @param source source name
	 * @param destination destination name
	 * @return URL URL of bing API
	 */
	protected String prepareDynamicURL(String source, String destination) {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(bingUrl).append("?o=json");
		stringBuffer.append("&").append("wp.0").append("=");
		try {
			stringBuffer.append(encodeString(source)).append("&wp.1").append("=").append(encodeString(destination));
		} 
		catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported code of state. Ignore the state");
		}
		
		stringBuffer.append("&avoid").append("=").append("minimizeTolls&").append("key").append("=").append(bingAuthenticationKey);
		return stringBuffer.toString();
	}
	
	/**
	 * Method encodeString encodes URL
	 * @param str URL substring
	 * @return URL encoded URL
	 * @throws UnsupportedEncodingException
	 */
	protected String encodeString(String str) throws UnsupportedEncodingException {
		return URLEncoder.encode(str.replace(".", "").replace(":", ""), "UTF-8").replace("+", "%20").replace(",", "&2C");
	}

}
