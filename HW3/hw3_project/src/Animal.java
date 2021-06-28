public abstract class Animal {
    int happinessLevel = 2;
    int hungerLevel = 3;
    String food;
    String animalType;

    public void increaceHappiness(){
        happinessLevel++;
    }

    public void decreaceHappiness(){
        happinessLevel--;
    }

    public void increaceHunger(){
        hungerLevel++;
        System.out.println("the " + this.animalType + " is eating " + this.food + "...");
    }

    public void decreaceHunger(){
        hungerLevel--;
    }


}
