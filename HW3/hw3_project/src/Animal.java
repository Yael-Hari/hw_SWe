public abstract class Animal implements Subject{
    int happinessLevel = 2;
    int hungerLevel = 3;
    String food;
    String animalType;

    public void increaceHappiness(){
        happinessLevel++;
        System.out.println("The " + this.animalType.toLowerCase() + " is " + this.food + "...");
    }

    public void decreaceHappiness(){
        happinessLevel--;
    }

    public void increaceHunger(){
        hungerLevel++;
        System.out.println("The " + this.animalType.toLowerCase() + " is eating " + this.food + "...");
    }

    public void decreaceHunger(){
        hungerLevel--;
    }

    @Override
    public void notifyObservers(String message){
    }

}
