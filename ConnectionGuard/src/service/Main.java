
package service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.entidades.ConfigServidor;

import view.Config;
import view.Login;


public class Main {

    

    public Main() throws IOException {

//       this.guard = ConnectionGuard.getInstance();
//       this.guard.setIPManager("172.21.105.1");
//       this.guard.setPORT(5555);
//ConnectionGuard.getInstance().connect();
//        ConnectionGuard.getInstance().startSockoet();

//        ConnectionService service = new ConnectionService();
//        service.setAction(ConnectionService.Action.CONFIG);
//
//        ConnectionGuard.getInstance().sendToManager(service);
        
        ConnectionGuard guard;
        try {
            ConfigServidor.configurar();
          
            guard = ConnectionGuard.getInstance();
            guard.setIPManager(ConfigServidor.IP);
            guard.setPORT(ConfigServidor.PORTA);
           
           ConnectionGuard.getInstance().connect();
            ConnectionGuard.getInstance().startSockoet();
            
            Login frmLogin = Login.getInstance();
                 
            frmLogin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frmLogin.setVisible(true);
            
        } catch (IOException ex) {
             new Config().setVisible(true);
        }
        

    }
    public static void main(String[] args) throws IOException {
        new Main();
    }

}
