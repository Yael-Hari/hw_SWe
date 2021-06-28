public abstract class Animal {
    static int happinessLevel = 2;
    static int hungerLevel = 3;
    String food;
    String animalType;

    public void printWatchStatement(){
        System.out.println("The " + this.animalType.toLowerCase() + " is " + this.food + "...");
    }

    public void printFeedingStatement(){
        System.out.println("The " + this.animalType.toLowerCase() + " is eating " + this.food + "...");
    }


}
