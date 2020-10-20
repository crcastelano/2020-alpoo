package controller;

import dao.UsuarioDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UsuarioModel;

public class UsuarioController {

    private List<UsuarioModel> listausuarios;

    public ArrayList<UsuarioModel> consultar(String filtro) throws SQLException {
        listausuarios = new UsuarioDao().consultar(filtro);
        return (ArrayList<UsuarioModel>) listausuarios;
    }

    public void excluir(UsuarioModel usuario) throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        dao.excluir(usuario);
    }

    public void adicionar(UsuarioModel usuario) throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        dao.adicionar(usuario);
    }

    public void alterar(UsuarioModel usuario) throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        dao.alterar(usuario);
    }

    public void gravar(String operacao, UsuarioModel usuario) throws SQLException {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(usuario);
        } else if (operacao.equals("alterar")) {
            alterar(usuario);
        }
    }
    
    public void enviarEmail() {
        
    }
    
    public void exportarExcel() {
        
    }
    
    public void exportarPdf() {
        
    }
}
