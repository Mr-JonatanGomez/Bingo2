public class Nuevo {

    static int[] miCarton = new int[15];
    static int[] Bingo = new int[90];

    public static void main(String[] args) {
        generarCarton();
imprimirCarton();
    }

    public static void generarCarton() {
        int aleatorio;
        boolean repetido;

        for (int i = 0; i < miCarton.length; i++) {
            do {

                repetido = false;
                aleatorio = (int) (Math.random() * 90) + 1;

                for (int numeros : miCarton) { // en miCarton hay numeros

                    if (aleatorio == numeros) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido);

            miCarton[i] = aleatorio;
            //System.out.print(miCarton[i] + ", ");

        }
    }

    public static void imprimirCarton() {
        for (int i = 0; i < miCarton.length; i++) {
            System.out.print(miCarton[i] + ", ");
        }
    }
}
