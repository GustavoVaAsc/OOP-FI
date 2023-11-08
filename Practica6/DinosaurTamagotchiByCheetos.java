import java.util.Scanner;
import java.lang.Math;
import main.dinosaurs.baseDinosaur.Dinosaur;

public class DinosaurTamagotchiByCheetos{
    public static void main(String[] args){
        Scanner consomelog = new Scanner(System.in);
        int dinosaurCount = 0;
        Dinosaur D1 = new Dinosaur();
        Dinosaur D2 = new Dinosaur();
        boolean out = true;
        int choice = 0;
        System.out.println("Bienvenido al Tamagotchi de los Dinosaurios! :D");
        while(out == true){
            System.out.println("Menu principal: ");
            System.out.println("1 - Crear dinosaurio");
            System.out.println("2 - Comer");
            System.out.println("3 - Cambiar Clima");
            System.out.println("4 - Afrontar");
            System.out.println("5 - Pelear");
            System.out.println("6 - Salir");

            choice = consomelog.nextInt();
            consomelog.nextLine();

            switch(choice){
                case 1:
                    if(dinosaurCount == 0){
                        String name;
                        int tch;
                        boolean type;
                        int habitat;
                        int species;
                        System.out.println("Ingresa el nombre de tu dinosaurio:");
                        name = consomelog.nextLine();
                        D1.setName(name);
                        System.out.println("Ingresa el tipo del dinosaurio");
                        System.out.println("0 - Carnivoro");
                        System.out.println("Cualquier otra cosa - Herbivoro");
                        tch = consomelog.nextInt();
                        consomelog.nextLine();

                        if(tch == 0){
                            type = false;
                        }else{
                            type = true;
                        }
                        D1.setType(type);
                        System.out.println("Ingresa el habitat del dinosaurio");
                        System.out.println("1 - Caluroso");
                        System.out.println("2 - Frio");
                        System.out.println("3 - Templado");
                        habitat = consomelog.nextInt();
                        consomelog.nextLine();

                        if(habitat <= 0 && habitat > 3){
                            habitat = 3;
                        }
                        D1.setHabitat(habitat);
                        System.out.println("Ingresa la especie del dinosaurio");
                        System.out.println("1 - Volador");
                        System.out.println("2 - Acuatico");
                        System.out.println("3 - Terrestre");
                        species = consomelog.nextInt();
                        consomelog.nextLine();

                        if(species <= 0 && species > 3){
                            species = 3;
                        }
                        D1.setSpecies(species);
                        dinosaurCount +=1;
                    }else if(dinosaurCount == 1){
                        String name;
                        int tch;
                        boolean type;
                        int habitat;
                        int species;
                        System.out.println("Ingresa el nombre de tu dinosaurio:");
                        name = consomelog.nextLine();

                        D2.setName(name);
                        System.out.println("Ingresa el tipo del dinosaurio");
                        System.out.println("0 - Carnivoro");
                        System.out.println("Cualquier otra cosa - Herbivoro");
                        tch = consomelog.nextInt();
                        consomelog.nextLine();

                        if(tch == 0){
                            type = false;
                        }else{
                            type = true;
                        }

                        D2.setType(type);

                        System.out.println("Ingresa el habitat del dinosaurio");
                        System.out.println("1 - Caluroso");
                        System.out.println("2 - Frio");
                        System.out.println("3 - Templado");
                        habitat = consomelog.nextInt();
                        consomelog.nextLine();

                        if(habitat <= 0 && habitat > 3){
                            habitat = 3;
                        }

                        D2.setHabitat(habitat);

                        System.out.println("Ingresa la especie del dinosaurio");
                        System.out.println("1 - Volador");
                        System.out.println("2 - Acuatico");
                        System.out.println("3 - Terrestre");
                        species = consomelog.nextInt();
                        consomelog.nextLine();

                        if(species <= 0 && species > 3){
                            species = 3;
                        }

                        D2.setSpecies(species);
                        
                        dinosaurCount +=1;
                    }else{
                        System.out.println("Limite de dinosaurios excedido");
                    }
                    break;
                case 2:
                    int eatChoice;
                    if(dinosaurCount == 0){
                        System.out.println("No hay dinosaurios disponibles");
                        break;
                    }
                    System.out.println("Que dinosaurio quieres que coma");
                    System.out.println("1 o 2");
                    eatChoice = consomelog.nextInt();
                    consomelog.nextLine();

                    if(eatChoice>=2 && dinosaurCount == 1){
                        System.out.println("El dinosaurio 2 no existe");
                        break;
                    }

                    if(eatChoice == 1){
                        D1.eat();
                    }else{
                        D2.eat();
                    }
                    break;
                case 3:
                    if(dinosaurCount == 0){
                        System.out.println("No hay dinosaurios disponibles");
                        break;
                    }
                    if(dinosaurCount == 1){
                        D1.changeWeather();
                        break;
                    }

                    D1.changeWeather();
                    D2.changeWeather();
                    break;
                case 4:
                    if(dinosaurCount < 2){
                        System.out.println("No hay dinosaurios para pelear");
                        break;
                    }
                    D1.face(D2);
                    break;
                case 5:
                    D1.fight(D2);
                    break;
                default:
                    System.out.println("Adios! :D");
                    out = false;
                    break;
            }
            

        }
        consomelog.close();
    }
}