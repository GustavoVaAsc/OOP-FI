package zoo.animals;

public abstract class Animal {
    private int health;
    private String name;
    private int id;
    private String healthState;
    private String species;

    public String getName(){return this.name;}
    public int getId(){return this.id;}
    public int getHealth(){return this.health;}
    public String getHealthState(){return this.healthState;}
    public String getSpecies(){return this.species;}

    public void setSpecies(String species){this.species = species;}

    public Animal(String n, int id){
        this.name = n;
        this.id = id;
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        int x =(int)(Math.random() * range) + min;
        this.health = x;
        if(this.health > 50){
            this.healthState = "Sano";
        }else{
            this.healthState = "Enfermo";
        }
    }

    public abstract void sound();
}
