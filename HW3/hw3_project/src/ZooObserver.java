public class ZooObserver implements Observer {
    private String name;
    private String desc;

    public ZooObserver(String name){
        this.name = name;
    }


    @Override
    public void update (String desc){
        /**
         * updates the observation of the observer
         */
        this.desc = desc;
        display();
    }

    public void display(){
        /**
         * prints the observation
         */
        System.out.println("[" +this.name + "] " + desc);
    }
}
