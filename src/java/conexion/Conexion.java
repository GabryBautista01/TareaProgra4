package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    static String bd = "registropersonas";
    static String url = "jdbc:mysql://localhost:3306/"+bd;
    static String user = "root";
    static String pass = "";
    Connection conn = null;
    
    public Conexion() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn =  DriverManager.getConnection(url,user,pass);

            if(conn != null)
            {
                System.out.println("Conexion Completa");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error de conexion "+ex.getMessage());
        }
    }
    
    public Connection Conectar()
    {
        return conn;
    }
    
    public void Desconectar() throws SQLException
    {
        conn.close();
    }
    
}
