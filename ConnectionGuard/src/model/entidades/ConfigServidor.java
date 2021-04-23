
package model.entidades;

import java.io.FileNotFoundException;
import java.io.IOException;
import util.ReadFiles;

public class ConfigServidor  {
    
    public static  String IP;
    public static  int PORTA;   

    public static void configurar() throws IOException{
         IP = ReadFiles.readIP();
       PORTA = ReadFiles.readPorta();   
    }

}
