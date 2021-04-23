
package dao;

import controller.Conexao;
import java.sql.Connection;
import model.entidades.Caixa;

public class PagamentoDAO {
    

    public PagamentoDAO(Caixa caixa, float valorTotal, float ValorPago, float troco ) {
        Connection con = Conexao.getCon();
    }
    
    
    
}
