import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
  
public class myjsonparsorPMS
{
    public static void main(String[] args) throws Exception 
    {
        // parsing file "JSONExamplePMS.json"
        Object obj = new JSONParser().parse(new FileReader("JSONExamplePMS.json"));
          
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting phoneNumbers
        JSONArray ja = (JSONArray) jo.get("Data");

        //System.out.println(ja.get(1).toString());
        
        //print the output
        String myline = "";

        int y1 = ja.size();

        try{

            for(int y=0;y<y1;y++) {

                String jsonStore = ja.get(y).toString(); // per index

                String jsonString = "";

                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(jsonStore);

                myline = myline 
                + json.get("LocalReservationId") + ";" 
                + json.get("ArrivalDate") + ";" 
                + json.get("DepartureDate") + ";" 
                + json.get("HotelCode") + ";" 
                + json.get("NumberOfPersons") + ";" 
                + json.get("NumberOfNights")  + ";";
                // Reservation information gathered

                // Booker from root of the reservation ********************************
                jsonString = json.get("Booker").toString();

                json = (JSONObject) parser.parse(jsonString);

                myline = myline 
                + json.get("IpAddress") + ";"
                + json.get("PersonId") + ";"
                + json.get("FirstName") + ";"
                + json.get("LastName") + ";"
                + json.get("EmailAddress") + ";"
                + json.get("TypeCode") + ";"
                + json.get("GenderCode") + ";"
                + json.get("NewsletterSubscription") + ";";



                // Subreservations *****************************************
                json = (JSONObject) parser.parse(jsonStore);

                jsonString = json.get("SubReservations").toString();
                //System.out.println(jsonString);

                JSONArray jaSubReservations = (JSONArray) json.get("SubReservations");
                String jsonStoreSubres = jaSubReservations.get(0).toString(); //  index#0

                jsonString = jsonStoreSubres;

                json = (JSONObject) parser.parse(jsonString);
                //System.out.println(json.toString());

                myline = myline 
                + json.get("UnitCode") + ";"; 



                // sub reservatio's booker
                jsonString = json.get("Booker").toString();
                json = (JSONObject) parser.parse(jsonString);

                myline = myline 
                + "*** SUBRESERVATION BOOKER***" + ";"
                + json.get("PersonID") + ";"
                + json.get("IpAddress") + ";"
                + json.get("FirstName") + ";"
                + json.get("LastName") + ";"
                + json.get("EmailAddress") + ";"
                + json.get("TypeCode") + ";"; 
              


                // sub reservatio's Promary guest
                jsonString = jsonStoreSubres;

                json = (JSONObject) parser.parse(jsonString);
                jsonString = json.get("PrimaryGuest").toString();

                json = (JSONObject) parser.parse(jsonString);
                
                myline = myline 
                + "*** SUBRESERVATION PRIMARY GUEST ***" + ";"
                + json.get("PersonId") + ";"
                + json.get("IpAddress") + ";"
                + json.get("FirstName") + ";"
                + json.get("LastName") + ";"
                + json.get("EmailAddress") + ";"
                + json.get("TypeCode") + ";"; 


                JSONArray externalRefArr = (JSONArray) json.get("ExternalReferences");

                int y2 = externalRefArr.size();

                for(int yy=0;yy<y2;yy++) {

                    jsonString = externalRefArr.get(yy).toString(); // per index
                    json = (JSONObject) parser.parse(jsonString);

                    myline = myline 
                    + "*** External References  ***" + ";"
                    + json.get("Id") + ";"
                    + json.get("SystemCode") + ";"
                    + json.get("Code") + ";"
                    + json.get("TypeCode") + ";"; 

                }

                System.out.println(myline);

                System.out.println("......" + y + " is done ...!");

                myline = "";
                
            }  

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index " + e);
         }    
         catch (Exception e) {
            System.out.println("Other Exception " + e);
         }   
         finally {
            System.out.println("Done ..!!");
         }   

        //System.out.println(myline);

    }
}