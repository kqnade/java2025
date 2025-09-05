public class Tsusei extends Kosensei {
    // ---- フィールド ----
    private String kotsu;     // 交通手段

    // ---- コンストラクタ ----
    public Tsusei(int gakunen, String bunnya, String namae, String kotsu) {
        super(gakunen, bunnya, namae);
        this.kotsu = kotsu;
    }

    // ---- アクセサー ----
    public String getKotsu() {
        return this.kotsu;
    }

    // ---- メソッド ----
    @Override
    public void shokai() {
        // 1行でまとめて表示
        System.out.println(
            "学年: "   + getGakunen() +
            " 分野: "  + getBunnya() +
            " 名前: "  + getNamae() +
            " 交通手段: " + this.kotsu
        );
    }
}
