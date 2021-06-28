public class ZebraFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(){
        return new Zebra();
    }
}
