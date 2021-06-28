public class Unicorn extends Animal {
    String food = "rainbow cakes";
    String animalType = "Unicorn";

    public Unicorn(){
        notifyObservers("Unicorn");
    }

    @Override
    public void notifyObservers(String message) {

    }
}
