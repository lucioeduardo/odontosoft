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
public interface InterfaceGenericDAO<T> {
    void inserir(T var);
    List<T> listar();
    void delete(int id);
    void update(int id, T newVar);
    void buscaPorId(int id);
}
