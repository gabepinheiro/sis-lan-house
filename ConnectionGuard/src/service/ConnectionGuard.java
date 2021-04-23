package service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.entidades.Estacao;
import service.ConnectionService.Action;

import view.Login;
import view.TempoAlugado;

public class ConnectionGuard {

    private Socket socket;
    private ObjectOutputStream output;
    private String IPManager;
    private int PORT;

    public static ConnectionGuard instance = null;

    private ConnectionGuard() {
    }

    public static ConnectionGuard getInstance() { // singleton  
        if (instance == null) {
            instance = new ConnectionGuard();
        }
        return instance;
    }

    public ConnectionGuard(String IPConnectionManager, int PORT) {
        this.IPManager = IPConnectionManager;
        this.PORT = PORT;
    }

    public Socket connect() {
        try {
            setSocket(new Socket(this.getIPManager(), this.getPORT()));
            this.output = new ObjectOutputStream(getSocket().getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionGuard.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getSocket();
    }

    public void sendToManager(ConnectionService usr) {
        try {
            output.writeObject(usr);

        } catch (IOException ex) {
            Logger.getLogger(ConnectionGuard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startSockoet() {
        new Thread(new ListenerSocket(getSocket())).start();
    }

    public class ListenerSocket implements Runnable {

        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {

            }
        }

        @Override
        public void run() {

            ConnectionService conservice = null;

            try {
                while ((conservice = (ConnectionService) input.readObject()) != null) {
                    Action action = conservice.getAction();

                    if (action.equals(Action.LOGIN)) {
                        Estacao estacao = conservice.getEstacao();

                        TempoAlugado tempo = new TempoAlugado();
                        tempo.setValues(estacao.getHour(), estacao.getMinute(), estacao.getSecond());
                        tempo.setVisible(true);
                        tempo.iniciarCronometro();
                        Login.getInstance().setVisible(false);

                    } else if (action.equals(Action.LOGOUT)) {
                        //disconnect();
                    } else if (action.equals(Action.UNBLOCK)) {

                        System.out.println("CHegouu");

                        Estacao estacao = conservice.getEstacao();
                        // System.out.println(conservice.getEstacao().getMinute()); 
                        System.out.println(estacao.getMinute());

                        TempoAlugado tempo = new TempoAlugado();
                        tempo.setValues(estacao.getHour(), estacao.getMinute(), estacao.getSecond());
                        tempo.setVisible(true);
                        tempo.iniciarCronometro();
                        Login.getInstance().setVisible(false);

                    } else if (action.equals(Action.BLOCK)) {

                        Login.getInstance().setVisible(true);

                    } else if (action.equals(Action.ERROR)) {

                        JOptionPane.showMessageDialog(null, conservice.getMsg());

                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ConnectionGuard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getIPManager() {
        return IPManager;
    }

    public void setIPManager(String IPManager) {
        this.IPManager = IPManager;
    }

    public int getPORT() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT = PORT;
    }

    /**
     * @return the estacao
     */
    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return the socket
     */
}
