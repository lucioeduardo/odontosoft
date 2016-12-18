/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.dao;

import java.util.List;

/**
 *
 * @author eduardo
 */
public interface InterfaceGenericDAO<T,idType> {
    void inserir(T var);
    List<T> listar();
    void delete(idType id);
    void update(idType id, T newVar);
    T buscaPorId(idType id);
}
