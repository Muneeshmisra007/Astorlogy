package appsbazaar.daily.horoscope;

import java.io.StringReader;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

public class FlowerXMLParser {

	public static HashMap<String, String> parseFeed(String content) {
		
		try {
			
		    boolean inDataItemTag = false;
		    String currentTagName = "";
		 //   Flower flower = null;
		  //  String data[]=new String[2];
		    HashMap<String, String> getHoroscope = new HashMap<String, String>();
String description=null, title=null;
		    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		    XmlPullParser parser = factory.newPullParser();
		    parser.setInput(new StringReader(content));

		    int eventType = parser.getEventType();

		    while (eventType != XmlPullParser.END_DOCUMENT) {

		        switch (eventType) {
		            case XmlPullParser.START_TAG:
		                currentTagName = parser.getName();
		                if (currentTagName.equals("item")) {
		                    inDataItemTag = true;
		                  //  flower = new Flower();
		                   // flowerList.add(flower);
		                }
		                break;

		            case XmlPullParser.END_TAG:
		                if (parser.getName().equals("item")) {
		                    inDataItemTag = false;
		                }
		                currentTagName = "";
		                break;

		            case XmlPullParser.TEXT:
		               if (inDataItemTag  != false) {
		                    switch (currentTagName) {
		                        case "title":
		                           // flower.setProductId(Integer.parseInt(parser.getText()));
		                        	title=parser.getText();
		                        	getHoroscope.put("title", title);
		                            break;
		                        case "description":
		                        	description=parser.getText();
		                        	getHoroscope.put("description", description);
		                        	// flower.setName(parser.getText());
		                        default: 
		                            break; 
		                    } 
		                } 
		                break; 
		        } 

		       eventType = parser.next();

		    }
		   Log.d("check",title+"\n"+description);
		   return getHoroscope;
		    //return flowerList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 

		
	}
	
}
