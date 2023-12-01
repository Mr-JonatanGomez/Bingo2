import java.util.Scanner;
//CREAR METODOS Y MOVERLOS TODOS AL FINAL DEL CODIGO
// APUESTA Y PRONOSTICO (movido)
// GENERACIÓN DE CARTÓN AUTOMÁTICO (movido)
// IMPRIMIR CARTON (movido)
// GENERAR LAS 99 BOLAS DEL BINGO (movido)
// IMPRIMIR BOLAS DEL BINGO por orden de aparición (movido)
// PARTE FINAL (movido)

//METER VARIABLES IMPORTANTES A PUBLIC CLASS antes del main para poder llamarlas
//LLAMAR A LOS METODOS POR ORDEN
//METER private static a las variables, si no, no funcionan (hecho)
public class Bin2method {
    private static int[] carton = new int[10];
    private static int[] numerosBingo = new int[99];
    private static int contadorBolasLinea = 0;
    private static  int contadorBolasBingo = 0;
    private static int contadorBolasLineaFinal = 0;
    private static int contadorBolasBingoFinal = 0;
    private static int aciertosLinea = 0;
    private static int aciertosBingo = 0;
    private static boolean bingoCantado = false;
    private static boolean lineaCantada = false;
    private static int pronostico;
    private static int apuesta;
    public static void main(String[] args) {

        Scanner reJugar = new Scanner(System.in);
        System.out.println("\nBIENVENIDOS AL BINGO \n \n");
        do {
            //llamar metodos aqui

        bidAndPrediction();generarCarton();imprimirCarton();
        generarBolasImprimirlasVerificaLinea();ImprimirBolasporOrden();parteFinal();

            System.out.print("El Bingo ha terminado \n ¿Quieres volver a jugar? (s/n)");
        } while (reJugar.next().equalsIgnoreCase("s"));// el anotherString ha salido solo
        System.out.println("FIN DEL PROGRAMA");

    }
    public static void bidAndPrediction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca pronostico de cuantas bolas necesitará el Bingo: ");
        int pronostico = scanner.nextInt();

        System.out.print("Introduzca la cantidad de su apuesta (€): ");
        int apuesta = scanner.nextInt();
        System.out.print("Si acierta el número exacto, multiplicará su apuesta por 10");
    }
    public static void generarCarton() {
        System.out.println("\n\n...GENERANDO CARTÓN\n");
        for (int i = 0; i < carton.length; i++) {
            int numAleatorioCarton;                         // VARIABLE DONDE SE GUARDA EL NÚMERO ALEATORIO
            do {
                numAleatorioCarton = (int) (Math.random() * 99) + 1; //GENERA ALEATORIO
                boolean existeEnCarton = false;


                for (int j = 0; j < i; j++) {               // busca en las posiciones del array carton, hasta la actual i
                    if (carton[j] == numAleatorioCarton) {  // Si el numero ya existe en carton, Existe = true, romper
                        existeEnCarton = true;
                        break;                      // al romper vuelve a generar otro, si no existe continua
                    }
                }
                if (!existeEnCarton) {                  // si es diferente a Existe
                    carton[i] = numAleatorioCarton;     // guarda el numero en el carton (posicion actual i)
                    break;                              // rompe y vuelve a generar número
                }
            } while (true);  //se seguira haciendo el bucle, mientras sea diferente y no esté lleno el [] cartón
        }
    }
    public static void imprimirCarton() {
        System.out.println("Tu cartón automático:");
        System.out.printf("%2d, %2d, %2d, %2d, %2d\n%2d, %2d, %2d, %2d, %2d\n\n",
                carton[0], carton[1], carton[2], carton[3], carton[4],
                carton[5], carton[6], carton[7], carton[8], carton[9]);
    }
    public static void generarBolasImprimirlasVerificaLinea() {
        for (int i = 0; i < numerosBingo.length; i++) {
            int numAleatorio;
            do {
                numAleatorio = (int) (Math.random() * 99) + 1;

                boolean bolaDuplicada = false;
                for (int j = 0; j < i; j++) {
                    if (numerosBingo[j] == numAleatorio) {
                        bolaDuplicada = true;
                        break;
                    }
                }

                if (!bolaDuplicada) {
                    numerosBingo[i] = numAleatorio;
                    contadorBolasBingo++;

                    for (int j = 0; j < carton.length; j++) {
                        if (numerosBingo[i] == carton[j]) {
                            aciertosBingo++;
                        }
                    }

                    if (aciertosBingo == 10) {
                        bingoCantado = true;
                        contadorBolasBingoFinal = contadorBolasBingo; // Guarda el valor final de bolas necesitadas para bingo
                    }

                    //IMPRIMIENDO BOLAS UNA A UNA
                    System.out.println(contadorBolasBingo + "ª bola extraida: ");
                    System.out.println("Numero de bola: " + numAleatorio);
                    System.out.println("Llevas " + aciertosBingo + " aciertos");


                    contadorBolasLinea++; // Incrementa el contador de bolas de línea antes de la verificación de línea cantada

                    if (aciertosLinea == 5 && !lineaCantada) {
                        lineaCantada = true;
                        contadorBolasLineaFinal = contadorBolasLinea - 1;
                        // Guarda el valor final de bolas necesitadas para linea
                        // he tenido que meterle el -1, para que cuente la cantidad correcta,
                        //no conseguia contarla en su punto exacto
                    }

                    break;

                }
            } while (true);

            if (bingoCantado) {
                System.out.println("\n¡BINGO cantado!\n");
                break; // Salir del bucle GENERAR 99 BOLAS si el bingo es cantado, generando menos si hubiera sido necesario

            }

// RECORRER Carton para verificar aciertos línea
            for (int j = 0; j < carton.length; j++) {
                if (numerosBingo[i] == carton[j]) {
                    aciertosLinea++;
                }
            }

        }
    }
    public static void ImprimirBolasporOrden() {
        System.out.println("Los números del bingo son:");
        for (int i = 0; i < contadorBolasBingoFinal; i++) {
            System.out.printf("%2d", numerosBingo[i]);


            if ((i + 1) % 20 == 0) {
                System.out.print("\n"); // Salto de línea después de cada 20 números
            } else {
                System.out.print(", "); //imprime coma y espacio tras cada i
            }
        }
    }
    public static void parteFinal (){
        // Imprimir el contador de bolas necesarias para cantar la línea y el bingo
        System.out.println("\n\nLas bolas necesitadas para cantar LÍNEA han sido: " + contadorBolasLineaFinal);
        System.out.println("Las bolas necesitadas para cantar BINGO han sido: " + contadorBolasBingoFinal);

        if (contadorBolasBingoFinal == pronostico) {
            System.out.println(" HAS ACERTADO EL PRONOSTICO, EL BOTE ESPECIAL ES: " + apuesta * 10 + "€");
        }
    }
}
