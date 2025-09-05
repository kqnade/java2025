class KosenseiApp {
    public static void main(String[] args) {
        Kosensei ryo = new Kosensei();

        ryo.getProfile(); // スマホなし

        Sumaho s1 = new Sumaho("AQUOS", 6.1, 8);
        ryo.setSumaho(s1);

        ryo.getProfile(); // スマホあり

        // 他の例（エラー確認）
        try {
            ryo.setInformation(10, "建築", "リョウ", "下宿");
        } catch (Exception e) {
            System.out.println(e);
        }

        ryo.getProfile();
    }
}
