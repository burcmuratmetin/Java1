import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
  
public class myjsonparsormulti2
{

    private static FileWriter file;

    public static void main(String[] args) throws Exception 
    {
        String fileNamePart1 = "JSONMulti"; 
        String fileNamePart3 = ".json"; 
        //String fileEmpty = "";

        file = new FileWriter("JSONMultiToWrite.json");

        try{

            for(int y=1;y<3;y++) {

                String fileName = fileNamePart1 + y + fileNamePart3;

                JSONParser parser = new JSONParser();

                Object obj = parser.parse(new FileReader(fileName));
 
                // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
                JSONObject jsonObject = (JSONObject) obj;

                // A JSON array. JSONObject supports java.util.List interface.
                JSONArray ja = (JSONArray) jsonObject.get("Data");

                JSONObject jsonObject2 = (JSONObject) obj;

                jsonObject2 = (JSONObject) parser.parse(ja.get(0).toString());

                file.write(jsonObject.toJSONString());
                file.write("\n");

                int arraySize = ja.size();

                for(int y2=0;y2<arraySize;y2++) {

                    System.out.println(ja.get(y2).toString());

                    jsonObject2 = (JSONObject) parser.parse(ja.get(y2).toString());
                    file.write(jsonObject2.toJSONString());
                    file.write("\n");

                    file.write("My Unit : " + jsonObject2.get("UnitCode").toString());
                    file.write("\n");

                    file.write("My Reservation : " + jsonObject2.get("LocalReservationId").toString());
                    file.write("\n");

                }
            }  

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index " + e);
         }    
         catch (Exception e) {
            System.out.println("Other Exception " + e);
         }   
         finally {
            //file.flush();
            file.close();
            System.out.println("Done ..!! ");
         }   

    }
}