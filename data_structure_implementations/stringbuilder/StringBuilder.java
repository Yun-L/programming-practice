//*******************************************************************
//  StringBuilder
//  
//  A simple SimpleBuilder implementation 
//*******************************************************************
import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;

public class StringBuilder {
    // instance variables
    ArrayList<String> strings;


    // constructors
    public StringBuilder() {
        strings = new ArrayList<String>();
    }

    public void add(String s) {
        strings.add(s);
    }

    public String toString() {
        return String.join("", strings);
    }

    public static void main(String[] args) {
        
        // test using StringBuilder   
        Instant time_start = Instant.now();
        
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 1000000; x++) {
            sb.add("Eeee");
        }
        String s = sb.toString();
        Instant time_end = Instant.now();
        System.out.println("Using StringBuilder: " + 
                            Duration.between(time_start, time_end).getSeconds());
        
        // test for normal string concatenation
        time_start = Instant.now();
        
        String test = "";
        for (int x = 0; x < 1000000; x++) {
            test += "Eeee";
        }

        time_end = Instant.now();
        System.out.println("Using concatenation: " +
                            Duration.between(time_start, time_end).getSeconds());

    }
}