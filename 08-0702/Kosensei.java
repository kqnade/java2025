import java.util.Set;

class Kosensei {
    private int gakunen;
    private String bunnya;
    private String namae;
    private String jukyo; // 追加

    private static final Set<String> VALID_MAJORS = Set.of("情報", "機械", "電気", "電子", "建築");

    public Kosensei() {
        this.gakunen = 0;
        this.bunnya = "null";
        this.namae = "null";
        this.jukyo = "null";
    }

    public void getProfile() {
        System.out.println("私は" + this.gakunen + "年" + this.bunnya + "の" + this.namae + "です. 私の住居は" + this.jukyo + "です.");
    }
    public int getGakunen(){
        return this.gakunen;
    }
    public String getNamae(){
        return this.namae;
    }
    public String getBunnya(){
        return this.namae;
    }
    public String getJukyo(){
        return this.namae;
    }

    public void setInformation(int gakunen, String bunnya, String namae, String jukyo){
        if (0 < gakunen && gakunen < 6){
            this.gakunen = gakunen;
        } else {
            throw new IllegalArgumentException("無効なgakunenです: " + gakunen);
        }
        if (VALID_MAJORS.contains(bunnya)) {
            this.bunnya = bunnya;
        } else {
            throw new IllegalArgumentException("無効な専攻です: " + bunnya);
        }
        this.namae = namae;
        this.jukyo = jukyo;
    }
}
