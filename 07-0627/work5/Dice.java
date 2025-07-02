import java.util.Random;

public class Dice {
    private int sides;         // 面数
    private int lastRoll;      // 最後の出目
    private int totalRolls;    // 振った回数
    private int sumOfRolls;    // 出目の合計
    private Random random;

    public Dice(int sides) {
        if (sides < 1) {
            throw new IllegalArgumentException("面の数は1以上である必要があります。");
        }
        this.sides = sides;
        this.random = new Random();
        this.lastRoll = 0;
        this.totalRolls = 0;
        this.sumOfRolls = 0;
    }

    public int roll() {
        lastRoll = random.nextInt(sides) + 1;
        totalRolls++;
        sumOfRolls += lastRoll;
        return lastRoll;
    }

    public int getLastRoll() {
        return lastRoll;
    }

    public int getTotalRolls() {
        return totalRolls;
    }

    public int getSumOfRolls() {
        return sumOfRolls;
    }

    public double getAverage() {
        if (totalRolls == 0) return 0.0;
        return (double) sumOfRolls / totalRolls;
    }

    public void reset() {
        lastRoll = 0;
        totalRolls = 0;
        sumOfRolls = 0;
    }

    
}
