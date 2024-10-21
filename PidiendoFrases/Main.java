package PidiendoFrases;

//Pidiendo 5 frases al usuario para que se guarde en nuestro fichero.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String ruta = "src/fichero/frases.txt"; //Siempre poner la extensión

        escribirFichero(ruta);
    }

    private static void escribirFichero(String ruta)
    {
        Scanner teclado = new Scanner(System.in);

        String frase = "";

        /*
        Para guardar en el fichero, voy a necesitar 2 clases:
        1_ Para abrir el fichero - FileWriter nombre
        2_ El que nos permite escribir dentro de ese fichero - BufferWriter
         */

        try {
            FileWriter nombreFile = new FileWriter(ruta); //Asi le decimos que sobreescriba todo el rato el fichero
            //FileWriter nombreFile = new FileWriter(ruta, true); //Asi no sobreescribiria el fichero cada vez que se escribiese de nuevo algo

            BufferedWriter nombreBuffer = new BufferedWriter(nombreFile); //Nos permite escribir dentro del fichero

            for(int i = 0; i < 5; i++)
            {
                System.out.println("Introduce frase " + (i+1));
                frase = teclado.next();

                //Para escribir...
                nombreBuffer.write(frase + "\n"); //Concatenamos un \n para dar un salto de linea y que asi salga separado
                //nombreBuffer.newLine(); //Sería lo mismo que lo anterior
            }

            nombreBuffer.close(); //Guardar fichero
            nombreFile.close();   //Cerrar fichero

            //Para que el usuario sepa que SI ha escrito...
            System.out.println("Fichero guardado.");
        }
        catch(IOException e)
        { //La excepción es por si la ruta está mal, que salga un aviso en vez de explotar
            e.printStackTrace();
        }
    }
}
