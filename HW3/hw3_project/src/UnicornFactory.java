public class UnicornFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        /**
         * returns a unicorn
         */
        return new Unicorn();
    }
}
