public class UnicornFactory extends AnimalFactory {
    public Animal createAnimal(){
        return new Unicorn();
    }
}
