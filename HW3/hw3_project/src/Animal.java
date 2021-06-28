public abstract class Animal {
    static int happinessLevel = 2;
    static int hungerLevel = 3;
    String food;
    String animalType;
    String action;

    public void printWatchStatement(){
        System.out.println("The " + this.animalType.toLowerCase() + " is " + this.action + "...");
    }

    public void printFeedingStatement(){
        System.out.println("The " + this.animalType.toLowerCase() + " is eating " + this.food + "...");
    }

    public static void incrementHappinessLevel(){
        if (Animal.happinessLevel < 5){
            happinessLevel++;
        }
    }

    public static void incrementHungerLevel(){
        if (Animal.hungerLevel < 5){
            hungerLevel++;
        }
    }

    public static void decrementHungerLevel(){
        if (Animal.hungerLevel > 1){
            hungerLevel--;
        }
    }
}
