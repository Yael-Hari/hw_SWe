public class UnicornFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        return new Unicorn();
    }
}
