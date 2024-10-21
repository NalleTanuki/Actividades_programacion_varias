package EjemploPedirLeerDatos;

/*
Imaginemos que queremos pedirle al usuario:
    - Nombre
    - Edad
Guardar todos los datos en un fichero y luego, calcular la media de edad.
 */

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String ruta = "src/EjemploPedirLeerDatos/Fichero/usuarios.txt";

        do {
            do {
                System.out.println("1. Alta usuario.");
                System.out.println("2. Mostrar listado usuarios.");
                System.out.println("3. Mostrar media usuarios.");
                System.out.println("4. Mostrar sólo los nombres.");
                System.out.println("5. Mostrar sólo las edades.");
                System.out.println("6. Cerrar programa.");
                System.out.print("\nIntroduce una opción -> ");
                opcion = teclado.nextInt();
            } while (opcion < 1 || opcion > 6);

            switch (opcion) {
                case 1:
                    altaUsuario(ruta);
                    break;
                case 2:
                    mostrarUsuarios(ruta);
                    break;
                case 3:
                    mediaUsuarios(ruta);
                    break;
                case 4:
                    mostrarNombres(ruta);
                    break;
                case 5:
                    mostrarEdades(ruta);
            }
        } while (opcion != 6);

    }


    private static void altaUsuario(String ruta) {
        Scanner teclado = new Scanner(System.in);

        String nombre = "";
        int edad = 0;

        try {
            FileWriter fw = new FileWriter(ruta, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Introduce un nombre ");
            nombre = teclado.next();

            System.out.println("Introduce tu edad ");
            edad = teclado.nextInt();

            bw.write(nombre + " " + edad + "\n");

            bw.close();
            fw.close();

            System.out.println("\nFichero guardado.");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }



    private static void mostrarUsuarios(String ruta) {
        try {
            FileReader nombreFileReader = new FileReader(ruta); //Esto abrirá el fichero
            BufferedReader nombreBufferedReader = new BufferedReader(nombreFileReader);

            String linea = "";

            do {
                linea = nombreBufferedReader.readLine(); //Leemos linea a linea

                if(linea != null) {
                    System.out.println("\n" + linea);
                }
            } while(linea != null);

            System.out.println("\nFin lectura de fichero.\n");

            nombreBufferedReader.close();
            nombreFileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mediaUsuarios(String ruta) {
        double suma = 0;
        double media = 0;
        int contadorValoresFichero = 0;

        try {
            FileReader fr = new FileReader(ruta); //Esto abrirá el fichero
            BufferedReader br = new BufferedReader(fr);

            String linea = "";

            do {
                linea = br.readLine(); //Leemos linea a linea
                //Mi linea sera string int

                //String[] valores = linea.split(" "); .split significa cortar, le pongo espacio en blanco porque es lo que separa el string del int

                if(linea != null) {
                    String [] valores = linea.split(" ");
                    double numero = Double.parseDouble(valores[1]); //parseDouble para convertirlo a double ya que la media puede ser decimal

                    suma = suma + numero; //Es lo mismo que suma += numero
                    contadorValoresFichero++;
                }
            } while(linea != null);

            media = suma/contadorValoresFichero;

            System.out.println("\nLa media es: " + media + "\n");

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void mostrarNombres(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";

            do {
                linea = br.readLine();

                if(linea != null) {
                    String [] valores = linea.split(" ");
                    String nombre = valores[0];

                    System.out.println(nombre);
                }
            } while(linea != null);



            System.out.println("\nFin lectura fichero.\n");

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void mostrarEdades(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";

            do {
                linea = br.readLine();

                if(linea != null) {
                    String [] valores = linea.split(" ");
                    int edad = Integer.parseInt(valores[1]); //Integer.parseInt para transformarlo en int

                    System.out.println(edad);
                }
            } while(linea != null);



            System.out.println("\nFin lectura fichero.\n");

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
