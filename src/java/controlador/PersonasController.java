package controlador;

import conexion.Conexion;
import dao.PersonasDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import modelo.Personas;

public class PersonasController 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Conexion con = new Conexion();
        Personas per = new Personas(0);
        PersonasDAO perD = new PersonasDAO(con);
        int option = 0;
        do
        {
            System.out.println("Seleccionar acción:\n");
            System.out.println("1. Agregar Registros");
            System.out.println("2. Editar Registros");
            System.out.println("3. Mostrar Todos los Registros");
            System.out.println("4. Mostrar Registro Especifico");
            System.out.println("5. Eliminar Registros");
            System.out.println("6. Salir de aplicación");
            option = scanner.nextInt();
            
            switch(option)
            {
                case 1: 
                    System.out.println("Ingrese nombre: ");
                    per.setNombre(scanner.next());
                    System.out.println("Ingrese Apellido: ");
                    per.setApellido(scanner.next());
                    System.out.println("Ingresar dia, mes y año de nacimiento");
                    System.out.println("Dia :");
                    int dia = scanner.nextInt();
                    System.out.println("mes :");
                    int Mes = scanner.nextInt();
                    System.out.println("Año :");
                    int anio = scanner.nextInt();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(anio, Mes, dia);
                    Date fecha = (Date) calendar.getTime();
                    per.setFecha(fecha);
                    System.out.println("Ingresar Documento:");
                    per.setDocumento(scanner.next());
                    
                    if(perD.InsertPersonas(per))
                    {
                        System.out.println("Los datos se ingresaron correctamente");
                    }
                    else
                    {
                        System.out.println("Error al guardar");
                    }
                break;
                case 2: 
                    System.out.println("Ingresar Id del usuario:");
                    per.setIdPersona(scanner.nextInt());
                    System.out.println("Ingrese nombre: ");
                    per.setNombre(scanner.next());
                    System.out.println("Ingrese Apellido: ");
                    per.setApellido(scanner.next());
                    System.out.println("Ingresar dia, mes y año de nacimiento");
                    System.out.println("Dia :");
                    int diaE = scanner.nextInt();
                    System.out.println("mes :");
                    int MesE = scanner.nextInt();
                    System.out.println("Año :");
                    int anioE = scanner.nextInt();
                    Date fechaE =  Date.valueOf(LocalDate.of(anioE, MesE, diaE));
                    per.setFecha(fechaE);
                    System.out.println("Ingresar Documento:");
                    per.setDocumento(scanner.next());
                    
                    if(perD.UpdatePersonas(per))
                    {
                        System.out.println("Los datos se ingresaron correctamente");
                    }
                    else
                    {
                        System.out.println("Error al guardar");
                    }
                break;
                case 3:
                    List<Personas> listaTodos = perD.ShowAll(); 
                    System.out.println("Listado de Personas\n");
                    
                    try
                    {
                    for(Personas p : listaTodos)
                    {
                        System.out.println("Nombre: "+p.getNombre());
                        System.out.println("Apellido: "+p.getApellido());
                        System.out.println("Fecha de Nacimiento: "+p.getFecha().toString());
                        System.out.println("Documento: "+p.getDocumento());
                        System.out.println("");
                    }
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    
                break;
                case 4:
                                        
                    System.out.println("Ingrese id del registro para filtrar");
                    per.setIdPersona(scanner.nextInt());
                    
                    List<Personas> lista = perD.SelectPersonaById(per.getIdPersona());
                    
                    for(Personas p : lista)
                    {
                        System.out.println("Nombre: "+p.getNombre());
                        System.out.println("Apellido: "+p.getApellido());
                        System.out.println("Fecha: "+p.getFecha().toString());
                        System.out.println("Documento: "+p.getDocumento());
                        System.out.println("");
                    }
                    
                break;
                case 5:
                    System.out.println("ingrese id del registro a borrar");
                    if(perD.deletePersonas(scanner.nextInt()))
                    {
                        System.out.println("Los datos se eliminaron correctamente");
                    }
                    else
                    {
                        System.out.println("Error al eliminar");
                    }
                break;
                case 6:
                    break;
                default:
                    System.out.println("Error al seleccionar operacion");
                    break;
            }
        }while(option != 6);
        
        System.out.println("Fin de la Aplicación");
        scanner.next();        
    }
}
