package Calculators.DecCalc;
import Calculators.Calculadora;

public class CalculadoraDecimal extends Calculadora{
    public long Factorial(long n) {

        if (n == 0) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }

    public void Chicharronera(double a, double b, double c) {

        double dis = b * b - 4 * a * c;

        if (dis > 0) {
            double x1 = (-b + Math.sqrt(dis)) / (2 * a);
            double x2 = (-b - Math.sqrt(dis)) / (2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (dis == 0) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
        } else {
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-dis) / (2 * a);
            System.out.println("x1 = " + real + " + " + imaginary + "i");
            System.out.println("x2 = " + real + " - " + imaginary + "i");
        }
    }

    public int[][] Create(int n) {

        int[][] matriz = new int[n][n];
        int max = 100;
        int min = 0;
        int range = max - min + 1;
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = (int)(Math.random() * range) + min;
                matriz[i][j] = x;
            }
        }

        return matriz;

    }

    public int[][] Transpuesta(int[][] matriz) {

        int rows = matriz.length;
        int columns = matriz[0].length;
        int[][] matrizT = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrizT[j][i] = matriz[i][j];
            }
        }

        return matrizT;
    }

    public void PrintM(int[][] matriz) {

        int rows = matriz.length;
        int columns = matriz[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void PuntoMedio(double x1, double y1, double x2, double y2) {

        double X = (x1 + x2) / 2;
        double Y = (y1 + y2) / 2;
        System.out.println("Punto medio (" + X + ", " + Y + ")");
    }

    @Override 
    public void randomOperation(){
        int max = 4;
        int min = 1;
        int range = max - min + 1;
        int x = (int)(Math.random() * range) + min;

        switch(x){
            case 1:
                System.out.println("Te toco Factorial!");
                int max1 = 50;
                int min1 = 1;
                int range1 = max1 - min1 + 1;
                int x1 = (int)(Math.random() * range1) + min1;
                long fact = this.Factorial(x1);
                System.out.println("El factorial de "+x1 +" es "+fact);
                break;
            case 2:
                System.out.println("Te toco solucion de ecuacion cuadratica!");
                double max2 = 25;
                double min2 = -25;
                double range2 = max2 - min2 + 1;
                double a = (int)(Math.random() * range2) + min2;
                double b = (int)(Math.random() * range2) + min2;
                double c = (int)(Math.random() * range2) + min2;
                this.Chicharronera(a, b, c);
                break;
            case 3:
                System.out.println("Te toco Matriz Transpuesta!");
                int max3 = 5;
                int min3 = 2;
                int range3 = max3 - min3 + 1;
                int o = (int)(Math.random() * range3) + min3;
                int mat[][] = this.Create(o);
                int transMat[][] = this.Transpuesta(mat);
                System.out.println("La transpuesta de: ");
                System.out.println();
                this.PrintM(mat);
                System.out.println("es: ");
                System.out.println();
                this.PrintM(transMat);
                break;
            case 4:
                System.out.println("Te toco punto medio entre rectas!");
                double max4 = 25;
                double min4 = -25;
                double range4 = max4 - min4 + 1;
                double u = (int)(Math.random() * range4) + min4;
                double v = (int)(Math.random() * range4) + min4;
                double g = (int)(Math.random() * range4) + min4;
                double h = (int)(Math.random() * range4) + min4;
                this.PuntoMedio(u, v, g, h);
                break;
        }

    }


}