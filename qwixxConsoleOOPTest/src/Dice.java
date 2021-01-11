import java.util.Random;

public class Dice {

    private String color;

    public Dice(String color) {
        this.color = color;
    }

    public int roll() {
        Random random = new Random();
        int rolledNumber = random.nextInt(6)+1;

        return rolledNumber;
    }
}

