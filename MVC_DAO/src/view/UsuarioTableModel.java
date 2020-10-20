package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.UsuarioModel;

public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<UsuarioModel> linhas;
    String[] colunas;

    public UsuarioTableModel(ArrayList<UsuarioModel> arrayusuario, String[] colunas) {
        this.colunas = colunas;
        linhas = arrayusuario;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        UsuarioModel usuario = (UsuarioModel) linhas.get(row);
        switch (col) {
            case 0:
                return usuario.getUSU_ID();
            case 1:
                return usuario.getUSU_NOME();
            case 2:
                return usuario.getUSU_LOGIN();
            case 3:
                return usuario.getUSU_ATIVO();                
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de UsuarioModel
    public void addLista(ArrayList<UsuarioModel> usuario) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(usuario);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}