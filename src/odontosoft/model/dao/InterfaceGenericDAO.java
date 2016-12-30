package odontosoft.model.dao;

import java.util.List;

/**
 *
 * @author eduardo
 * @param <T> Classe relacionada ao DAO
 * @param <idType> Tipo de id da classe(pode ser int ou string)
 */


public interface InterfaceGenericDAO<T,idType> {
    void inserir(T var);
    List<T> listar();
    void delete(idType id);
    void update(idType id, T newVar);
    T buscaPorId(idType id);
}
