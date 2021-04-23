/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author logon
 */
public class Cronometro {
 
    private Timer timer;  
    private static int metaSegundo;
    private static int metaMinuto;
    private static int metaHora;
    private static JLabel txtTempo;
    
    private final int velocidade = 1000;
    
    
    public Cronometro() {
        
    }
    
    public static void setLabel(JLabel label){
       Cronometro.txtTempo = label;
    }

    public static void setVales(int hora, int minuto, int segundo){
         Cronometro.metaSegundo = hora;
        Cronometro.metaMinuto = minuto;
        Cronometro.metaHora = segundo;
   
    }
 
    
    public String formatHora(int hora, int min, int sec) {
		String value = "";
		if (hora < 10)
			value = "0" + hora;
		else value = hora + "";

		if (min < 10)
			value += ":0" + min;
		else value += ":" + min;

		if (sec < 10)
			value += ":0" + sec;
		else value += ":" + sec;

		return value;
	}
       
    public void iniciarCronometro() {
      
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                metaSegundo--;
                
                if(metaSegundo < 0){
                    metaSegundo = 59;
                    metaMinuto--;
                    
                }
                
                if(metaMinuto < 0){
                    metaMinuto = 59;
                    metaHora--;
                    
                }               
                txtTempo.setText(formatHora(metaHora, metaMinuto, metaSegundo));
                
                if(metaHora <= 0  && metaMinuto <=0  && metaSegundo <=0){
                    //stopTime();
                }
            }  
        };  
        this.timer = new Timer(velocidade, action);
        timer.setInitialDelay(0);
        this.timer.start();
    }

   
        
}
