package zoo.animals.terrestrial;
import zoo.animals.Animal;

public class Monkey extends Animal{
    public Monkey(String s, int id){
        super(s, id);
        this.setSpecies("Mono");
    }

    public void sound(){
        System.out.println(this.getName() +": Ohhh ohhh ahhh ahhh");
    }
}
