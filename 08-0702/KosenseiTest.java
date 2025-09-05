public class KosenseiTest {
    public static void main(String[] args) {
        // 正常系テスト
        Kosensei k1 = new Kosensei();
        k1.setInformation(2, "情報", "田中", "寮A");
        k1.getProfile();

        Kosensei k2 = new Kosensei();
        k2.setInformation(4, "建築", "佐藤", "寮B");
        k2.getProfile();

        // 異常系テスト（学年不正）
        try {
            Kosensei k3 = new Kosensei();
            k3.setInformation(0, "情報", "山田", "寮C");
        } catch (IllegalArgumentException e) {
            System.out.println("異常系テスト1: " + e.getMessage());
        }

        // 異常系テスト（専攻不正）
        try {
            Kosensei k4 = new Kosensei();
            k4.setInformation(2, "化学", "鈴木", "寮D");
        } catch (IllegalArgumentException e) {
            System.out.println("異常系テスト2: " + e.getMessage());
        }
    }
}
