public class SumahoTest {
    public static void main(String[] args) {
        // 正常系テスト
        Sumaho s1 = new Sumaho("Galaxy S24", 6.2, 8);
        Sumaho s2 = new Sumaho("iPhone SE", 4.7, 4);

        s1.printInfo();
        s2.printInfo();

        try {
            Sumaho s3 = new Sumaho("Xperia", 8.1, 4); // 画面サイズが大きすぎ
        } catch (IllegalArgumentException e) {
            System.out.println("異常系テスト1: " + e.getMessage());
        }
        try {
            Sumaho s4 = new Sumaho("Pixel", 6.0, 32); // メモリが大きすぎ
        } catch (IllegalArgumentException e) {
            System.out.println("異常系テスト2: " + e.getMessage());
        }
        try {
            Sumaho s5 = new Sumaho("", 5.5, 4); // 名前空
        } catch (IllegalArgumentException e) {
            System.out.println("異常系テスト3: " + e.getMessage());
        }
    }
}
