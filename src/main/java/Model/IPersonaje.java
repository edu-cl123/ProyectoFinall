/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author educa
 */
public interface IPersonaje {
    
    void setCodigo(int codigo);
    void setNombre(String nombre);
    void setVIda(int vida);
    void setAtaque(int ataque);
    void setDefensa(int defensa);   
    int save();   
   int remove();
           
    
}
