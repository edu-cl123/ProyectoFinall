/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Model.Personaje;
import Model.Personaje;
import java.util.Comparator;
import java.util.Set;

/**
 *
 * @author educa
 */
public interface IRepositoryPersonaje {
    
    Set<Personaje> listAllPersonaje();
    Set<Personaje> listAllPersonaje(Comparator c);
    Set<Personaje> listAllByName(String nombre);
    Set<Personaje> listAllPersonajeTrue();
    boolean removeEnemigo(String nombre);
    Personaje searchByName(String nombre);
    
    boolean addPersonaje(int codigo,String nombre,int vida,int ataque,int defensa);

    boolean addPersonaje(Personaje c);
    
    
    boolean createPersonaje(int codigo, String nombre,int vida,int ataque,int defensa);
  
    boolean removeEnemigo(Personaje p);
    
}
