package Model;

public class Personaje {

    private String codigo;
    private String nombre;
    private String vida;
    private String ataque;
    private String defensa;
    

    public Personaje() {
    }

    public Personaje(String codigo, String nombre,String vida, String ataque, String defensa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
    }
        

    
    public String generarVida() {
        int Calculo = (int) Math.floor(Math.random() * 100 + 1);
        String vidaa = Integer.toString(Calculo);
        return vidaa;
    }

    public String generarAtaque() {
        int Calculo = (int) Math.floor(Math.random() * 30 + 1);
        String ataquee = Integer.toString(Calculo);
        return ataquee;
    }

    public String generarDefensa() {
        int Calculo = (int) Math.floor(Math.random() * 20 + 1);
        String defensaa = Integer.toString(Calculo);
        return defensaa;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getDefensa() {
        return defensa;
    }

    public void setDefensa(String defensa) {
        this.defensa = defensa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personaje other = (Personaje) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    public int compareTo(Personaje e) {
        int result = 0;
        if (e != null) {
            if (this.nombre.toLowerCase().equals(e.getNombre().toLowerCase())) {
                result = 0;
            } else if (this.nombre.toLowerCase().compareTo(e.getNombre().toLowerCase()) > 0) {
                result = 1;
            } else if (this.nombre.toLowerCase().compareTo(e.getNombre().toLowerCase()) < 0) {
                result = -1;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Personaje{" + "codigo=" + codigo + ", nombre=" + nombre + ", vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + '}';
    }


    

    

}
