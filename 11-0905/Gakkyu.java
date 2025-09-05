public class Gakkyu {
    // ---- フィールド ----
    private int saidai;        // 最大人数
    private Kosensei[] a;      // 高専生参照配列
    private int jissai;        // 実際の人数

    // ---- コンストラクタ ----
    public Gakkyu() {
        this.saidai = 5;
        this.a = new Kosensei[this.saidai];
        this.jissai = 0;
    }

    // ---- 追加 ----
    public void add(Kosensei s) {
        if (this.jissai >= this.saidai) {
            System.out.println("[Gakkyu エラー] これ以上追加できません (capacity=" + this.saidai + ")");
            return;
        }
        this.a[this.jissai] = s;
        this.jissai++;
    }

    // ---- 実際の人数 ----
    public int size() {
        return this.jissai;
    }

    // ---- 指定番号の高専生取得 ----
    public Kosensei get(int idx) {
        if (idx < 0 || idx >= this.jissai) {
            System.out.println("[Gakkyu エラー] 不正なインデックス: " + idx);
            return null;
        }
        return this.a[idx];
    }

    // ---- 全員自己紹介 ----
    public void shokai() {
        System.out.println("=== 学級自己紹介 (" + this.jissai + "人) ===");
        for (int i = 0; i < this.jissai; i++) {
            this.a[i].shokai();
            System.out.println("------------------------------");
        }
    }
}