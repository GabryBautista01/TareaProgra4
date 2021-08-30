
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Personas;


public class PersonasDAO 
{
    Conexion conn;
    
    public PersonasDAO(Conexion conn)
    {
        this.conn = conn;
    }
    
    public boolean InsertPersonas(Personas person)
    {
        String sql = "insert into Personas values (?,?,?,?,?)";
        try
        {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, person.getIdPersona());
            ps.setString(2, person.getNombre());
            ps.setString(3, person.getApellido());
            ps.setDate(4, person.getFecha());
            ps.setString(5, person.getDocumento());
            ps.executeUpdate();
            
            return true;
            
        }
        catch(SQLException ex)
        {
            return false;
        }
    }
    
    public List<Personas> ShowAll()
    {
        String sql = "select * from personas";
        try
        {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Personas> Lista = new LinkedList<>();
            Personas person;
            
            while(rs.next())
            {
               try
               {
                    person = new Personas(rs.getInt("idPersona"));
                    person.setNombre(rs.getString("Nombre"));
                    person.setApellido(rs.getString("Apellido"));
                    person.setFecha(rs.getDate("FechaNacimiento"));
                    person.setDocumento(rs.getString("Documento"));
                    Lista.add(person);      
               }
               catch(Exception ex)
               {
                   System.out.println(ex.getMessage());
               }
            }
            
            return Lista;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public boolean deletePersonas(int IdPersona)
    {
        String sql = "delete from personas where idPersona= ?";
        
        try
        {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, IdPersona);
            ps.executeUpdate();
            
            return true;
            
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    
    public List<Personas> SelectPersonaById(int IdPersona)
    {
        String sql = "select * from Personas where idPersona = ?";
        try
        {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, IdPersona);
            ResultSet rs = ps.executeQuery();
            List<Personas> Lista = new LinkedList<>();
            Personas person;
            
            while(rs.next())
            {
                person = new Personas(rs.getInt("idPersona"));
                person.setNombre(rs.getString("Nombre"));
                person.setApellido(rs.getString("Apellido"));
                person.setFecha(rs.getDate("FechaNacimiento"));
                person.setDocumento(rs.getString("Documento"));
                Lista.add(person);
            }
            
            return Lista;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public boolean UpdatePersonas(Personas persona)
    {
        String sql = "update personas set Nombre=?, Apellido=?,FechaNacimiento=?,Documento=? where idPersona=?";
        try
        {
           PreparedStatement ps = conn.Conectar().prepareStatement(sql);
           
           ps.setString(1, persona.getNombre());
           ps.setString(2, persona.getApellido());
           ps.setDate(3, persona.getFecha());
           ps.setString(4, persona.getDocumento());
           ps.setInt(5, persona.getIdPersona());
           ps.executeUpdate();
           
           return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
