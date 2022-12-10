import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/* Programa Java que pida por teclado las alturas de N alumnos de una clase y las guarde en un ArrayList  de  tipo  Double.  
A continuación,el  programa  calculará  la  altura  media  de  todos  los alumnos, 
cuántos alumnos hay más altos que la media y cuántos más bajos.

Code in Java: a program that reads the number of students of a class, the height of the students and saves them to a Double ArrayList.
Next, the program calculates the mean heigth of the class, compares each student's heigth to the mean, and how many students have
a higher and lower height compared to the mean.*/



public class u4ac {

    //Creamos método cls para limpiar la pantalla cuando se invoque.
    //Creating method cls for cleaning the sreen when called.
    public static void cls() {  
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Creamos método enterContinuar para detener el programa hasta que se ingrese una línea.
    //Creating method enterContinuar to stop the program until an ENTER is captured.
    public static void continuar(){
        System.out.println("Presione \"ENTER\" para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    //Se crea método numeroAlumnos para leer el númnero de alumnos.
    //Creating numeroAlumnos method to read the number of students.
    public static int numeroAlumnos() {
        Scanner s = new Scanner(System.in);
        int Alumnos = 0;

        try {
            System.out.println("\n\n Ingrese la cantidad de alumnos de la clase: ");
            Alumnos = s.nextInt();
        } catch (Exception e) {
            System.out.println("No ingresó un dato válido.");
            System.exit(1); // ???
        }
        return Alumnos; 
    }
    
    /*Se crea el método leerAlturas, para leer las alturas de los alumnos por medio de un for loop y scanner.
    Para evitar errores al capturar datos que no son números se utiliza try-catch
    Creating the method leerAlturas, to read the height of students using for loop and scanner.
    To avoid errors while entering data that is not a number try-catch is used*/
    public static ArrayList<Double> leerAlturas(ArrayList<Double> estaturas, int Alumnos) {
        
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nIngrese las alturas de los alumnos: ");
            for (int i = 0; i < Alumnos; i++) {
                estaturas.add(sc.nextDouble());
            }
            
        } catch (Exception e) {
            System.out.println("No ingresó un dato válido.");
            System.exit(1);
        }
 
        return estaturas;
    }


    /*Creating a method calcularMedias, that uses for loop to add all the heights, and then returns the result
    of dividing that sum by the number of elements in the arraylist (using .size()) */
    public static double calcularMedias(ArrayList<Double> lista) {
        double suma = 0.0;

        for (Double x : lista) {
            suma += x;
        }
        return suma/lista.size();
    }

    /*Creating mostrarResultados, this method uses for loop to print the elements in the array (we use another array for the headers), and then
     print the elements in ArrayList, also we add another column using the if statement, which compares the height to the mean, and prints
     "higher","lower", "same" depending on the result of that comparisson. In the same if statement we use a variable int that sums
     1 each time a number is higher, lower or same to theman. Finally, we print said variable (there are 3 variables of this kind
     sup, inf or mid) and explain how many students are higher, lower or same to the mean.*/

    public static void mostrarResultados(ArrayList<Double> lista, double media) {
        System.out.println();
        String[] encabeza = {"Alumno", "Estatura","vs la media"};
        int sup = 0;
        int inf = 0;
        int mid = 0;
        
        for (int i = 0; i < encabeza.length;i++) {
            System.out.printf("%16s", encabeza[i]);
        }
        
        System.out.println();
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("%16s",(i+1));
            System.out.printf("%16s",lista.get(i));
            
            if (lista.get(i) < media) {
                System.out.printf("%16s","Inferior");
                inf += 1;
            } else if (lista.get(i) > media) {
                System.out.printf("%16s","Superior");
                sup += 1;

            } else {
                System.out.printf("%16s","Igual");
                mid += 1;
            }
            System.out.println();
        }
        
        System.out.printf("\n\nHay "+ inf + " alumnos con estatura inferior a la media.\n");
        System.out.printf("Hay "+ sup + " alumnos con estatura superior a la media.\n");
        System.out.printf("Hay "+ mid + " alumnos con estatura idéntica a la media.\n\n");
        
    }
    
    //Main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.printf("*".repeat(50)+"\n      SISTEMA PARA EL CÁLCULO DE ALTURAS      \n\n"+"*".repeat(50));

        //Creating the Double ArrayList.
        ArrayList<Double> estaturas = new ArrayList<Double>();

        //Calling the method numeroAlumnos to capture the number of students and assign its value to a variable.
        int Alumnos = numeroAlumnos();
        cls();

        //Calling the method numeroAlumnos to read and assign heights to the ArrayList.
        leerAlturas(estaturas, Alumnos);

        //Printing the heights in the ArrayList
        System.out.printf("\n\nLas alturas capturadas son: \n"+Arrays.toString(estaturas.toArray())+"\n\n");
        continuar();

        //Calculating the mean
        double mean = calcularMedias(estaturas);
        
        cls();
        System.out.printf("%16s","\nLa media de estaturas es: "+ mean+"\n\n");

        //Printing results, and the comparisson of heights in relation to the mean.
        mostrarResultados(estaturas, mean);
        System.out.println();
        continuar();

        s.close();

    }
}
