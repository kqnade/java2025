class KosenseiApp {
    public static void main(String[] args) {
        Kosensei ryo = new Kosensei(2, "建築", "リョウ", "下宿");
        Kosensei yui = new Kosensei(3, "機械", "ユイ", "学寮");

        ryo.shokai();
        yui.shokai();
        Kosensei.shokai(ryo);
        Kosensei.shokai(yui);
    }
}
