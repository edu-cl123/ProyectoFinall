/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Model.Enemigo;
import Model.Personaje;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author educa
 */
public class RepositoryEnemigo implements Comparator<Enemigo>, IRepositoryEnemigo {

    private List<Enemigo> enemigos;

    public RepositoryEnemigo() {
        enemigos = new ArrayList<>();
    }

    @Override
    public Set<Enemigo> listAllEnemigo() {
        Set<Enemigo> list = new TreeSet<>();
        for (Enemigo e : enemigos) {
            list.add(e);
        }
        return list;
    }

    @Override
    public boolean createEnemigo(String codigo, String nombre) {
        boolean result = false;
        if (codigo != null) {
            Enemigo NuevoPersonaje = new Enemigo(codigo, nombre);
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeEnemigo(String codigo) {
        boolean result = false;
        for (int i = 0; i < enemigos.size(); i++) {
            if (enemigos.get(i).getCodigo().equals(codigo)) {
                enemigos.remove(i--);
                result = true;
            }
        }
        return result;
    }

    public boolean removeEnemigo(Enemigo e) {
        return this.enemigos.contains(e);
    }

    @Override
    public Set<Enemigo> listAllEnemigo(Comparator c) {
        Set<Enemigo> list = new TreeSet<>();
        list.addAll(enemigos);
        return list;
    }

    @Override
    public int compare(Enemigo o1, Enemigo o2) {
        int result = 0;
        if (o1 != null && o2 != null) {
            result = o1.compareTo(o2);
        }
        return result;
    }

    @Override
    public boolean addEnemigo(String codigo, String nombre, int vida, int ataque, int defensa) {
        Enemigo e = new Enemigo(codigo, nombre, vida, ataque, defensa);
        return this.enemigos.add(e);
    }

    @Override
    public boolean addEnemigo(Enemigo c) {
        return this.enemigos.add(c);
    }

    public Set<Enemigo> listAllEnemyTrue() {
        Set<Enemigo> list = new HashSet<>();
        for (Enemigo e : enemigos) {
            list.add(e);
        }
        return list;
    }
    
    @Override
    public Enemigo searchByCodigo(String codigo) {
        Enemigo result = null;
        boolean aux = false;
        for (int i = 0; i < enemigos.size() && !aux; i++) {
            if (enemigos.get(i).getCodigo().equals(codigo)) {
                result = enemigos.get(i);
                aux = true;
            }
        }
        return result;
    }

}
