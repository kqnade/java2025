import java.io.*;

public class MyCat {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            String buf;
            while ((buf = br.readLine()) != null) {
                System.out.println(buf);
            }
            br.close();
            fr.close();
        }
        catch (IOException ex) {
            System.out.println("ファイル読込みエラー");
            System.exit(1);
        }
    }
}
