import java.lang.Math;
import java.util.Scanner;
import Calculators.DecCalc.CalculadoraDecimal;
import Calculators.BinCalc.CalculadoraBinaria;

public class CalculatorByCheetos {

    public static void main(String[] args) {
        CalculadoraDecimal calculatorA = new CalculadoraDecimal();
        CalculadoraBinaria calculatorB = new CalculadoraBinaria();

        int modo;
        calculatorA.setMem(0);
        calculatorB.setMem(0);
        boolean ejecutar = true;
        Scanner scanner = new Scanner(System.in);

        do {
            boolean ejecutarI = true;
            System.out.println("Bienvenidx a 'Calculadora Cheetos'");
            System.out.println("[1] Usar la calculadora en el modo decimal'");
            System.out.println("[2] Usar la calculador en el modo binario");
            System.out.println("[3] Apagar la calculadora");
            System.out.print("Ingresa la opcion a realizar :D porfavor: ");
            modo = scanner.nextInt();
            System.out.println();

            switch (modo) {
                
                case 1: // ---------------------------------------------------------------------------- MODO DECIMAL
                    
                    do {
                        System.out.println();
                        System.out.println("********************* CALCULADORA MODO DECIMAL :D *********************");
                        System.out.println("[1] PUNTO MEDIO DE UNA RECTA");
                        System.out.println("[2] FACTORIAL");
                        System.out.println("[3] FORMULA GENERAL DE SEGUNDO GRADO");
                        System.out.println("[4] CALCULAR LA MATRIZ TRANSPUESTA");
                        System.out.println("[5] MENU PRINCIPAL");
                        System.out.println("[6] MOSTRAR MEM");
                        System.out.println("[7] OPERACION ALEATORIA");
                        System.out.print("Ingresa la opcion a realizar :D porfavor: ");
                        int op = scanner.nextInt();
                        System.out.println();

                        switch (op) { // SWITCH DEL MODO DECIMAL

                            case 1:

                                System.out.println("Seleccionaste: Punto medio de una recta");
                                System.out.println();

                                System.out.println("Ingresa las coordenadas del primer punto: ");
                                double x1 = scanner.nextDouble();
                                double y1 = scanner.nextDouble();
                                System.out.println();

                                System.out.println("Ingresa las coordenadas del segundo punto: ");
                                double x2 = scanner.nextDouble();
                                double y2 = scanner.nextDouble();
                                System.out.println();

                                calculatorA.PuntoMedio(x1, y1, x2, y2);



                                break;

                            case 2:

                                System.out.println("Seleccionaste: Factorial");
                                System.out.println();
                                System.out.print("Ingresa el valor a calcular, o 'MEM' si deseas usar el valor almacenado previamente: ");
                                String input = scanner.next();
                                long res;

                                if (input.equalsIgnoreCase("MEM")) {
                                    if (calculatorA.getMem() > 70){
                                        System.out.println("Math ERROR");
                                        break;
                                    } else {
                                        res = calculatorA.Factorial(calculatorA.getMem());
                                        System.out.println("Factorial de " + calculatorA.getMem() + " = " + res);
                                    }
                                } else {
                                    int n = Integer.parseInt(input);
                                    if (n >= 0 && n < 50) {
                                        res = calculatorA.Factorial(n);
                                        System.out.println("Factorial de " + n + " = " + res);
                                    } else {
                                        System.out.println("Math ERROR");
                                        break;
                                    }
                                }

                                System.out.println("Deseas almacenar el resultado en la memoria? 1)SI 2)NO");
                                int save = scanner.nextInt();

                                if(save == 1){
                                    if(calculatorA.getMem() != 0){
                                        System.out.println("La memoria tiene un valor, deseas sobreescribir? 1)SI 2)NO");
                                        int sobreescribir = scanner.nextInt();
                                        if(sobreescribir == 1){
                                            calculatorA.setMem(res);
                                        } 
                                    } else {
                                        calculatorA.setMem(res);
                                    }
                                }

                                break;

                            case 3:

                                System.out.println("Seleccionaste: Formula general de segundo grado");
                                System.out.println();

                                System.out.print("Ingresa el valor de a: ");
                                double a = scanner.nextDouble();
                                System.out.print("Ingresa el valor de b: ");
                                double b = scanner.nextDouble();
                                System.out.print("Ingresa el valor de c: ");
                                double c = scanner.nextDouble();
                                
                                System.out.println();

                                calculatorA.Chicharronera(a, b, c);

                                break;

                            case 4:

                                System.out.println("Seleccionaste: Matriz transpuesta");
                                System.out.println();
                                int n;

                                do {
                                    System.out.print("Ingresa el orden de la matriz a calcular: ");
                                    n = scanner.nextInt();
                                } while (n < 2);

                                int[][] matrizO = calculatorA.Create(n);
                                System.out.println();
                                System.out.println("Matriz Original:");
                                System.out.println();
                                calculatorA.PrintM(matrizO);

                                int[][] matrizT = calculatorA.Transpuesta(matrizO);
                                System.out.println();
                                System.out.println("Matriz Transpuesta:");
                                System.out.println();
                                calculatorA.PrintM(matrizT);
                                break;

                            case 5:

                                ejecutarI = false;
                                System.out.println();
                                break;
                            
                            case 6:

                                System.out.println(calculatorA.getMem());
                                System.out.println();
                                break;
                            
                            case 7:
                                calculatorA.randomOperation();
                                break;
                            default:
                                System.out.println("No recuerdo haber proporcionado una opcion con ese numero :c");
                                System.out.println();
                        }

                    } while (ejecutarI);

                    break;

                case 2: // ---------------------------------------------------------------------------- MODO BINARIO

                    do {

                        System.out.println();
                        System.out.println("********************* CALCULADORA MODO BINARIO :D *********************");
                        System.out.println("[1] RESTA");
                        System.out.println("[2] DIVISION");
                        System.out.println("[3] COMPLEMENTO A 1");
                        System.out.println("[4] COMPLEMENTO A 2");
                        System.out.println("[5] MENU PRINCIPAL");
                        System.out.println("[6] MOSTRAR MEM");
                        System.out.println("[7] OPERACION ALEATORIA");
                        System.out.print("Ingresa la opcion a realizar :D porfavor: ");

                        int op = scanner.nextInt();
                        int res = 0;
                        int bin1;
                        int bin2;
                        int max = 100;
                        int min = 0;
                        int range = max - min + 1;
                        int dec1 = (int)(Math.random() * range) + min;
                        int dec2 = (int)(Math.random() * range) + min;

                        System.out.println();

                        switch (op) { // SWITCH DEL MODO DECIMAL
                            case 1:

                                System.out.println("Seleccionaste: Resta");
                                System.out.println();

                                bin1 = calculatorB.CreateBin(dec1);
                                bin2 = calculatorB.CreateBin(dec2);

                                System.out.println("Decimal 1 : " + dec1 + ", " + "Binario : " + bin1);
                                System.out.println("Decimal 2 : " + dec2 + ", " + "Binario : " + bin2);
                                System.out.println();

                                res = calculatorB.RestarBin(bin1, bin2);
                                System.out.println("Resultado: " + res);

                                break;

                            case 2:

                                System.out.println("Seleccionaste: Division");
                                System.out.println();

                                bin1 = calculatorB.CreateBin(dec1);
                                bin2 = calculatorB.CreateBin(dec2);

                                System.out.println("Decimal 1 : " + dec1 + ", " + "Binario : " + bin1);
                                System.out.println("Decimal 2 : " + dec2 + ", " + "Binario : " + bin2);
                                System.out.println();

                                int tmp = calculatorB.DividirBin(dec1, dec2);
                                res = calculatorB.CreateBin(tmp);
                                System.out.println("Resultado: " + res);

                                break;

                            case 3:

                                System.out.println("Seleccionaste: Complemento a 1");
                                System.out.println();

                                bin1 = calculatorB.CreateBin(dec1);
                                System.out.println("Decimal : " + dec1 + ", " + "Binario : " + bin1);

                                res = calculatorB.ComplementoUnoBin(dec1);
                                System.out.println("Resultado: " + Integer.toBinaryString(res));

                                break;

                            case 4:

                                System.out.println("Seleccionaste: Complemento a 2");
                                System.out.println();

                                bin1 = calculatorB.CreateBin(dec1);
                                System.out.println("Decimal : " + dec1 + ", " + "Binario : " + bin1);

                                res = calculatorB.ComplementoDosBin(dec1);
                                System.out.println("Resultado: " + Integer.toBinaryString(res));

                                break;

                            case 5:

                                ejecutarI = false;
                                System.out.println();
                                break;

                            case 6:

                                if(calculatorB.getMem() < 0){
                                    System.out.println(Long.toBinaryString(calculatorB.getMem()));
                                } else {
                                    System.out.println(calculatorB.getMem());
                                }
                                System.out.println();
                                break;
                            
                            case 7:
                                calculatorB.randomOperation();
                                break;
                            default:

                                System.out.println("No recuerdo haber proporcionado una opcion con ese numero :c");
                                System.out.println();
                        }
                    
                        if(op == 1 || op == 2 || op == 3 || op == 4) {

                            System.out.println("Deseas almacenar el resultado en la memoria? 1)SI 2)NO");
                            int save = scanner.nextInt();

                            if(save == 1){
                                if(calculatorB.getMem() != 0){
                                    System.out.println("La memoria tiene un valor, deseas sobreescribir? 1)SI 2)NO");
                                    int sobreescribir = scanner.nextInt();
                                    if(sobreescribir == 1){
                                        calculatorB.setMem(res);
                                    } 
                                } else {
                                    calculatorB.setMem(res);
                                }
                            }
                        }

                    } while (ejecutarI);
                    
                    break;

                case 3: // --------------------------------------------------------------------------- TERMINAR PROGRAMA

                    ejecutar = false;
                    System.out.println();
                    break;

                default:

                    System.out.println("No recuerdo haber mostrado una opcion con ese numero :p");
                    System.out.println();
                    break;
            }

        } while (ejecutar);

        scanner.close();
        System.out.println("ADIOS!!! :D");
        System.out.println();
    }
}