package service;



import java.util.Observable;
import view.Login;
import view.TelaPrincipal;


public class Main{
  
    public Main() {

        Login.getInstance().setVisible(true);
        
       ConnectionManager.getInstance().addObserver(TelaPrincipal.getInstance());
      
       ConnectionManager.getInstance().startSockoet();
        
         
           
        
          
    }
    

    public static void main(String[] args) {
        new Main();
    }

    

}
