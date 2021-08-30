
package modelo;

import java.sql.Date;

public class Personas 
{
    private int IdPersona;
    private String Nombre;
    private String Apellido;
    private Date Fecha;
    private String Documento;
    
    public Personas (int id)
    {
        this.IdPersona = id;
    }
    
    public int getIdPersona()
    {
        return IdPersona;
    }
    
    public void setIdPersona(int IdPersona)
    {
        this.IdPersona = IdPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }        

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getDocumento() {
        return Documento;
    }        
    
}
