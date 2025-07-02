class Sumaho {
    private String namae;      // スマホの名前
    private double screenSize; // 画面サイズ（インチ）
    private int memoryGB;      // メモリ容量（GB）

    // コンストラクタ
    public Sumaho(String namae, double screenSize, int memoryGB) {
        setNamae(namae);
        setScreenSize(screenSize);
        setMemoryGB(memoryGB);
    }

    public String getNamae() {
        return namae;
    }
    public void setNamae(String namae) {
        if (namae == null || namae.isEmpty()) {
            throw new IllegalArgumentException("名前は空にできません");
        }
        this.namae = namae;
    }

    public double getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(double screenSize) {
        if (screenSize < 3.0 || screenSize > 7.0) {
            throw new IllegalArgumentException("画面サイズは3.0〜7.0インチのみです");
        }
        this.screenSize = screenSize;
    }

    public int getMemoryGB() {
        return memoryGB;
    }
    public void setMemoryGB(int memoryGB) {
        if (memoryGB < 1 || memoryGB > 16) {
            throw new IllegalArgumentException("メモリ容量は1〜16GBのみです");
        }
        this.memoryGB = memoryGB;
    }

    public void printInfo() {
        System.out.println("スマホ名: " + namae +
                           ", 画面サイズ: " + screenSize + "インチ" +
                           ", メモリ: " + memoryGB + "GB");
    }
}
