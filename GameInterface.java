import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

public class GameInterface {
    private Tamagotchi tamagotchi;
    private Scanner scanner;
    private List<Food> availableFood;
    private int menuEntry = 0;
    private static long startTime;

    public GameInterface(Tamagotchi tamagotchi) {
        startTime = System.currentTimeMillis();
        availableFood = new ArrayList<>();
        availableFood.add(new Drink("Milk", 20));
        availableFood.add(new SolidFood("Apple", 10));
        availableFood.add(new SolidFood("Meat steak", 30));
        availableFood.add(new Drink("Water", 15));

        System.out.println("Great. You have named him: " + tamagotchi.getNickname());
        System.out.println("Here is what you can do: ");
        this.tamagotchi = tamagotchi;
        scanner = new Scanner(System.in);
        do {
            displayMenu();
        } while (menuEntry > 0 && menuEntry <= 4);
        exit();
    }

    public void displayAvailableFood() {
        System.out.println("Available food:");
        for (int i = 0; i < availableFood.size(); i++) {
            System.out.println((i + 1) + ". " + availableFood.get(i).getName());
        }
    }

    public void displayMenu() {
        String nickname = tamagotchi.getNickname();
        System.out.println("1. Play with " + nickname);
        System.out.println("2. Feed " + nickname);
        System.out.println("3. Display available food");
        System.out.println("4. Display his stats");
        System.out.println("Any other number to exit");

        menuEntry = scanner.nextInt();
        switch (menuEntry) {
            case 1:
                playWithTamagotchi();
                break;
            case 2:
                feedTamagotchi();
                break;
            case 3:
                displayAvailableFood();
                break;
            case 4:
                displayStats();
                break;
            default:
                break;
        }
    }

    public void feedTamagotchi() {
        displayAvailableFood();
        System.out.print("Choose a food to feed: ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= availableFood.size()) {
            tamagotchi.feed(availableFood.get(choice - 1));
            System.out.println(
                    "You have fed " + tamagotchi.getNickname() + " with " + availableFood.get(choice - 1).getName());
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public void playWithTamagotchi() {
        tamagotchi.play();
    }

    public void displayStats() {
        String stats = String.format("Thirst: %s\nHunger: %s\nHappiness: %s", tamagotchi.getThirst(),
                tamagotchi.getHunger(),
                tamagotchi.getHappiness());
        System.out.println(stats);
    }

    public static void exit() {
        long exitTime = System.currentTimeMillis();
        long difference = (exitTime - startTime) / 1000;
        System.out.println("Your session has lasted for " + difference + " seconds");
        System.exit(0);
    }
}
