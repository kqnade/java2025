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

    void hantei(Kosensei other) {
        if (this.jukyo.equals(other.jukyo)) {
            System.out.println("私「" + this.namae + "」と「" + other.namae + "」さんは通学仲間です.");
        } else {
            System.out.println("私「" + this.namae + "」と「" + other.namae + "」さんは通学仲間ではありません.");
        }
    }

    static void hantei(Kosensei a, Kosensei b) {
        if (a.jukyo.equals(b.jukyo)) {
            System.out.println("「" + a.namae + "」さんと「" + b.namae + "」さんは通学仲間です.");
        } else {
            System.out.println("「" + a.namae + "」さんと「" + b.namae + "」さんは通学仲間ではありません.");
        }
    }

    void shinkyu() {
        this.gakunen += 1;
        System.out.println("私は" + this.gakunen + "年に進級しました!");
    }

    static void shinkyu(Kosensei a) {
        a.gakunen += 1;
        System.out.println(a.namae + "さんは" + a.gakunen + "年に進級しました!");
    }
}
