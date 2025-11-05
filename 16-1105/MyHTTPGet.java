import java.io.*;
import java.net.*;

public class MyHTTPGet {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://jsuri1.info.kushiro-ct.ac.jp/~tenmo/java/hello.txt");
            
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("GET");
            http.connect();
            
            InputStreamReader isr = new InputStreamReader(http.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            
            String buf;
            while ((buf = br.readLine()) != null) {
                System.out.println(buf);
            }
            br.close();
            isr.close();
        }
        catch (IOException ex) {
            System.out.println("ファイル読込みエラー");
            System.exit(1);
        }
    }
}
