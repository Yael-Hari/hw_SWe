public class ZebraFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        /**
         * returns a zebra
         */
        return new Zebra();
    }
}
