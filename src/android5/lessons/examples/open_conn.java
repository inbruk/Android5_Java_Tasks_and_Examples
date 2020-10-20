package JavaLessons.Task521;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class open_conn {

    public static void main(String[] args)  throws Exception  {

        Some sc = new Some();
        sc.setEmail("gqerrger");

        int c;
        URL hpd= new URL("http", "localhost", 8888, "/");
        URLConnection hpCon = hpd.openConnection();
        System.out.println("Date: " + hpCon.getDate());
        System.out.println("Type: " + hpCon.getContentType());
        System.out.println("Exp: " + hpCon.getExpiration());
        System.out.println("Last M: " + hpCon.getLastModified());
        System.out.println("Length: " + hpCon.getContentLength());
        if (hpCon.getContentLength() > 0) {
            System.out.println("=== Content ===");
            InputStream input = hpCon.getInputStream();
            int i = hpCon.getContentLength();
            while (((c = input.read()) != -1) && (--i > 0)) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("No Content Available");
        }
    }

}
