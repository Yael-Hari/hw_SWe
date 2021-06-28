import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animalsList;
    private List<Observer> observersList;
    public static Zoo instance = null;

    private Zoo(){
        animalsList = new ArrayList<>();
        observersList = new ArrayList<>();
    }

    public Zoo getInstance(){
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    public <T extends Animal> void addAnimal(T newAnimal){
        this.animalsList.add(newAnimal);
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

    public void feedAnimals(){
        for (Animal animal : animalsList){
            animal.decreaceHunger();
        }
    }

    public void watchAnimals(){
        public void feedAnimals(){
            for (Animal animal : animalsList){
                animal.increaceHunger();
                animal.increaceHappiness();
            }
        }
    }
}