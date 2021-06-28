import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Zoo implements Subject{
    private List<Animal> animalsList = new ArrayList<Animal>();
    private List<Observer> observersList = new ArrayList<Observer>();
    public static Zoo instance = null;

    public static Zoo getInstance(){
        if (instance == null) {
            System.out.println("Creating zoo...");
            instance = new Zoo();
        } else {
            System.out.println("The zoo already exists...");
        }
        return instance;
    }

    public <T extends Animal> void addAnimal(T newAnimal){
        this.animalsList.add(newAnimal);
        notifyObservers(newAnimal.animalType + " has been added to the zoo!");
    }

    public void showAnimalsInfo(){
        System.out.println("The zoo contains total of " + animalsList.size()+ " animals:");
        int zebraCount =0;
        int monkeyCount =0;
        int unicornCount =0;
        for (Animal animal : animalsList){
            if(animal.animalType.equals("Monkey"))
                monkeyCount++;
            if(animal.animalType.equals("Zebra"))
                zebraCount++;
            if(animal.animalType.equals("Unicorn"))
                unicornCount++;
        }
        System.out.println("- Zebra: " + zebraCount);
        System.out.println("- Unicorn: " + unicornCount);
        System.out.println("- Monkey: " + monkeyCount);
        System.out.println("Happiness level: " + Animal.happinessLevel);
        if (Animal.happinessLevel < 3)
            System.out.println("The animals are not happy, you should watch them...");
        if (Animal.happinessLevel > 3)
            System.out.println("The animals are very happy, keep working hard...");
        System.out.println("Hunger level: " + Animal.hungerLevel);
        if (Animal.hungerLevel > 3)
            System.out.println("The animals are hungry, you should feed them...");

    }

    public void addObserver(Observer observer){
        this.observersList.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observersList.remove(observer);
    }

    @Override
    public void notifyObservers(String message){
        System.out.println("Notifying observers:");
        for (Observer observer: observersList){
            observer.update(message);
        }
    }

    public void feedAnimals(){
        for (Animal animal : animalsList){
            animal.printFeedingStatement();
        }
        Animal.decrementHungerLevel();

        notifyObservers("The animals are being fed");
    }

    public void watchAnimals(){
        for (Animal animal : animalsList){
            animal.printWatchStatement();
        }
        Animal.incrementHappinessLevel();
        Animal.incrementHungerLevel();
        notifyObservers("The animals are being watched");
    }




}