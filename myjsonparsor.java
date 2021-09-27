import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
  
public class myjsonparsor 
{
    public static void main(String[] args) throws Exception 
    {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
          
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
          
        // getting firstName and lastName
        String firstName = (String) jo.get("firstName");
        String lastName = (String) jo.get("lastName");
                    
        // getting age
        long age = (long) jo.get("age");

        // getting phoneNumbers
        JSONArray ja = (JSONArray) jo.get("phoneNumbers");
        
        //print the output
        String myline = firstName + ";" + lastName + ";" + age + ";";

        try{

            for(int y=0;y<10;y++) {
                //System.out.println(y);                
                String jsonString = ja.get(y).toString();

                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(jsonString);

                myline = myline + json.get("type") + ";" + json.get("number")  + ";";
            }  
        } catch (Exception e) { }    

        System.out.println(myline);

    }
}