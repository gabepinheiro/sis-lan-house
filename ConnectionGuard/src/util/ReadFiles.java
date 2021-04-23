package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ReadFiles {
	private static File file = new File("/home/gabriel/Documentos/config.txt");
	
      
      public static final String readIP() throws FileNotFoundException, IOException{
            String ip = "";
            
                 FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;
                
                String pattern = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
                
		while((data = reader.readLine()) != null){
			if(data.matches(pattern)){
                            ip = data;
                        }
		}
		fileReader.close();
		reader.close();
            
            
            return ip;
           
	}
        
       public static final int readPorta() throws FileNotFoundException, IOException{
             String porta = "";
        
                 FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;
                
                String pattern = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
                
		while((data = reader.readLine()) != null){
			if(!data.matches(pattern)){
                            porta = data;
                        }
		}
		fileReader.close();
		reader.close();
            
            
            return Integer.parseInt(porta);
           
	}
}
