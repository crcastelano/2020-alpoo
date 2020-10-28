package controller;

import dao.UsuarioDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.UsuarioModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

public class UsuarioController implements GenericController<UsuarioModel> {

    UsuarioDao usuariodao;

    public UsuarioController() {
        usuariodao = new UsuarioDao();
    }

    @Override
    public void incluir(UsuarioModel obj) throws Exception{
        usuariodao.incluir(obj);
    }

    @Override
    public void alterar(UsuarioModel obj) throws Exception{
        usuariodao.alterar(obj);
    }

    @Override
    public void excluir(UsuarioModel obj) throws Exception{
        usuariodao.excluir(obj);
    }

    @Override
    public ArrayList<UsuarioModel> consultar(String filtro) {
        return usuariodao.consultar(filtro);
    }

    @Override
    public void gravar(UsuarioModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioUsuario.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Usuários - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
