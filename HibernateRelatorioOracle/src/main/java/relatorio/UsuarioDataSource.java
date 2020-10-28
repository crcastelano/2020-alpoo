package relatorio;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import model.UsuarioModel;

public class UsuarioDataSource implements JRDataSource {

    private Iterator itrUsuarios;
    private Object valorAtual;

    private int i = 0;

    private boolean irParaProximoAluno = true;

    /**
     * @param campos
     * @param itr
     */
    public UsuarioDataSource(List lista) {
        super();
        this.itrUsuarios = lista.iterator();
    }

    public boolean next() throws JRException {
        valorAtual = itrUsuarios.hasNext() ? itrUsuarios.next() : null;
        irParaProximoAluno = (valorAtual != null);
        return irParaProximoAluno;
    }

    public Object getFieldValue(JRField campo) throws JRException {
        Object valor = null;
        UsuarioModel usuario = (UsuarioModel) valorAtual;

        if ("USU_ID".equals(campo.getName())) {
            valor = usuario.getUSU_ID();
        } else if ("USU_NOME".equals(campo.getName())) {
            valor = usuario.getUSU_NOME();
        } else if ("USU_LOGIN".equals(campo.getName())) {
            valor = usuario.getUSU_LOGIN();
        }

        return valor;
    }
}