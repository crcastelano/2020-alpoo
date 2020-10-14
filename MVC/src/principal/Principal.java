/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;

import conexao.Conexao;
import view.UsuarioView;

/**
 *
 * @author celio
 * 
 * criação da tabela usuário:
 * 
 * CREATE TABLE usuario (
     USU_ID     SERIAL      NOT NULL,
     USU_NOME   VARCHAR(80),
     USU_LOGIN  VARCHAR(20) NOT NULL,
     USU_SENHA  VARCHAR(80),
     USU_ATIVO  NUMERIC(1)
   );
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexao objconexao = new Conexao();
        UsuarioView usuarioview = new UsuarioView();
        objconexao.desconectar();
    }
    
}
