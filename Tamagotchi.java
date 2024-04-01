import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tamagotchi implements ITamagotchi {
    private int hunger, thirst, happiness;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    private List<Food> stomach;

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        if (this.hunger + hunger < 0) {
            death();
        } else if (this.hunger + hunger > 100) {
            this.hunger = 100;
        } else {
            this.hunger = hunger;
        }
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        if (this.thirst + thirst < 0) {
            death();
        } else if (this.thirst + thirst > 100) {
            this.thirst = 100;
        } else {
            this.thirst = thirst;
        }
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if (this.happiness + happiness < 0) {
            suicide();
        } else if (this.happiness + happiness > 100) {
            this.happiness = 100;
        } else {
            this.happiness = happiness;
        }
    }

    public Tamagotchi(String nickname) {
        this.nickname = nickname;
        hunger = thirst = 50;
        happiness = (hunger + thirst) / 2;
        stomach = new ArrayList<>();
    }

    public void feed(Food food) {
        stomach.add(food);
        hunger += food.getNutrition();
        thirst += food.getWater();
    }

    public void death() {
        String deathCause = String.format("%s has died of ", nickname);
        if (thirst < 0) {
            deathCause += "thirst";
        } else if (hunger < 0) {
            deathCause += "hunger";
        }
        System.out.println(deathCause);
        GameInterface.exit();
    }

    public void suicide() {
        System.out.println(nickname + " has commited suicide");
        GameInterface.exit();
    }

    public void play() {
        String playType = "";
        int happinessIncreaseLevel = 0;
        Random random = new Random();
        // int randomActivity = random.nextInt(1, 4);
        switch (random.nextInt(3) + 1) {
            case 1:
                playType = String.format("You have petted %s!\n", nickname);
                happinessIncreaseLevel = 5;
                break;
            case 2:
                playType = String.format("You have thrown a ball! %s has got it\n", nickname);
                happinessIncreaseLevel = 10;
                break;
            case 3:
                playType = String.format("%s seems to be having fun with that laser pointer!\n", nickname);
                happinessIncreaseLevel = 10;
            default:
                break;
        }
        System.out.println(playType);
        setHunger(hunger - 5);
        setThirst(thirst - 5);
        setHappiness(happiness + happinessIncreaseLevel);
    }
}