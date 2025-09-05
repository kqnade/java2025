public class GakkyuApp {
    public static void main(String[] args) {
        System.out.println("===== Gakkyu テスト =====");
        Gakkyu g = new Gakkyu();

        // 通学生 (Tsusei)
        Tsusei t1 = new Tsusei(3, "機械工学", "佐藤花子", "バス");
        Tsusei t2 = new Tsusei(2, "情報工学", "田中太郎", "自転車");
        Tsusei t3 = new Tsusei(1, "建築学", "高橋光", "徒歩");

        // 寮生 (Ryosei)
        Ryosei r1 = new Ryosei(1, "電気電子", "鈴木一郎");
        Ryosei r2 = new Ryosei(2, "情報工学", "山田次郎");
        // 同室設定
        r1.setDoshitsusha(r2);
        r2.setDoshitsusha(r1);

        // 追加 (スーパークラスのKosenseiは直接追加しない)
        g.add(t1);
        g.add(r1);
        g.add(t2);
        g.add(r2);
        g.add(t3);

        // 満杯後の追加 (エラー確認)
        g.add(new Tsusei(4, "物質工学", "中村空", "電車"));

        // 全員自己紹介
        g.shokai();

        // 個別取得テスト
        System.out.println("インデックス2番の学生:");
        Kosensei s = g.get(2);
        if (s != null) {
            s.shokai();
        }

        // 範囲外取得
        System.out.println("インデックス5番の学生(存在しない):");
        g.get(5);
    }
}