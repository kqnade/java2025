public class Ryosei extends Kosensei {
    // ---- フィールド ----
    private Ryosei doshitsusha;  // 同室者

    // ---- コンストラクタ ----
    public Ryosei(int gakunen, String bunnya, String namae) {
        super(gakunen, bunnya, namae);
        this.doshitsusha = null;
    }

    // ---- アクセサー ----
    public Ryosei getDoshitsusha() {
        return this.doshitsusha;
    }

    // ---- セッター ----
    public void setDoshitsusha(Ryosei doshitsusha) {
        this.doshitsusha = doshitsusha;
    }

    // ---- メソッド ----
    @Override
    public void shokai() {
        String partner = (this.doshitsusha == null)
            ? "なし"
            : this.doshitsusha.getNamae();
        System.out.println(
            "学年: "  + getGakunen() +
            " 分野: " + getBunnya() +
            " 名前: " + getNamae() +
            " 同室者: " + partner
        );
    }
}
