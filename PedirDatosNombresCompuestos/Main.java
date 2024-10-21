package PedirDatosNombresCompuestos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
    {
        String ruta = "src/PedirDatosNombresCompuestos/fichero/frases.txt";

        escribirFichero(ruta);
        leerFichero(ruta);
    }

    private static void leerFichero(String ruta)
    {
    	double suma = 0;
    	int contador = 0;
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
                	String [] datos = linea.split(" ");
                	
                	double numero = 0;
                	if (datos.length == 2)
                	{
                		numero = Double.parseDouble(datos[1]);
                	}
                	else
                	{
                		numero = Double.parseDouble(datos[2]);
                	}
            		suma += numero;
            		contador ++;
                	
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
            System.out.println("\nLa media es: " + (suma/contador);

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
