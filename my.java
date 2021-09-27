import java.awt.Desktop;
import java.net.URI;

;public class my {
    public static void main(String[] args) throws Exception{

        //int a = 2;

        Desktop desk = Desktop.getDesktop();
        
        desk.browse(new URI("https://semester.thestudenthotel.com/en/ibe/results/?hotelId=VIE01&arrival=2021-08-31&departure=2022-02-28"));
        desk.browse(new URI("https://semester.thestudenthotel.com/en/ibe/results/?hotelId=VIE01&arrival=2021-08-25&departure=2022-02-25"));

        System.out.println("Hi There");


    
    }

}