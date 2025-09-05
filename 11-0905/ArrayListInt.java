public class ArrayListInt {
    private int saidai;   // 最大の要素数 (capacity)
    private int[] a;      // 配列本体
    private int jissai;   // 実際の要素数 (size)

    public ArrayListInt() {
        this.saidai = 5;
        this.a = new int[this.saidai];
        this.jissai = 0;
    }

    public void add(int x) {
        if (this.jissai >= this.saidai) {
            System.out.println("[ArrayListInt エラー] これ以上追加できません (capacity=" + this.saidai + ")");
            return;
        }
        this.a[this.jissai] = x;
        this.jissai++;
    }

    public int size() {
        return this.jissai;
    }

    public int get(int idx) {
        if (idx < 0 || idx >= this.jissai) {
            System.out.println("[ArrayListInt エラー] 不正なインデックス: " + idx);
            return 0;
        }
        return this.a[idx];
    }

    // ---- 全要素表示 ----
    public void print() {
        System.out.print("ArrayListInt: [");
        for (int i = 0; i < this.jissai; i++) {
            System.out.print(this.a[i]);
            if (i != this.jissai - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("] (size=" + this.jissai + " / capacity=" + this.saidai + ")");
    }
}