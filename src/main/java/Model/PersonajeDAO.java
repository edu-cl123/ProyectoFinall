/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Utils.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author educa
 */
public class PersonajeDAO extends Personaje implements IPersonaje {

    private boolean persist;
    private boolean detatch;

    public PersonajeDAO() {
        super();
        persist = false;
    }

    public PersonajeDAO(int codigo, String nombre, int vida, int ataque, int defensa) {
        super(codigo, nombre, vida, ataque, defensa);
        persist = false;
    }

    public void persist() {
        persist = true;
    }

    public void detatch() {
        detatch = false;
    }

    @Override
    public void setCodigo(int codigo) {
        super.setCodigo(codigo);
        if (persist) {
            save();
        }
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
        if (persist) {
            save();
        }
    }

    @Override
    public void setVIda(int vida) {
        super.setVida(vida);
        if (persist) {
            save();
        }
    }

    @Override
    public void setAtaque(int ataque) {
        super.setAtaque(ataque);
        if (persist) {
            save();
        }
    }

    @Override
    public void setDefensa(int defensa) {
        super.setDefensa(defensa);
        if (persist) {
            save();
        }
    }

    @Override
    public int save() {
        int result = -1;

        try {
            java.sql.Connection csql = Utils.ConnectionUtils.getConnection();

            if (this.nombre != null) {
                String q = "UPDATE personaje SET codigo=?,nombre=?, vida=?, ataque=?, defensa=?";
                PreparedStatement ps = csql.prepareStatement(q);
            } else {
                //INSERT
                String q = "INSERT INTO personaje (codigo,nombre,vida,ataque,defensa) VALUES(NULL,?,?,?,?)";

                PreparedStatement ps = csql.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, codigo);
                ps.setString(2, nombre);
                ps.setInt(3, vida);
                ps.setInt(4, ataque);
                ps.setInt(4, defensa);

                result = ps.executeUpdate();
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result = generatedKeys.getInt(1); //devuelve el ultimo id insertado
                    }
                }
                this.codigo = result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonajeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    public static List<Personaje> selectALL(){
        return selectALL();
    }

    @Override
    public int remove() {
        int result = -1;
        
        if(this.codigo > 0){
            
            try{
                java.sql.Connection csql = ConnectionUtils.getConnection();
                String q = "DELETE FROM clientes WHERE codigo = " + this.codigo;
                PreparedStatement ps = csql.prepareStatement(q);
                result = ps.executeUpdate();
                if(result>0)
                    this.codigo=-1;
            }catch (SQLException ex) {
                Logger.getLogger(PersonajeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return result;    }
}
