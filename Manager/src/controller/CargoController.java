
package controller;

import dao.CargoDAO;
import java.util.List;
import model.entidades.Cargo;

public class CargoController {
    private String cargo;

    public CargoController() {
    }

    public CargoController(String cargo) {
        this.cargo = cargo;
    }
     public boolean salvar(String cargo){
         this.cargo = cargo;
         return(new CargoDAO().salvar(cargo));
     }

    public List<Cargo> listar() {
        List<Cargo> cargos = new CargoDAO().listar();
        return cargos;
    }
}
