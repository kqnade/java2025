class DiceApp {
public static void main(String[] args) {
        Dice dice = new Dice(6);
        for (int i = 0; i < 100; i++) {
            int result = dice.roll();
            System.out.println("出目: " + result);
        }

        System.out.println("合計: " + dice.getSumOfRolls());
        System.out.println("回数: " + dice.getTotalRolls());
        System.out.println("平均: " + dice.getAverage());
    }
}
