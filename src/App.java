import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int cantidadPersonas = 5;

        Persona[] personas = new Persona[cantidadPersonas];
        int[]personasInt= new int[cantidadPersonas];
        personasInt[0]=1;
        personas[0] = new Persona("Juan", 21);
        Scanner scanner = new Scanner(System.in);
        


        for (int i= 0 ; i<cantidadPersonas; i++){
            System.out.println("Ingrese el nombre de la persona: "+(i+1));
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la edad de la persona: "+(i+1));
            int edad = scanner.nextInt();
            scanner.nextLine();
            personas[i]= new Persona(nombre, edad);

        }
        App app = new App();
        
        // Ordenar personas por edad
        app.sortByEdad(personas);
        System.out.println("Personas ordenadas por edad:");
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " - " + p.getEdad());
        }

        // Buscar por edad
        System.out.println("Ingrese la edad a buscar:");
        int edadABuscar = scanner.nextInt();
        int posicion = app.findByEdad(personas, edadABuscar);

        if (posicion != -1) {
            System.out.println("Persona encontrada: " + personas[posicion].getNombre() + " con edad " + personas[posicion].getEdad());
        } else {
            System.out.println("No se encontró ninguna persona con esa edad.");
        }

        scanner.close();


    }


    public void sortByEdad(Persona[] personas) {
        int n = personas.length;
        for (int i = 1; i < n; i++) {
            Persona actual = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getEdad() > actual.getEdad()) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = actual;
        }
    }

    public int findByEdad(Persona[] personas, int edadBuscada) {
        int bajo = 0;
        int alto = personas.length - 1;

        while (bajo <= alto) {
            int central = (bajo + alto) / 2;
            int edadCentral = personas[central].getEdad();
            
            System.out.print("bajo ="+bajo + "  ");
            System.out.print("alto ="+alto+"  ");
            System.out.print("centro ="+central+"  ");
            System.out.print("ValorCentro"+personas[central]);
            System.out.print("");

            if (edadBuscada == edadCentral) {
                System.out.print("  ------> ENCONTRADO\n");
                return central; 
            }
            if (edadBuscada > edadCentral) {
                bajo = central + 1; 
                System.out.print("  ------> DERECHA\n");
            } else {
                alto = central - 1; 
                System.out.print("  ------> IZQUIERDA\n");
                System.out.println("|");
            }
        }

        return -1; 
    }
}
