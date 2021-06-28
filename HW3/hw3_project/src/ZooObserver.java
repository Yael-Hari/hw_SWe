public class ZooObserver implements Observer {
    private String name;
    private String desc;

    public ZooObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String newUpdate){

    }

    public String getName() {
        return this.name;
    }

    public void update (String desc){
        this.desc = desc;
        display();
    }

    public void display(){
        System.out.println(desc);
    }
}
