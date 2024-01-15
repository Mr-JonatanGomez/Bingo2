public class Nuevo {

    static int[] miCarton = new int[15];
    static int[] bingo = new int[90];

    static int contadorBolasLinea = 0;
    static int contadorBolasBingo = 0;
    static int contador;

    public static void main(String[] args) {
        generarCarton();
        imprimirCarton();
        generarBolas();
        imprimirBolas();
        System.out.println("\nEl numero de bolas necesarias para cantar linea fue de: "+ contadorBolasLinea);
        System.out.println("El numero de bolas necesarias para cantar Bingo fue de: "+ contadorBolasBingo);
        System.out.println("El numero de bolas  fue de: "+ contador);

    }

    public static void generarCarton() {
        int aleatorio;
        boolean repetido;

        for (int i = 0; i < miCarton.length; i++) {
            do {

                repetido = false;
                aleatorio = (int) (Math.random() * 90) + 1;

                for (int numeros : miCarton) { // en miCarton hay numeros

                    if (aleatorio == numeros) { // si aleatorio es = a algun numeros de MiCarton
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);//hacer repeticion mientras aleatorio sea true para cada posicion de i

            miCarton[i] = aleatorio; // guardamos la posicion de i
            //System.out.print(miCarton[i] + ", ");

        }
    }

    public static void imprimirCarton() {
        for (int i = 1; i < miCarton.length; i++) {

            if (i % 14 != 0) {//ponemos posiciones maximas, para evitar la coma final
                System.out.print(miCarton[i] + ", ");
            } else {
                System.out.print(miCarton[i]);
            }
        }
    }

    public static void generarBolas() {
        int aleatorio;
        boolean repetido;

        for (int i = 0; i < bingo.length; i++) {
            do {

                repetido = false;
                aleatorio = (int) (Math.random() * 90) + 1;

                for (int numeros : bingo) { // en Bingo hay numeros

                    if (aleatorio == numeros) { // si aleatorio es = a algun numero de los guardados en Bingo
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);//hacer repeticion mientras aleatorio sea true para cada posicion de i

            bingo[i] = aleatorio;// guardamos la posicion de i
            contador++;// sumamos bola a contador general

            for (int numerillos : miCarton) { // busco en mi carton, hay numerillos
                if (numerillos == bingo[i]) {
                    contadorBolasBingo++;
                }
                if (contadorBolasBingo == 5) {
                    contadorBolasLinea = contador;
                }
                if (contadorBolasBingo == 15) {
                    contadorBolasBingo = contador;
                    break;
                }
            }

        }
    }

    public static void imprimirBolas() {

        System.out.println("\t\nLAS BOLAS");
        for (int i = 1; i < bingo.length; i++) {
            if((i+1)==bingo.length){
                System.out.print(bingo[i] + ". ");// el punto final, si lo pongo como ultimo else if, no lo pone
            } else if ((i+1) % 20 != 0) {//ponemos i +1 para evitar la posicion 0, para evitar la coma final y hacer salto
                System.out.print(bingo[i] + ", ");
            } else if ((i+1) % 20 == 0){
                System.out.print(bingo[i]+ "\n");
            }
        }
    }
}
