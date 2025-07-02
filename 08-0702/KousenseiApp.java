class KosenseiApp {
    public static void main(String[] args) {
        Kosensei ryo = new Kosensei();

        try {
          ryo.setInformation(10, "建築", "リョウ", "下宿");
        } catch (Exception e) {
          System.out.println(e);
        }

        ryo.getProfile();


       
    }
}
