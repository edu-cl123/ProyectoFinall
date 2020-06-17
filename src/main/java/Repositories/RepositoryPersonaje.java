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
public class RepositoryPersonaje implements IRepositoryPersonaje {

    private List<Personaje> Personajes;

    public RepositoryPersonaje() {
        Personajes = new ArrayList<>();
    }

    @Override
    public boolean addPersonaje(Personaje p) {
        return this.Personajes.add(p);
    }

    @Override
    public boolean addPersonaje(int codigo, String nombre, int vida, int ataque, int defensa) {
        Personaje p = new Personaje(codigo, nombre, vida, ataque, defensa);
        return this.Personajes.add(p);
    }

    @Override
    public boolean createPersonaje(int codigo, String nombre, int vida, int ataque, int defensa) {
        boolean result = false;
        if (nombre != null) {
            Personaje NuevoPersonaje = new Personaje(codigo, nombre, vida, ataque, defensa);
            result = true;
        }
        return result;
    }

   @Override
    public boolean removeEnemigo(String nombre) {
        boolean result = false;
        for (int i = 0; i < Personajes.size(); i++) {
            if (Personajes.get(i).getNombre().equals(nombre)) {
                Personajes.remove(i--);
                result = true;
            }
        }
        return result;
    }
    public boolean removeEnemigo(Personaje p) {
        return this.Personajes.contains(p);
    }

    @Override
    public Set<Personaje> listAllPersonaje(Comparator c) {
        Set<Personaje> list = new TreeSet<>();
        list.addAll(Personajes);
        return list;
    }

    @Override
    public Set<Personaje> listAllPersonaje() {
        Set<Personaje> list = new TreeSet<>();
        for (Personaje p : Personajes) {
            list.add(p);
        }
        return list;
    }

    @Override
    public Set<Personaje> listAllPersonajeTrue() {
        Set<Personaje> list = new HashSet<>();
        for (Personaje C : Personajes) {
            list.add(C);
        }
        return list;
    }

    @Override
    public Set<Personaje> listAllByName(String name) {
        Set<Personaje> newList = new TreeSet<>();
        for (int i = 0; i < Personajes.size(); i++) {
            if (Personajes.get(i).getNombre().contains(name)) {
                newList.add(Personajes.get(i));
            }
        }
        return newList;
    }

    @Override
    public Personaje searchByName(String name) {
        Personaje result = null;
        boolean aux = false;
        for (int i = 0; i < Personajes.size() && !aux; i++) {
            if (Personajes.get(i).getNombre().equals(name)) {
                result = Personajes.get(i);
                aux = true;
            }
        }
        return result;
    }

    public Personaje devolverPersonaje(String nombre) {
        Personaje result = null;
        boolean valid = false;
        for (int i = 0; i < Personajes.size() && !valid; i++) {
            if (Personajes.get(i).getNombre().equals(nombre)) {
                result = Personajes.get(i);
                valid = true;
            }
        }
        return result;
    }



}
