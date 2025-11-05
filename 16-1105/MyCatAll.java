import java.io.*;

public class MyCatAll {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                FileReader fr = new FileReader(args[i]);
                BufferedReader br = new BufferedReader(fr);
                String buf;
                while ((buf = br.readLine()) != null) {
                    System.out.println(buf);
                }
                br.close();
                fr.close();
            }
            catch (IOException ex) {
                System.out.println("ファイル読込みエラー: " + args[i]);
                System.exit(1);
            }
        }
    }
}
