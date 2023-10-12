/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;

/**
 *
 * @author Maryem
 */
interface IUserService<T> {
     public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(T t);
    public T getOne(int id);
    public List<T> getAll(T t);
    
    
    
}
