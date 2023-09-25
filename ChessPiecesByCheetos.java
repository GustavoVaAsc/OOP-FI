import java.util.Scanner;

public class ChessPiecesByCheetos {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        char[][] tablero = new char[32][32];
        boolean status = true;
        int x = 0;
        int y = 0;

        while (status == true) {
            System.out.println("NOTA: EL ORGIEN (0,0) SE ENCUENTRA EN LA ESQUINA SUPERIOR IZQUIERDA");
            System.out.println("SIN EMBARGO LA VISUALIZACION DE PIEZAS SE DA EN LA FORMA HABITUAL LO UNICO QUE CAMBIA ES EL SISTEMA DE REFERENCIA");
            System.out.println("");
            System.out.println("1 -> CABALLO (H)");
            System.out.println("2 -> ALFIL (B)");
            System.out.println("3 -> TORRE (T)");
            System.out.println("4 -> REY (K)");
            System.out.println("5 -> REINA (Q)");
            System.out.println("6 -> PEON (P)");
            System.out.println("7 -> SALIR");
            System.out.print("Ingresa la opcion a realizar: ");

            int opcion = scanner.nextInt();

            System.out.println("");

            int bando = 0;

            if(opcion == 6){
                System.out.println("INGRESE EL BANDO DEL PEON");
                System.out.println("INGRESA 0 PARA BLANCO (AVANZA ARRIBA)");
                System.out.println("INGRESA 1 PARA NEGRO (AVANZA ABAJO)");

                bando = scanner.nextInt();

                if(bando != 0 && bando != 1){
                    System.out.println("BANDO INVALIDO, SELECCIONADO BLANCO POR DEFECTO");
                    bando = 0;
                }
            }

            if(opcion != 7 && bando == 0 || bando == 1) { // Ingresamos las coordenadas de la pieza seleccionada
                do {
                    System.out.print("Ingresa la coordenada X de la pieza: ");
                    x = scanner.nextInt();
                    System.out.print("Ingresa la coordenada Y de la pieza: ");
                    y = scanner.nextInt();

                    if(((x < 0) || (x >= 32)) || ((y < 0) || (y >= 32))){
                        System.out.println("Uno o los dos valores ingresado exceden el limite del tablero");
                    }

                } while (((x < 0) || (x >= 32)) || ((y < 0) || (y >= 32))); // Ciclo para que se ingresen coordenadas validas

            }

            System.out.println("");

            for (int i = 0; i < 32; i++) { //En este ciclo procedemos a limpiar el tablero para cada iteracion
                for (int j = 0; j < 32; j++) {
                    tablero[i][j] = ' ';
                }
            }

            switch (opcion) {

// ------------------------------------------------------ CABALLO ------------------------------------------------------

                case 1:
                    tablero[y][x] = 'H';
                    System.out.println("POSIBLES MOVIMIENTOS DEL CABALLO EN LA COORDENADA (" + x + "," + y + ")");
                    System.out.println("");
                    
                    // MOVIMIENTOS A LA DEREHCA
                    if((x + 2 < 32) && (y - 1 >= 0)){  // arriba
                        tablero[y - 1][x + 2] = 'x';
                    }
                    if((x+2 < 32) && (y + 1 < 32)){ // abajo
                        tablero[y + 1][x + 2] = 'x';
                    }

                    // MOVIMIENTOS A LA IZQUIERDA
                    if((x - 2 >= 0) && (y - 1 >= 0)){ // arriba
                        tablero[y - 1][x - 2] = 'x';
                    }
                    if((x - 2 >= 0) && (y + 1 < 32)){ // abajo
                        tablero[y + 1][x - 2] = 'x';
                    }

                    // MOVIMIENTOS HACIA ABAJO
                    if((x + 1 < 32) && (y + 2 < 32)){ // derecha
                        tablero[y + 2][x + 1] = 'x';
                    }
                    if((x - 1 >= 0) && (y + 2 < 32)){ // izquierda
                        tablero[y + 2][x - 1] = 'x';
                    }

                    // MOVIMIENTOS HACIA ARRIBA
                    if((x + 1 < 32) && (y - 2 >= 0)){ // derecha
                        tablero[y - 2][x + 1] = 'x';
                    }
                    if((x - 1 >= 0) && (y - 2 >= 0)){ // izquierda
                        tablero[y - 2][x - 1] = 'x';
                    }

                break;

// ------------------------------------------------------ ALFIL ------------------------------------------------------

                case 2:
                    tablero[y][x] = 'B';
                    System.out.println("POSIBLES MOVIMIENTOS DEL ALFIL EN LA COORDENADA (" + x + "," + y + ")");
                    System.out.println("");

                    // DIAGONAL ARRIBA A LA DERECHA
                    for(int i = x + 1, j = y - 1; (i < 32) && (j>= 0); i++, j--){
                        tablero[j][i] = 'x';
                    }

                    // DIAGONAL ARRIBA A LA IZQUIERDA
                    for(int i = x - 1, j = y - 1; (i>= 0) && (j >= 0); j--, i--){
                        tablero[j][i] = 'x';
                    }

                    // DIAGONAL ABAJO A LA DERECHA
                    for(int i = x + 1, j = y + 1; (i < 32) && (j < 32); j++, i++){
                        tablero[j][i] = 'x';
                    }

                    // DIAGONAL ABAJO A LA IZQUIERDA
                    for(int i = x - 1, j = y + 1; (i >= 0) && (j < 32); i--, j++){
                        tablero[j][i] = 'x';
                    }

                break;

// ------------------------------------------------------ TORRE ------------------------------------------------------

                case 3:
                    tablero[y][x] = 'T';
                    System.out.println("POSIBLES MOVIMIENTOS DE LA TORRE EN LA COORDENADA (" + x + "," + y + ")");
                    System.out.println("");

                    // DERECHA
                    for(int i = x + 1; i < 32; i++){
                        tablero[y][i] = 'x';
                    }

                    // IZQUIERDA
                    for(int i = x - 1; i >= 0; i--){
                        tablero[y][i] = 'x';
                    }

                    // ARRIBA
                    for(int i = y - 1; i >= 0; i--){
                        tablero[i][x] = 'x';
                    }

                    // ABAJO
                    for(int i = y + 1; i < 32; i++){
                        tablero[i][x] = 'x';
                    }

                break;

// ------------------------------------------------------ REY ------------------------------------------------------

                case 4:
                    tablero[y][x] = 'K';
                    System.out.println("POSIBLES MOVIMIENTOS DEL REY EN LA COORDENADA (" + x + "," + y + ")");
                    System.out.println("");

                    //  VALIDACION PARA MOVIMIENTOS VERTICALES DEL REY
                    if (y - 1 >= 0) { // Movimiento hacia arriba
                        tablero[y - 1][x] = 'x';
                    }
                    if (y + 1 < 32) { // Movimiento hacia abajo
                        tablero[y + 1][x] = 'x';
                    }

                    // VALIDACION PARA MOVIMIENTOS HORIZONTALES DEL REY
                    if (x - 1 >= 0) { // Movimiento hacia la izquierda
                        tablero[y][x - 1] = 'x';
                    }
                    if (x + 1 < 32){ // Movimiento hacia la derecha
                        tablero[y][x + 1] = 'x';
                    }

                    // VALIDACION PARA MOVIMIENTOS DIAGONALES
                    if ((y - 1 >= 0) && (x + 1 < 32)) { // Movimiento diagonal derecha hacia arriba
                        tablero[y - 1][x + 1] = 'x'; 
                    }
                    if ((y - 1 >= 0) && (x - 1 >= 0)) { // Movimiento diagonal izquierda hacia arriba  
                        tablero[y - 1][x - 1] = 'x'; 
                    }
                    if ((y + 1 < 32) && (x - 1 >= 0)) { // Movimiento diagonal izquierda hacia abajo
                        tablero[y + 1][x - 1] = 'x';
                    }
                    if ((y + 1 < 32) && (x + 1 < 32)) { // Movimiento diagonal derecha abajo
                        tablero[y + 1][x + 1] = 'x';
                    }

                break;

// ------------------------------------------------------ REINA ------------------------------------------------------

                case 5:
                    tablero[y][x] = 'Q';
                    System.out.println("POSIBLES MOVIMIENTOS DE LA REINA EN LA COORDENADA (" + x + "," + y + ")");
                    System.out.println("");

                    // DIAGONAL ARRIBA A LA DERECHA
                    for(int i = x + 1, j = y - 1; (i < 32) && (j>= 0); i++, j--){
                        tablero[j][i] = 'x';
                    }

                    // DIAGONAL ARRIBA A LA IZQUIERDA
                    for(int i = x - 1, j = y - 1; (i>= 0) && (j >= 0); j--, i--){
                        tablero[j][i] = 'x';
                    }

                    // DIAGONAL ABAJO A LA DERECHA
                    for(int i = x + 1, j = y + 1; (i < 32) && (j < 32); j++, i++){
                        tablero[j][i] = 'x';
                    }

                    // DIAGONAL ABAJO A LA IZQUIERDA
                    for(int i = x - 1, j = y + 1; (i >= 0) && (j < 32); i--, j++){
                        tablero[j][i] = 'x';
                    }

                    // DERECHA
                    for(int i = x + 1; i < 32; i++){
                        tablero[y][i] = 'x';
                    }

                    // IZQUIERDA
                    for(int i = x - 1; i >= 0; i--){
                        tablero[y][i] = 'x';
                    }

                    // ARRIBA
                    for(int i = y - 1; i >= 0; i--){
                        tablero[i][x] = 'x';
                    }

                    // ABAJO
                    for(int i = y + 1; i < 32; i++){
                        tablero[i][x] = 'x';
                    }

                break;

// ------------------------------------------------------ PEON ------------------------------------------------------
                case 6:
                    tablero[y][x] = 'P'; // Posición del peon en el tablero

                    System.out.println("POSIBLES MOVIMIENTOS DEL PEON EN LA COORDENADA (" + x + "," + y + ")");
                    System.out.println("NOTA: LAS 'X' DIAGONALES SON VALIDAS SIEMPRE Y CUANDO EXISTA UNA PIEZA RIVAL AHI");
                    System.out.println("");
                    
                    if(bando == 0){

                        if (y - 1 >= 0) { // Validacion vertical
                            tablero[y - 1][x] = 'x'; 
                            if(y == 31) {
                                tablero[y - 2][x] = 'x';
                            }
                            if (x - 1 >= 0) {
                                tablero[y - 1][x - 1] = 'x'; // Validacion izquierda (comer)
                            }
                            if (x + 1 < 32) {
                                tablero[y - 1][x + 1] = 'x'; // Validacion derecha (comer)
                            }
                        }

                        break;
                    }else if(bando == 1){
                        if (y + 1 < 32) { // Movimiento hacia abajo
                            tablero[y + 1][x] = 'x';
                        }
                        if ((y + 1 < 32) && (x - 1 >= 0)) { // Movimiento diagonal izquierda hacia abajo
                            tablero[y + 1][x - 1] = 'x';
                        }
                        if ((y + 1 < 32) && (x + 1 < 32)) { // Movimiento diagonal derecha abajo
                            tablero[y + 1][x + 1] = 'x';
                        }
                        if(y == 0){
                            tablero[y + 2][x] = 'x';
                        }
                        break;
                    }
// ------------------------------------------------------ SALIR ------------------------------------------------------

                case 7:  
                    status = false;
                    break;

                default:
                    System.out.println("LA OPCION INGRESADA NO ES VALIDA");
                    break;
            }

// -------------------------------------------------------------------------------------------------------------------

            if(opcion != 7){

                for (int i = 0; i < 32; i++) { // Mostramos el tablero con las posibles combinaciones de la pieza seleccionada
                    for (int j = 0; j < 32; j++) {
                        System.out.print("|" + tablero[i][j]);
                    }
                    System.out.println("|");
                }

                System.out.println("|");

            }
        }

        scanner.close();
    }
}
