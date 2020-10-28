package dao;

import java.util.ArrayList;

public interface GenericDao<T> {
    public void incluir(T obj) throws Exception;
    public void alterar(T obj) throws Exception;
    public ArrayList<T> consultar(String filtro);
    public void excluir(T obj) throws Exception;        
    public T get(long id);    
}
