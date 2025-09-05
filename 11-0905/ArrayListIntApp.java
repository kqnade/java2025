public class ArrayListIntApp {
    public static void main(String[] args) {
        System.out.println("===== ArrayListInt テスト =====");
        ArrayListInt list = new ArrayListInt();

        list.add(314);
        list.add(271);
        list.add(173);
        list.add(256);
        list.add(999);

        // 一杯になった後の追加 (エラー確認)
        list.add(123);

        list.print();

        // getテスト
        System.out.println("size = " + list.size());
        System.out.println("get(0) = " + list.get(0));
        System.out.println("get(2) = " + list.get(2));
        System.out.println("get(4) = " + list.get(4));

        // 範囲外
        System.out.println("get(5) = " + list.get(5));
    }
}