public class Kosensei {
    // ---- フィールド ----
    private int gakunen;      // 学年
    private String bunnya;    // 分野
    private String namae;     // 名前

    // ---- コンストラクタ ----
    public Kosensei(int gakunen, String bunnya, String namae) {
        this.gakunen = gakunen;
        this.bunnya = bunnya;
        this.namae = namae;
    }

    // ---- アクセサー ----
    public int getGakunen() {
        return this.gakunen;
    }

    public String getBunnya() {
        return this.bunnya;
    }

    public String getNamae() {
        return this.namae;
    }

    // ---- メソッド ----
    public void shokai() {
        System.out.println("学年: " + this.gakunen);
        System.out.println("分野: " + this.bunnya);
        System.out.println("名前: " + this.namae);
    }
}
