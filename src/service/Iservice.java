/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entitie.Categorie;
import java.util.List;

/**
 *
 * @author Skymil
 */
public interface Iservice<T> {
    public void ajouter(T t);
    public void modifier(T t,int id);
    public void supprimer(int id);
    public List<T> afficher();
}
