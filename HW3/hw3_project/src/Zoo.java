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
        //todo printing code
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
            animal.decreaceHunger();
        }
        notifyObservers("The animals are being fed");
    }

    public void watchAnimals(){
        for (Animal animal : animalsList){
            animal.increaceHunger();
            animal.increaceHappiness();
        }
        notifyObservers("The animals are being watched");
    }
}