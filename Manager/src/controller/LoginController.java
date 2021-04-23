
package controller;

import dao.FluxoLoginDAO;
import dao.UsuarioDAO;

public class LoginController {

    public LoginController() {
    }

    public void logarADM(String login) {
        int usuario = new UsuarioDAO().getUserFuncionarioId(login);
        new FluxoLoginDAO().logarADM(usuario);
    }
     public void deslogarADM(String login) {
        int usuario = new UsuarioDAO().getUserFuncionarioId(login);
        new FluxoLoginDAO().deslogarADM(usuario);
    }
       public void logar(String login) {
        int usuario = new UsuarioDAO().getUserId(login);
        new FluxoLoginDAO().logar(usuario);
    }
     public void deslogar(String login) {
        int usuario = new UsuarioDAO().getUserId(login);
        new FluxoLoginDAO().deslogar(usuario);
    }
    
}
