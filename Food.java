public class Food {
    private int nutrition, water;

    public int getWater() {
        return water;
    }

    private String name;

    public int getNutrition() {
        return nutrition;
    }

    public String getName() {
        return name;
    }

    public Food(int nutrition, int water, String name) {
        this.nutrition = nutrition;
        this.water = water;
        this.name = name;
    }
}
