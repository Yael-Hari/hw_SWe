public class MonkeyFactory extends AnimalFactory {
    public Animal createAnimal(){
        return new Monkey();
    }
}
