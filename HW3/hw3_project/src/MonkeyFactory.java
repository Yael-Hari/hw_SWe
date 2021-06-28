public class MonkeyFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        /**
         * returns a monkey
         */
        return new Monkey();
    }
}
