public class RyoseiApp {
    public static void main(String[] args) {
        // 課題3のテスト
        Ryosei r1 = new Ryosei(1, "電気電子", "鈴木一郎");
        Ryosei r2 = new Ryosei(2, "情報工学", "山田次郎");

        // 相互にセット
        r1.setDoshitsusha(r2);
        r2.setDoshitsusha(r1);

        r1.shokai();
        System.out.println("--------------------------------");
        r2.shokai();
    }
}
