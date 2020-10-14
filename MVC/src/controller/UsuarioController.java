package controller;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UsuarioModel;

public class UsuarioController {
    private Connection conexao;
    
    public UsuarioController() {
        conexao = Conexao.getConexao();
    }
    
    public boolean adicionar(UsuarioModel usuario) {
        boolean retorno = true;
        String sql = "INSERT INTO USUARIO (USU_NOME, USU_LOGIN, USU_SENHA, USU_ATIVO)"
                + " VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, usuario.getUSU_NOME());
            stm.setString(2, usuario.getUSU_LOGIN());
            stm.setString(3, usuario.getUSU_SENHA());
            stm.setInt(4, usuario.getUSU_ATIVO());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }

    public boolean alterar(UsuarioModel usuario) {
        boolean retorno = true;
        String sql = "UPDATE USUARIO SET USU_NOME = ?, USU_LOGIN = ?, "
                + "USU_SENHA = ?, USU_ATIVO = ? WHERE USU_ID = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, usuario.getUSU_NOME());
            stm.setString(2, usuario.getUSU_LOGIN());
            stm.setString(3, usuario.getUSU_SENHA());
            stm.setInt(4, usuario.getUSU_ATIVO());
            stm.setInt(5, usuario.getUSU_ID());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }

    public boolean excluir(UsuarioModel usuario) {
        boolean retorno = true;
        String sql = "DELETE FROM USUARIO WHERE USU_ID = ?";
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, usuario.getUSU_ID());
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }

    public ArrayList<UsuarioModel> consultar(String condicao) {
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<UsuarioModel> lista = null;

        String sql = "SELECT * FROM USUARIO";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        try {
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            lista = new ArrayList<UsuarioModel>();

            while (rs.next()) {
                UsuarioModel objusu = new UsuarioModel();
                objusu.setUSU_ID(rs.getInt("USU_ID"));
                objusu.setUSU_NOME(rs.getString("USU_NOME"));
                objusu.setUSU_LOGIN(rs.getString("USU_LOGIN"));
                objusu.setUSU_SENHA(rs.getString("USU_SENHA"));
                objusu.setUSU_ATIVO(rs.getInt("USU_ATIVO"));
                lista.add(objusu);
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            lista = null;
        }
        return lista;
    }

    public boolean gravar(String operacao, UsuarioModel usuario) {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            retorno = adicionar(usuario);
        } else if (operacao.equals("alterar")) {
            retorno = alterar(usuario);
        }
        return retorno;
    }
}
