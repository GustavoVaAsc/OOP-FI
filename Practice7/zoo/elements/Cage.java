package zoo.elements;
import zoo.animals.aerial.Eagle;
import zoo.animals.terrestrial.*;
import java.util.HashMap;

public class Cage {
    private int cageNumber;
    private int capacity = 4;
    private int animalNumber;
    private HashMap<Integer, Monkey> monkeys = new HashMap<Integer, Monkey>();
    private HashMap<Integer, Eagle> eagles = new HashMap<Integer, Eagle>();
    private HashMap<Integer, Lion> lions = new HashMap<Integer, Lion>();
    private boolean hasMonkey = false;
    private boolean hasLion = false;

    public Cage(int num){
        this.cageNumber = num;
    }

    public int getNumber(){return this.cageNumber;}
    public int getAnimalNumber(){return this.animalNumber;}
    public boolean getMonkey(){return this.hasMonkey;}
    public boolean getLion(){return this.hasLion;}
    public Monkey getMonkeyNode(int id){return this.monkeys.get(id);}
    public Lion getLionNode(int id){return this.lions.get(id);}
    public Eagle getEagleNode(int id){return this.eagles.get(id);}


    public boolean cageEmpty(){
        if(this.monkeys.isEmpty() && this.lions.isEmpty() && this.eagles.isEmpty()){
            return true;
        }
        return false;
    }

    public void addMonkey(int id,Monkey m){
        if(this.hasLion == true){
            System.out.println("La jaula tiene leones, no puedes meter a un mono con ellos!");
            return;
        }

        if(this.animalNumber < this.capacity){
            this.monkeys.put(id, m);
            this.animalNumber +=1;
            this.hasMonkey = true;
        }else{
            System.out.println("Jaula llena!");
        }
    }

    public void addLion(int id,Lion l){
        if(this.hasMonkey == true){
            System.out.println("La jaula tiene monos, no puedes meter a un leon con ellos!");
            return;
        }

        if(this.animalNumber < this.capacity){
            this.lions.put(id, l);
            this.animalNumber +=1;
            this.hasLion = true;
        }else{
            System.out.println("Jaula llena!");
        }
    }

    public void addEagle(int id,Eagle e){
        if(this.animalNumber < this.capacity){
            this.eagles.put(id, e);
            this.animalNumber +=1;
        }else{
            System.out.println("Jaula llena!");
        }
    }

    public Monkey deleteMonkey(int id){
        if (this.monkeys.isEmpty())
            return null;
        Monkey m = this.monkeys.get(id);
        this.monkeys.remove(id);
        animalNumber -= 1;
        return m;
    }

    public Lion deleteLion(int id){
        if (this.lions.isEmpty())
            return null;
        Lion l = this.lions.get(id);
        this.lions.remove(id);
        animalNumber -= 1;
        return l;
    }

    public Eagle deleteEagle(int id){
        if (this.eagles.isEmpty())
            return null;
        Eagle e = this.eagles.get(id);
        this.eagles.remove(id);
        animalNumber -= 1;
        return e;
    }

    public boolean search(int id){
        if(this.monkeys.isEmpty() && this.lions.isEmpty() && this.eagles.isEmpty()){
            System.out.println("No hay animales en la Jaula");
            return false;
        }

        if(this.monkeys.containsKey(id)){
            System.out.println(this.monkeys.get(id).getId() +" - "+ this.monkeys.get(id).getSpecies()+ " - "
                                + this.monkeys.get(id).getName() + " - Jaula:" + this.cageNumber + " - Estado: "
                                + this.monkeys.get(id).getHealthState());
            System.out.println();
            this.monkeys.get(id).sound();
        }else if(this.lions.containsKey(id)){
            System.out.println(this.lions.get(id).getId() +" - "+ this.lions.get(id).getSpecies()+ " - "
                                + this.lions.get(id).getName() + " - Jaula:" + this.cageNumber + " - Estado: "
                                + this.lions.get(id).getHealthState());
            System.out.println();
            this.lions.get(id).sound();
        }else if(this.eagles.containsKey(id)){
            System.out.println(this.eagles.get(id).getId() +" - "+ this.eagles.get(id).getSpecies()+ " - "
                                + this.eagles.get(id).getName() + " - Jaula:" + this.cageNumber + " - Estado: "
                                + this.eagles.get(id).getHealthState());
            System.out.println();
            this.eagles.get(id).sound();
        }else{
            return false;
        }

        return true;
    }

    public void getState(){
        if(this.monkeys.isEmpty() && this.lions.isEmpty() && this.eagles.isEmpty()){
            System.out.println("No hay animales en la Jaula");
            return;
        }
        System.out.println("Numero de jaula: "+this.cageNumber);
        boolean flag = true;
        for (Integer id : this.monkeys.keySet()) {
            Monkey m = this.monkeys.get(id);
            if(m.getHealthState() != "Sano"){
                System.out.println(m.getId() +" - Especie: "+ m.getSpecies()+ " - Estado: "+ m.getHealthState());
                flag = false;
            }
        }

        for (Integer id : this.lions.keySet()) {
            Lion l = this.lions.get(id);
            if(l.getHealthState() != "Sano"){
                System.out.println(l.getId() +" - Especie: "+ l.getSpecies()+ " - Estado: "+ l.getHealthState());
                flag = false;
            }
        }

        for (Integer id : this.eagles.keySet()) {
            Eagle e = this.eagles.get(id);
            if(e.getHealthState() != "Sano"){
                System.out.println(e.getId() +" - Especie: "+ e.getSpecies()+ " - Estado: "+ e.getHealthState());
                flag = false;
            }
        }

        if(flag == true){
            System.out.println("No hay animales enfermos en esta jaula");
        }

        int s = 0;
        if(!this.monkeys.isEmpty()){
            s++;
            if(!this.eagles.isEmpty()){
                s++;
            }
        }

        if(!this.lions.isEmpty()){
            s++;
            if(!this.eagles.isEmpty()){
                s++;
            }
        }

        System.out.println("Especies diferentes: "+ s);
        
    }

    public void printCage(){
        if(this.monkeys.isEmpty() && this.lions.isEmpty() && this.eagles.isEmpty()){
            System.out.println("No hay animales en la Jaula");
            return;
        }

        System.out.println("Numero de jaula: "+this.cageNumber);
        for (Integer id : this.monkeys.keySet()) {
            Monkey m = this.monkeys.get(id);
            System.out.println(m.getId() +" - Especie: "+ m.getSpecies()+ " - Estado: "+ m.getHealthState());
        }

        for (Integer id : this.lions.keySet()) {
            Lion l = this.lions.get(id);
            System.out.println(l.getId() +" - Especie: "+ l.getSpecies()+ " - Estado: "+ l.getHealthState());
        }

        for (Integer id : this.eagles.keySet()) {
            Eagle e = this.eagles.get(id);
            System.out.println(e.getId() +" - Especie: "+ e.getSpecies()+ " - Estado: "+ e.getHealthState());
        }
        
    }
}
