public abstract class Animal {
    int happinessLevel = 2;
    int hungerLevel = 3;

    public void increaceHappiness(){
        happinessLevel++;
    }

    public void decreaceHappiness(){
        happinessLevel--;
    }

    public void increaceHunger(){
        hungerLevel++;
        System.out.println(this.food);
    }

    public void decreaceHunger(){
        hungerLevel--;
    }


}
