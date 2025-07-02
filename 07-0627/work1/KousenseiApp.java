class KosenseiApp {
    public static void main(String[] args) {
        Kosensei ryo = new Kosensei(2, "建築", "リョウ");
        Kosensei yui = new Kosensei(3, "機械", "ユイ");

        ryo.shokai();
        yui.shokai();
        Kosensei.shokai(ryo);
        Kosensei.shokai(yui);
    }
}
