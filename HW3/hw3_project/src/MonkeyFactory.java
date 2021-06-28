public class MonkeyFactory extends AnimalFactory {
    public AnimalFactory createAnimal(){
        return new Monkey();
    }
}
