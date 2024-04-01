import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello. How would you name your tamagotchi?\nEnter the name: ");
        name = scanner.nextLine();
        Tamagotchi tamagotchi = new Tamagotchi(name);
        new Timer().scheduleAtFixedRate(new GameController(tamagotchi), 0, 6000);
        new GameInterface(tamagotchi);
    }
}