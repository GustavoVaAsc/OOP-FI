package zoo.animals.aerial;
import zoo.animals.Animal;

public class Eagle extends Animal{
    public Eagle(String s, int id){
        super(s, id);
        this.setSpecies("Aguila");
    }

    public void sound(){
        System.out.println(this.getName() +": Eaaaaah eaaaaaah!");
    }
}
