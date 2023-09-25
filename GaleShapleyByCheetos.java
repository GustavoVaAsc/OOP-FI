import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


//ALL PROGRAM COMPLEXITY O(n^3)

public class GaleShapleyByCheetos {
    // Gale Shapley complexity O(n^3)
    public static void GaleShapley(HashMap<String, String[]> h, HashMap<String, String[]> s,HashMap<String, String> matches,int n){
        for (Map.Entry<String, String[]> entry : h.entrySet()){ //Iterate over the Hospital Preferences keys
            String key = entry.getKey(); 
            String[] values = entry.getValue(); // Get the list contained in the key (preferences)
            for (String value : values){ // Iterate over the preferences
                String list[] = s.get(value); // Get the list contained in the key (students preferences)
                for(int i = 0; i<n; i++){ // Iterate over the student preferences
                    //Check if the student is available (not in the match arrays)
                    if(list[i].equals(key) && !matches.containsValue(value) && !matches.containsKey(key)){
                        matches.put(list[i],value);
                        break;
                    }
                    //If the student is not available, we check all other options of the hospital
                    //until we get a student that the hospital wants and doesn't have an hospital yet
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        int n;
        System.out.println("Ingrese el numero de hospitales y estudiantes"); //Read the number of Hospital/Students
        n = scanf.nextInt();
        scanf.nextLine();

        String hospitals [] = new String[n];
        for(int i=0; i<n; i++){
            System.out.println("Ingrese el hospital numero "+(i+1)); //Read hospitals
            String temp = scanf.nextLine();
            hospitals[i] = temp;
        }

        String students [] = new String[n];
        for(int i=0; i<n; i++){
            System.out.println("Ingrese el estudiante numero "+(i+1)); //Read students
            String temp = scanf.nextLine();
            students[i] = temp;
        }


        HashMap<String, String[]> hospitalP = new HashMap<String, String[]>();

        // Read hospital preferences
        for(int i=0; i<n; i++){
            String options [] = new String[n];
            for(int j=0; j<n; j++){ 
                System.out.println("Ingrese la opcion "+(j+1) +" del hospital "+ hospitals[i]); 
                options[j] = scanf.nextLine();
            }
            hospitalP.put(hospitals[i],options);
        }

        // Read student preferences
        HashMap<String, String[]> studentsP = new HashMap<String, String[]>();
        for(int i=0; i<n; i++){
            String options [] = new String[n];
            for(int j=0; j<n; j++){
                System.out.println("Ingrese la opcion "+(j+1) +" del estudiante "+ students[i]);
                options[j] = scanf.nextLine();
            }
            studentsP.put(students[i],options);
        }

        /* --THIS IS JUST DEBUG FOR CORRECT HASHMAP ENTRIES --
        

        for (Map.Entry<String, String[]> entry : hospitalP.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();

            System.out.println("Hospitals: " + key);
            System.out.println("Options:");
            for (String value : values) {
                System.out.println("  " + value);
            }
        }

        for (Map.Entry<String, String[]> entry : studentsP.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();

            System.out.println("Students: " + key);
            System.out.println("Options:");
            for (String value : values) {
                System.out.println("  " + value);
            }
        }

        */

        //Create the matches array
        HashMap<String, String> matches = new HashMap<String, String>();

        //Run Gale Shapley algorithm
        GaleShapley(hospitalP, studentsP,matches,n);

        //Print the matches
        System.out.println(matches);

        scanf.close();
    }
}
