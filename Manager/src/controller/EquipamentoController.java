package controller;

import dao.EquipamentoDAO;
import dao.EstoqueEquipamentoDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.entidades.Equipamento;
import model.entidades.EstoqueEquipamento;
import model.entidades.Fornecedor;
import model.entidades.TipoEquipamento;

public class EquipamentoController {
    
        private SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    private String descricao;
    private Fornecedor f = new Fornecedor();
    private Date dataFabricacao;
    private float valor;
    private TipoEquipamento tipoEquipamento = new TipoEquipamento();
    private int garantia;
    private Equipamento e;

    public EquipamentoController(String descricao, String fornecedor, Date dataFabricacao, String tipoEquipamento, float valor, int garantia) {
        this.descricao = descricao;
        this.f.setNome(fornecedor);
        this.dataFabricacao = dataFabricacao;
        this.tipoEquipamento.setTipo(tipoEquipamento);
        this.valor = valor;
        this.garantia = garantia;
        e = new Equipamento(descricao, garantia, dataFabricacao, f, valor, this.tipoEquipamento);
    }

    public EquipamentoController() {

    }

    public boolean salvar() {
        if(validar())
        return new EquipamentoDAO(e).salvar();
        else {
            JOptionPane.showMessageDialog(null, "Não foi possível validar os dados digitados.\nVerifique se digitou todos corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Equipamento> filtrar(String filtro) {
        return new EquipamentoDAO().filtrar(filtro);
    }

    public List<Equipamento> listar() {
        return new EquipamentoDAO().listar();
    }

    private boolean validar() {
        return descricao.length() > 0 && valor > 0 && data.format(dataFabricacao).length() == 10;
    }

    public Equipamento findByDesc(String desc) {
       return new EquipamentoDAO().findByDesc(desc);
    }

    public boolean editar() {
         if(validar())
        return new EquipamentoDAO(e).editar(descricao);
        else {
            JOptionPane.showMessageDialog(null, "Não foi possível validar os dados digitados.\nVerifique se digitou todos corretamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean inserirEstoque(String nome, int qtd) {
        boolean flag = false;
        if(new EquipamentoDAO().getByDescricao(nome)){
            Equipamento e = new EquipamentoDAO().findByDesc(nome);
            flag = new EstoqueEquipamentoDAO(new EstoqueEquipamento(e, qtd)).salvar();
        }
        return flag;
    }

}
