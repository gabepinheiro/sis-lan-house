package service;

import dao.BancoDeHorasDAO;
import dao.EstacaoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entidades.BancoDeHoras;
import model.entidades.Estacao;
import model.entidades.Usuario;

import service.ConnectionService.Action;

public class ConnectionManager extends Observable {

    private ObjectOutputStream output; //Executa/Envia o envio de msgs do Servidor
    private ObjectInputStream input;

    private ServerSocket serverSocket;
    private Socket socket;

    private ArrayList<Estacao> estacoes;

    private Map<Socket, ObjectOutputStream> sockets = new HashMap<Socket, ObjectOutputStream>();

    public static ConnectionManager instance = null;

    public static ConnectionManager getInstance() { // singleton  
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public ConnectionManager() {
        EstacaoDAO dao = new EstacaoDAO();
        dao.connectar();

        this.estacoes = dao.selectAll();
    }

    public void startSockoet() {
        try {

            for (Estacao e : estacoes) {
                System.out.println(e.getIp());
            }
            System.out.println("=======================");

//            Collections.sort(estacoes, new Comparator() {
//                public int compare(Object o1, Object o2) {
//                    Estacao e1 = (Estacao) o1;
//                    Estacao e2 = (Estacao) o2;
//                    return e1.getIp().compareToIgnoreCase(e2.getIp());
//                }
//            });
//            for (Estacao e : estacoes) {
//                System.out.println(e.getIp());
//            }
            serverSocket = new ServerSocket(5555);

            while (true) {
                socket = serverSocket.accept();
                new Thread(new ListenerSocket(socket)).start();

                if (sockets.isEmpty()) {
                    sockets.put(socket, output);
                } else {
                    for (Map.Entry<Socket, ObjectOutputStream> kv : sockets.entrySet()) {
                        if (!kv.getKey().getInetAddress().getHostAddress().equals(socket.getInetAddress().getHostAddress())) {
                            sockets.put(socket, output);
                        }

                    }
                }

                System.out.println("Socket IP");

                System.out.println(socket.getInetAddress().getHostAddress());

            }

        } catch (IOException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void unblock(ConnectionService con, String ip) {
        for (Map.Entry<Socket, ObjectOutputStream> kv : sockets.entrySet()) {
            if (kv.getKey().getInetAddress().getHostAddress().equals(ip)) {
                try {
                    System.out.println(con.getEstacao().getMinute());
                    kv.getValue().writeObject(con);

                } catch (IOException ex) {
                    Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        setChangedStatusEstacao(ip);
    }

    public void block(ConnectionService con) {
        try {

            output.writeObject(con);

        } catch (IOException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setChangedStatusEstacao(String ip) {
        System.out.println("Entrou no setChangedStatusEstacao");
        for (int i = 0; i < estacoes.size(); i++) {

            if (estacoes.get(i).getIp().equals(ip)) {
                if (estacoes.get(i).getStatus().equals(Estacao.Status.LIVRE)) {
                    estacoes.get(i).setStatus(Estacao.Status.OCUPADO);
                } else {
                    estacoes.get(i).setStatus(Estacao.Status.LIVRE);
                }
            }

            System.out.println(estacoes.get(i).getIp());
            System.out.println(estacoes.get(i).getStatus());
        }

        setChanged();
        notifyObservers();
    }

    public class ListenerSocket implements Runnable {

        //Recebe as msnsg enviadas pelos os clientes
        public ListenerSocket(Socket socket) {

            try {
                input = new ObjectInputStream(socket.getInputStream());
                output = new ObjectOutputStream(socket.getOutputStream());

            } catch (IOException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private boolean send(ConnectionService con) {
            try {

                output.writeObject(con);

            } catch (IOException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }

        @Override
        public void run() {
            ConnectionService conservice = null;

            try {
                while ((conservice = (ConnectionService) input.readObject()) != null) {
                    Action action = conservice.getAction();

                    if (action.equals(Action.LOGIN)) {
                        //setChangedStatusEstacao(socket.getInetAddress().getHostAddress());
                        Usuario usr = conservice.getUsr();

                        System.out.println(usr.getLogin());

                        Estacao estacao = getEstacaoByIp(socket.getInetAddress().getHostAddress());

                         System.out.println(estacao.getIp());
                        
                        UsuarioDAO usrdao = new UsuarioDAO();

                        String login = usrdao.findByLogin(usr.getLogin());

                        if (login != null) {
                            if (estacao.getHour() > 0 || estacao.getMinute() > 0 || estacao.getSecond() > 0) {
                                ConnectionService conserv = new ConnectionService();
                                conserv.setAction(ConnectionService.Action.LOGIN);

                                conserv.setEstacao(estacao);

                                for (Map.Entry<Socket, ObjectOutputStream> kv : sockets.entrySet()) {
                                    if (kv.getKey().getInetAddress().getHostAddress().equals(socket.getInetAddress().getHostAddress())) {
                                        try {
                                            kv.getValue().writeObject(conserv);
                                            
                                        } catch (IOException ex) {
                                            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                                setChangedStatusEstacao(socket.getInetAddress().getHostAddress());
                            } else {
                                int userId = new UsuarioDAO().getUserId(usr.getLogin());

                                BancoDeHoras bancohoras = new BancoDeHorasDAO().selectByUser(userId);
                                estacao.setHour(bancohoras.getHora());
                                estacao.setMinute(bancohoras.getMinuto());
                                estacao.setSecond(bancohoras.getSegundo());

                                ConnectionService conserv = new ConnectionService();
                                conserv.setAction(ConnectionService.Action.LOGIN);

                                conserv.setEstacao(estacao);

                                for (Map.Entry<Socket, ObjectOutputStream> kv : sockets.entrySet()) {
                                    if (kv.getKey().getInetAddress().getHostAddress().equals(socket.getInetAddress().getHostAddress())) {
                                        try {
                                           
                                            kv.getValue().writeObject(conserv);

                                        } catch (IOException ex) {
                                            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                                setChangedStatusEstacao(socket.getInetAddress().getHostAddress());

                            }

                        } else {
                            System.out.println(sockets.size() + "-");
                            ConnectionService conserv = new ConnectionService();
                            conserv.setAction(ConnectionService.Action.ERROR);
                            conserv.setMsg("Usuário não identificado. Digite os dados corretamente");

                            for (Map.Entry<Socket, ObjectOutputStream> kv : sockets.entrySet()) {
                                if (kv.getKey().getInetAddress().getHostAddress().equals(socket.getInetAddress().getHostAddress())) {
                                    
                                    kv.getValue().writeObject(conserv);
                                    conserv.setMsg("Usuário não identificado. Digite os dados corretamente");
                                }
                            }

                        }

                    } else if (action.equals(Action.LOGOUT)) {
                        setChangedStatusEstacao(socket.getInetAddress().getHostAddress());

                    } else if (action.equals(Action.CONFIG)) {
                        Estacao estacao = conservice.getEstacao();

                        int size = estacoes.size();
                        System.out.println("SIze: " + size);

                        int len = 0;

                        if (estacoes.isEmpty()) {
                            len = 01;
                        } else {
                            len = size += 1;
                        }

                        estacao.setDescricao("Estação " + len);

                        new EstacaoDAO().insert(estacao);
                        estacoes = new EstacaoDAO().selectAll();
                        System.out.println(estacoes.size());

                        setChanged();
                        notifyObservers();
                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the computadores
     */
    public ArrayList<Estacao> getEstacoes() {
        return estacoes;
    }

    public void setEstacoes(ArrayList<Estacao> estacao) {
        this.estacoes = estacao;
    }

    /**
     * @return the socketList
     */
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Estacao getEstacaoByIp(String ip) {

        Estacao estacao = new Estacao();

        for (int i = 0; i < estacoes.size(); i++) {
            if (estacoes.get(i).getIp().equals(ip)) {
                estacao = estacoes.get(i);
            }
        }
        return estacao;
    }
}
