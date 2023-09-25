import java.util.Scanner;

public class BaseConverterByCheetos{
    // All program complexity O(n + log base b (n))
    public static void main(String[] args){
        // MENU OF THE PROGRAM

        Scanner scanner = new Scanner(System.in);
        int number = 0, targetBase = 0, sourceBase = 0, op;

        System.out.println("-------- CONVERSOR DE BASES --------");
        System.out.println("(1) Binario a Octal");
        System.out.println("(2) Binario a Decimal");
        System.out.println("(3) Binario a Hexadecimal");
        System.out.println("(4) Octal a Binario");
        System.out.println("(5) Octal a Decimal");
        System.out.println("(6) Octal a Hexadecimal");
        System.out.println("(7) Decimal a Binario");
        System.out.println("(8) Decimal a Octal");
        System.out.println("(9) Decimal a Hexadecimal");
        System.out.println("(10) Hexadecimal a Binario");
        System.out.println("(11) Hexadecimal a Octal");
        System.out.println("(12) Hexadecimal a Decimal");
        System.out.print("Ingresa la opcion a realizar: ");
        op = scanner.nextInt();

        
        switch(op){

            case 1:
                sourceBase = 2;
                targetBase = 8;
                break;

            case 2:
                sourceBase = 2;
                targetBase = 10;
                break;

            case 3:
                sourceBase = 2;
                targetBase = 16;
                break;

            case 4:
                sourceBase = 8;
                targetBase = 2;
                break;

            case 5:
                sourceBase = 8;
                targetBase = 10;
                break;

            case 6:
                sourceBase = 8;
                targetBase = 16;
                break;

            case 7:
                sourceBase = 10;
                targetBase = 2;
                break;

            case 8:
                sourceBase = 10;
                targetBase = 8;
                break;

            case 9:
                sourceBase = 10;
                targetBase = 16;
                break;

            case 10:
                sourceBase = 16;
                targetBase = 2;
                break;

            case 11:
                sourceBase = 16;
                targetBase = 8;
                break;

            case 12:
                sourceBase = 16;
                targetBase = 10;
                break;

            default:
                System.out.println("Opcion no valida");
                break;

        }

        if(sourceBase == 16){ //Case of an Hexadecimal number (We have letters)
            System.out.println("Ingresa el numero a convertir: ");
            scanner.nextLine();
            String hex = scanner.nextLine();
            if( ValHexa(hex) != false){ //We validate if is an hexadecimal number
                int Dec = hexToDecimal(hex);
                String result = convertBase(Dec, 10, targetBase);
                System.out.println("Numero convertido!: " + result);   
            } else {
                System.out.println("El numero ingresado no es hexadecimal");
            }
        }else{ //Any other base, general base converter method
            System.out.print("Ingresa el numero a convertir: ");
            number = scanner.nextInt();
            String result = convertBase(number, sourceBase, targetBase);
            System.out.println("Numero convertido!: " + result);
        }

        scanner.close();

    }

    public static String convertBase(int number, int sourceBase, int targetBase){


        String validate = Integer.toString(number);
        String binChars = "01";
        String octChars = "01234567";
        if(sourceBase == 2){ // Validating if the number is in base 2
            for(int i = 0; i < validate.length(); i++){ // O(n);  n = validate.length()
                char tmp = validate.charAt(i); // O(1), because we always check a string of the same length
                if(binChars.indexOf(tmp) == -1){
                    System.out.println("Numero no permitido en base 2");
                    System.exit(0);
                }
            }
        }

        if(sourceBase == 8){ // Validating if the number is in base 8
            for(int i = 0; i < validate.length(); i++){// O(n);  n = validate.length()
                char tmp2 = validate.charAt(i); // O(1), because we always check a string of the same length
                if(octChars.indexOf(tmp2) == -1){
                    System.out.println("Numero no permitido en base 8");
                    System.exit(0);
                }
            }
        }
        

        int decimalValue = convertToDecimal(number, sourceBase); // Convert the number to decimal

        return convertFromDecimal(decimalValue, targetBase); // Convert to the destination base
    }

    public static int convertToDecimal(int number, int base){ // Complexity: O(log base(b) n)
        int decimalValue = 0;
        int power = 0;

        while (number > 0){
            int digit = number % 10; // Get the modulo of base 10
            decimalValue += digit * Math.pow(base, power); // We make a sum of the number digits
                                                           // using the property of the base powers sum
                                                           // starting at b^0
            power++; // Increase the power for the next digit
            number /= 10; // Divide the number by 10 
        }

        return decimalValue; // Return the number on base 10
    }

    public static String convertFromDecimal(int decimalValue, int base){ // Complexity: O(log base(b) n)
        StringBuilder result = new StringBuilder(); //Create a string builder
                                                    // (Mutable version of String) and with
                                                    // better string manipulation methods

        // StringBuilder.insert() method complexity O(1) 

        while (decimalValue > 0){
            int remainder = decimalValue % base; // Get the remainder of with the base we need
            //Establish the values to insert for hexadecimal values
            if(remainder == 10){
                result.insert(0, "A");
            }else if(remainder == 11){
                result.insert(0, "B");
            }else if(remainder == 12){
                result.insert(0, "C");
            }else if(remainder == 13){
                result.insert(0, "D");
            }else if(remainder == 14){
                result.insert(0, "E");
            }else if(remainder == 15){
                result.insert(0, "F");
            }else{
                result.insert(0, remainder); // Insert the remainder in case of being a normal
                                                    // number
            }
            decimalValue /= base; // Divide the decimal value with the base
            
        }

        return result.toString(); //Return the result converted to a normal string object
    }

    public static int hexToDecimal(String hex){
        int decimal = 0;
        String digits = "0123456789ABCDEF"; // Hexadecimal digits
        hex = hex.toUpperCase(); // Convert to upper case 

        for (int i = 0; i < hex.length(); i++){ // Loop for converting each digit O(n); n=hex.length()
            char c = hex.charAt(i); // We get the character and assign it to a temporal char
            int digitValue = digits.indexOf(c); // Assignment the char to the respective digit 
            decimal = decimal * 16 + digitValue; // Sum of the digit values
        }

        return decimal; // Decimal number return
    }

    public static boolean ValHexa(String hex){ // Metodo que verifica si el número ingresado es hexadecimal
        String hexChars = "0123456789ABCDEF";
        hex = hex.toUpperCase(); // Convertimos a mayusculas si el usuario ingresó el número con minusculas

        for (int i = 0; i < hex.length(); i++){ // Ciclo para validar cada digito
            char tmp = hex.charAt(i); // Obtenemos el caracter en la posición que queremos validar
            if (hexChars.indexOf(tmp) == -1){ // Busca si el caracter se encuentra dentro de nuestra cadena definda de valores 
                return false; // No encontró el valor por tanto no es un caracter valido de hexadecimal
            }
        }

        return !hex.isEmpty(); // Asegurarse de que el usuario haya ingresado algo
    }
}

