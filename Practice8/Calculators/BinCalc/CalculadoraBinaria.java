package Calculators.BinCalc;
import Calculators.Calculadora;

public class CalculadoraBinaria extends Calculadora{
    public int CreateBin(int decimal){

        int bin = 0;
        int mult = 1;
        while (decimal > 0) {
            int digit = decimal % 2;
            bin += digit * mult;
            mult *= 10;
            decimal /= 2;
        }

        return bin;
    }

    public int RestarBin(int bin1, int bin2){
        int carry = 0;
        int res = 0;
        int mult = 1;

        if(bin2 > bin1){
            int tmp = bin2;
            bin2 = bin1;
            bin1 = tmp;
        }

        while (bin1 > 0 || bin2 > 0) {
            int bit1 = bin1 % 10;
            int bit2 = bin2 % 10;

            int resta = (bit1 + carry) - bit2;

            if (resta < 0) {
                resta = 1;
                carry = -1;
            } else {
                carry = 0;
            }

            res += resta * mult;
            mult *= 10;
            bin1 /= 10;
            bin2 /= 10;
        }

        return res;
    }

    public int DividirBin(int bin1, int bin2) {
        if (bin2 == 0) {
            throw new ArithmeticException("Math ERROR");
        }

        int cociente = 0;
        int resto = bin1;

        for (int i = 31; i >= 0; i--) {
            if ((resto >> i) >= bin2) {
                resto -= bin2 << i;
                cociente |= 1 << i;
            }
        }

        return cociente;
    } 

    public int ComplementoUnoBin(int bin) {
        bin = ~bin;
        return bin;
    }

    public int ComplementoDosBin(int bin) {
        bin = ~bin + 1;
        return bin;
    }


    @Override
    public void randomOperation(){
        int max = 4;
        int min = 1;
        int range = max - min + 1;
        int x = (int)(Math.random() * range) + min;
        max = 256;
        min = 1;
        range = max - min + 1;
        int a = (int)(Math.random() * range) + min;
        int b = (int)(Math.random() * range) + min;
        switch(x){
            case 1:
                a = this.CreateBin(a);
                b = this.CreateBin(b);
                System.out.println("Te toco resta!");
                int restaD = this.RestarBin(a,b);
                System.out.println("La resta de: "+a+" y "+b+" es: "+restaD);
                break;
            case 2:
                a = this.CreateBin(a);
                b = this.CreateBin(b);
                System.out.println("Te toco division!");
                int divD = this.DividirBin(a,b);
                System.out.println("La division entre: "+a+" y "+b+" es: "+divD);
                break;
            case 3:
                System.out.println("Te toco complemento A1!");
                int a1 = this.ComplementoUnoBin(a);
                System.out.println("El complemento A1 de "+a+" es "+Integer.toBinaryString(a1));
                break;
            case 4:
                System.out.println("Te toco complemento A2!");
                int a2 = this.ComplementoDosBin(a);
                System.out.println("El complemento A2 de "+a+" es "+Integer.toBinaryString(a2));
                break;
        }
    }
}