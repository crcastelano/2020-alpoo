package controller;

import java.util.ArrayList;

public interface GenericController<T> {
    public void incluir(T obj) throws Exception;
    public void alterar(T obj) throws Exception;
    public ArrayList<T> consultar(String filtro);
    public void excluir(T obj) throws Exception;        
    public void gravar(T obj, String operacao) throws Exception;
    public Exception imprimir() throws Exception;
}
