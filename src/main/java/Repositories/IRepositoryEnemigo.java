/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Model.Enemigo;
import java.util.Comparator;
import java.util.Set;

/**
 *
 * @author educa
 */
public interface IRepositoryEnemigo {

    Set<Enemigo> listAllEnemigo();

    Set<Enemigo> listAllEnemigo(Comparator c);

    boolean addEnemigo(String codigo,String nombre,int vida,int ataque,int defensa);

    boolean addEnemigo(Enemigo c);

    boolean createEnemigo(String codigo, String nombre);

    boolean removeEnemigo(String codigo);
    
    Enemigo searchByCodigo(String codigo);

}
