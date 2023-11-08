import zoo.animals.*;
import zoo.animals.terrestrial.*;
import zoo.animals.aerial.Eagle;
import zoo.elements.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class ZooManagerByCheetos {
    public static void main (String[] args){
        Scanner scanf = new Scanner (System.in);
        Cage cages[] = new Cage[6];
        for(int i=0; i<6; i++){
            cages[i] = new Cage(i);
        }
        Queue<Monkey> mq  = new LinkedList<>();
        Queue<Lion> lq  = new LinkedList<>();
        Queue<Eagle> eq = new LinkedList<>();

        int choice;
        boolean out = true;
        int idAssigner = 0;
        System.out.println();
        System.out.println("Bienvenido al administrador del Zoologico!");
        while(out == true){
            System.out.println();
            System.out.println("Menu principal: ");
            System.out.println("1 - Registrar animal");
            System.out.println("2 - Asignar animales a las jaulas");
            System.out.println("3 - Ver el estado de las jaulas");
            System.out.println("4 - Ver estado de salud de los animales");
            System.out.println("5 - Ubicacion del animal");
            System.out.println("6 - Salir");

            choice = scanf.nextInt();
            scanf.nextLine();

            switch(choice){
                case 1:
                    System.out.println();
                    System.out.println("Elige el animal a registrar");
                    System.out.println("1 - Mono");
                    System.out.println("2 - Leon");
                    System.out.println("3 - Aguila");
                    int animalChoice;
                    animalChoice = scanf.nextInt();
                    scanf.nextLine();
                    switch(animalChoice){
                        case 1:
                            idAssigner += 1;
                            System.out.println("Ingresa el nombre del Mono");
                            String temp = scanf.nextLine();
                            Monkey m = new Monkey(temp, idAssigner);
                            mq.add(m);
                            break;
                        case 2:
                            idAssigner += 1;
                            System.out.println("Ingresa el nombre del Leon");
                            String tmp = scanf.nextLine();
                            Lion l = new Lion(tmp, idAssigner);
                            lq.add(l);
                            break;
                        default:
                            idAssigner += 1;
                            System.out.println("Ingresa el nombre del Aguila");
                            String teemp = scanf.nextLine();
                            Eagle e = new Eagle(teemp, idAssigner);
                            eq.add(e);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Los animales se asignaran automaticamente");
                    System.out.println("Si desea reasignarlos, marque si a la siguiente opcion");
                    if(!mq.isEmpty()){
                        while(!mq.isEmpty()){
                            for(int i=1; i<=5; i++){
                                if(cages[i].getLion() == false && cages[i].getAnimalNumber() < 4){
                                    cages[i].addMonkey(mq.peek().getId(), mq.peek());
                                    mq.remove();
                                    break;
                                }
                            }
                        }
                    }
                    if(!lq.isEmpty()){
                        while(!lq.isEmpty()){
                            for(int i=1; i<=5; i++){
                                if(cages[i].getMonkey() == false && cages[i].getAnimalNumber() < 4){
                                    cages[i].addLion(lq.peek().getId(), lq.peek());
                                    lq.remove();
                                    break;
                                }
                            }
                        }
                    }

                    if(!eq.isEmpty()){
                        while(!eq.isEmpty()){
                            for(int i=1; i<=5; i++){
                                if(cages[i].getAnimalNumber() < 4){
                                    cages[i].addEagle(eq.peek().getId(), eq.peek());
                                    eq.remove();
                                    break;
                                }
                            }
                        }
                    }
                    for(int i=1; i<=5; i++){
                        System.out.println("Jaula "+i);
                        cages[i].printCage();
                    }
                    System.out.println("Deseas cambiar algun animal de jaula?");
                    System.out.println("1- SI || 2- NO");
                    int cageChange;
                    int cageChoice;
                    cageChange = scanf.nextInt();
                    scanf.nextLine();
                    if(cageChange == 1){
                        do{
                            System.out.println("Elige la jaula: ");
                            cageChoice = scanf.nextInt();
                            scanf.nextLine();
                        }while(cageChoice < 1 || cageChoice > 5 || cages[cageChoice].cageEmpty());
                        System.out.println("Elige el ID del animal a mover: ");
                        System.out.println();
                        cages[cageChoice].printCage();
                        int idChoice = scanf.nextInt();
                        scanf.nextLine();
                        if(cages[cageChoice].search(idChoice) == true){
                            if(cages[cageChoice].getMonkeyNode(idChoice) != null){
                                Monkey toMove = cages[cageChoice].deleteMonkey(idChoice);
                                int cageMove;
                                do{
                                    System.out.println();
                                    System.out.println("Elige la jaula destino (Recuerda que monos y leones no conviven): ");
                                    System.out.println("Si intentas forzarlo, perderas a tu Mono/Leon (Ten cuidado)!");
                                    System.out.println("De igual forma pasara si metes al animal a una jaula llena");
                                    cageMove = scanf.nextInt();
                                    scanf.nextLine();
                                    cages[cageMove].addMonkey(toMove.getId(),toMove);
                                }while(cageMove < 1 || cageMove > 5);
                            }else if(cages[cageChoice].getLionNode(idChoice) != null){
                                Lion toMove = cages[cageChoice].deleteLion(idChoice);
                                int cageMove;
                                do{
                                    System.out.println();
                                    System.out.println("Elige la jaula destino (Recuerda que monos y leones no conviven): ");
                                    System.out.println("Si intentas forzarlo, perderas a tu Mono/Leon (Ten cuidado)!");
                                    System.out.println("De igual forma pasara si metes al animal a una jaula llena");
                                    cageMove = scanf.nextInt();
                                    scanf.nextLine();
                                    cages[cageMove].addLion(toMove.getId(),toMove);
                                }while(cageMove < 1 || cageMove > 5);
                            }else if(cages[cageChoice].getEagleNode(idChoice) != null){
                                Eagle toMove = cages[cageChoice].deleteEagle(idChoice);
                                int cageMove;
                                do{
                                    System.out.println();
                                    System.out.println("Elige la jaula destino ");
                                    System.out.println("Si mueves al aguila a una jaula llena, la perderas (Ten cuidado)!");
                                    cageMove = scanf.nextInt();
                                    scanf.nextLine();
                                    cages[cageMove].addEagle(toMove.getId(),toMove);
                                }while(cageMove < 1 || cageMove > 5);
                            }
                        }else{
                            System.out.println();
                            System.out.println("El id no se encuentra en la jaula");
                        }

                    }

                    System.out.println();
                    System.out.println("Deseas cambiar algun animal de jaula?");
                    System.out.println("1- SI || 2- NO");

                    break;
                case 3:
                    for(int i=1; i<=5; i++){
                        System.out.println("Jaula "+i);
                        cages[i].getState();
                    }
                    break;
                case 4:
                    for(int i=1; i<=5; i++){
                        System.out.println();
                        System.out.println("Jaula "+i);
                        cages[i].printCage();
                    }
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Escribe el ID del animal a buscar");
                    int idSearch = scanf.nextInt();
                    scanf.nextLine();
                    for(int i=1; i<=5; i++){
                        cages[i].search(idSearch);
                    }
                    break;
                default:
                    System.out.println("Adios! :D");
                    out = false;
                    break;
            }
        }
        scanf.close();
    }
}
