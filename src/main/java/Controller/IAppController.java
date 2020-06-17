/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author educa
 */
public interface IAppController {

   
  
    boolean loadPersonajeDDBB();
    boolean loadEnemigoDDBB();
    boolean loadAllDDBB();
    boolean saveAllDDBB();

    boolean savePersonajeDDBB();
    boolean saveEnemigoDDBB();
    
}
