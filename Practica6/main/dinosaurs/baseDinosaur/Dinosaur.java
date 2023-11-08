package main.dinosaurs.baseDinosaur;

public class Dinosaur {
    private String name;
    private boolean type; // 0 for carnivore, 1 for herbivore
    private int habitat; // 1-warm, 2-cold, 3-mild
    private int energy = 100;
    private int species; // 1-flying, 2-aquatic, 3-ground, 4-engineer, 5-graduate

    public void setName(String name){this.name = name;}
    public void setType(boolean type){this.type = type;}
    public void setHabitat(int habitat){this.habitat = habitat;}
    public void setSpecies(int species){this.species = species;}

    public String getName(){return this.name;}

    public void face(Dinosaur d){ // Afrontar
        if(this.type == d.type){
            System.out.println("Los dinosaurios son del mismo tipo, no pueden pelear!");
            return;
        }

        double probability = Math.random();
        if(probability <= 0.6){
            this.fight(d);
        }else{
            System.out.println("Andan pacifistas los dinocompas :D!");
            return;
        }

    }

    public void eat(){
        if(this.energy == 100){
            System.out.println("El dinosaurio "+ this.name +" no esta hambreado ahora, espere a la reinscripcion en la FI");
            System.out.println("Energia - 100");
            return;
        }

        this.energy = 100;
        System.out.println(this.name+": Yomi yomi, comida rica RAAAAWWRRRR");
        System.out.println("Energia - 100");
    }

    public void fight(Dinosaur d){
        int round = 1;
        double attack;
        while(round <= 5){
            if(this.type == false){ //This is carnivore, if both are carnivore, the preference is
                                    //for this (who started the fight)
                attack = Math.random();
                //This turn
                if(attack <= 0.5){
                    System.out.println(this.name+ " hace un ataque debil!");
                    System.out.println(d.name+ " pierde 5 puntos de energia");
                    d.energy -= 5;
                }else{
                    System.out.println(this.name+ " hace un ataque fuerte!");
                    System.out.println(d.name+ " pierde 15 puntos de energia");
                    d.energy -= 15;
                }
                if(d.energy <= 0){
                    System.out.println(d.name+" se ha debilitado!");
                    System.out.println(this.name+" ha ganado la pelea!");
                    System.out.println("Regresando al menu...");
                }
                //D turn
                attack = Math.random();
                if(attack <= 0.5){
                    System.out.println(d.name+ " hace un ataque debil!");
                    System.out.println(this.name+ " pierde 5 puntos de energia");
                    this.energy -= 5;
                }else{
                    System.out.println(d.name+ " hace un ataque fuerte!");
                    System.out.println(this.name+ " pierde 15 puntos de energia");
                    this.energy -= 15;
                }
                if(this.energy <= 0){
                    System.out.println(this.name+" se ha debilitado!");
                    System.out.println(d.name+" ha ganado la pelea!");
                    System.out.println("Regresando al menu...");
                }
                round += 1;
            }else{ // This is herbivore

                // D turn
                attack = Math.random();
                if(attack <= 0.5){
                    System.out.println(d.name+ " hace un ataque debil!");
                    System.out.println(this.name+ " pierde 5 puntos de energia");
                    this.energy -= 5;
                }else{
                    System.out.println(d.name+ " hace un ataque fuerte!");
                    System.out.println(this.name+ " pierde 15 puntos de energia");
                    this.energy -= 15;
                }

                if(this.energy <= 0){
                    System.out.println(this.name+" se ha debilitado!");
                    System.out.println(d.name+" ha ganado la pelea!");
                    System.out.println("Regresando al menu...");
                }

                attack = Math.random();
                //This turn
                if(attack <= 0.5){
                    System.out.println(this.name+ " hace un ataque debil!");
                    System.out.println(d.name+ " pierde 5 puntos de energia");
                    d.energy -= 5;
                }else{
                    System.out.println(this.name+ " hace un ataque fuerte!");
                    System.out.println(d.name+ " pierde 15 puntos de energia");
                    d.energy -= 15;
                }

                if(d.energy <= 0){
                    System.out.println(d.name+" se ha debilitado!");
                    System.out.println(this.name+" ha ganado la pelea!");
                    System.out.println("Regresando al menu...");
                }
                round += 1;
            }
        }
    }

    public void changeWeather(){
        int max = 30;
        int min = -10;
        int range = max - min + 1;
        int weather =(int)(Math.random() * range) + min;

        String w;

        if(weather <= 0){
            w = "Frio";
        }else if(weather >= 1 && weather <=15){
            w = "Templado";
        }else{
            w = "Caluroso";
        }

        if(this.energy <= 0){
            System.out.println("Dale de comer a tu dinosaurio, no lo maltrates >:c");
            return;
        }

        System.out.println("Clima - "+w);

        if(this.habitat == 2){
            if(weather >= -10 && weather <= 0){
                System.out.println(this.name+": Este clima me gusta mucho, que agusticidad");
            }else{
                System.out.println(this.name+": Este clima esta bien ZzZZZzz, SACAME DE AQUI! >:C");
                System.out.println("-30 de energia");
                this.energy -= 30;
                if(this.energy <= 0){
                    System.out.println(this.name+": X_x");
                    System.out.println("Energia - 0");
                }else{
                    System.out.println("Energia - "+this.energy);
                }
            }
        }else if(this.habitat == 3){
            if(weather >= 1 && weather <= 15){
                System.out.println(this.name+": Este clima me gusta mucho, que agusticidad");
            }else{
                System.out.println(this.name+": Este clima esta bien ZzZZZzz, SACAME DE AQUI! >:C");
                System.out.println("-30 de energia");
                this.energy -= 30;
                if(this.energy <= 0){
                    System.out.println(this.name+": X_x");
                    System.out.println("Energia - 0");
                }else{
                    System.out.println("Energia - "+this.energy);
                }
            }
        }else if(this.habitat == 1){
            if(weather >= 16 && weather <= 30){
                System.out.println(this.name+": Este clima me gusta mucho, que agusticidad");
            }else{
                System.out.println(this.name+": Este clima esta bien ZzZZZzz, SACAME DE AQUI! >:C");
                System.out.println("-30 de energia");
                this.energy -= 30;
                if(this.energy <= 0){
                    System.out.println(this.name+": X_x");
                    System.out.println("Energia - 0");
                }else{
                    System.out.println("Energia - "+this.energy);
                }
            }
        }
    }
}
