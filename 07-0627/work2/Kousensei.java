class Kosensei {
    int gakunen;
    String bunnya;
    String namae;
    String jukyo; // 追加

    Kosensei(int gakunen, String bunnya, String namae, String jukyo) {
        this.gakunen = gakunen;
        this.bunnya = bunnya;
        this.namae = namae;
        this.jukyo = jukyo;
    }

    void shokai() {
        System.out.println("私は" + this.gakunen + "年" + this.bunnya + "の" + this.namae + "です. 私の住居は" + this.jukyo + "です.");
    }

    static void shokai(Kosensei a) {
        System.out.println("彼は" + a.gakunen + "年" + a.bunnya + "の" + a.namae + "さんです. 彼の住居は" + a.jukyo + "です.");
    }
}
