public class ZooObserver implements Observer {
    private String name;

    public ZooObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String newUpdate){

    }

    public String getName() {
        return this.name;
    }
}
