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
    Set<Personaje> listAllByName(String codigo);
    Set<Personaje> listAllPersonajeTrue();
    
    Personaje searchByCodigo(String codigo);
    
    boolean addPersonaje(String codigo,String nombre,int vida,int ataque,int defensa);

    boolean addPersonaje(Personaje c);
    
    
    boolean createPersonaje(String codigo, String nombre,int vida,int ataque,int defensa);
    boolean removePersonaje(String codigo); 
    boolean removeEnemigo(Personaje p);
    
}
