package zoo.animals.terrestrial;
import zoo.animals.Animal;

public class Lion extends Animal{
    public Lion(String s, int id){
        super(s, id);
        this.setSpecies("Leon");
    }

    public void sound(){
        System.out.println(this.getName() +": RAAAAAAAWWWWWWWWRRRRRR");
    }
}
