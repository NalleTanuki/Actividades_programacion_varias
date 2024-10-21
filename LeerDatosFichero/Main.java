package LeerDatosFichero;
/*
Leer datos de un fichero:
como acceder a ese fichero,
ir leyendo los datos
y luego ir mostrarlos por consola
 */

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String ruta = "src/fichero/frases.txt"; //Siempre poner la extensión

        //escribirFichero(ruta);
        leerFichero(ruta);
    }

    private static void leerFichero(String ruta)
    {
        try
        {
            FileReader nombreFileReader = new FileReader(ruta); //Esto abrirá el fichero
            BufferedReader nombreBufferedReader = new BufferedReader(nombreFileReader);

            /*
            Vamos a leer linea a linea,
            por lo que tenemos que decirle: desde donde hasta donde
            El ultimo / el final es null
            Es decir, que vamos a leer hasta que sea distinto de null
            Cuando sea == null, entonces dejamos de leer
             */
            String linea = "";

            do
            {
                linea = nombreBufferedReader.readLine(); //Leemos linea a linea

                if(linea != null)
                {
                    System.out.println(linea);
                }
                /*
                Imprimira por consola cada una de las lineas
                Tener en cuenta que también imprimira null,
                para evitarlo, ponemos el if de arriba
                 */
            }
            while(linea != null);

            System.out.println("Fin lectura de fichero.");

            nombreBufferedReader.close();
            nombreFileReader.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) //Excepcion por si hubiera algun caracter raro al leer la linea
        {
            e.printStackTrace();
        }
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
                frase = teclado.nextLine();

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
