import java.util.TimerTask;

public class GameController extends TimerTask {
    Tamagotchi tamagotchi;

    @Override
    public void run() {
        int hungerLevel = tamagotchi.getHappiness(), thirstLevel = tamagotchi.getThirst();
        tamagotchi.setHunger(hungerLevel - 1);
        tamagotchi.setThirst(thirstLevel - 2);
        tamagotchi.setHappiness((hungerLevel + thirstLevel) / 2);
    }

    public GameController(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }
}