class Kosensei {
    int gakunen;
    String bunnya;
    String namae;

    // コンストラクタ
    Kosensei(int gakunen, String bunnya, String namae) {
        this.gakunen = gakunen;
        this.bunnya = bunnya;
        this.namae = namae;
    }

    void shokai() {
        System.out.println("私は" + this.gakunen + "年" + this.bunnya + "の" + this.namae + "です.");
    }

    static void shokai(Kosensei a) {
        System.out.println("彼は" + a.gakunen + "年" + a.bunnya + "の" + a.namae + "さんです.");
    }
}


