
package construirsa_act12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import javax.swing.JOptionPane;

 
public class ConstruirSA_act12 {

   
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            //1. Cargar el driver MariaDB.
            //2. Establecer la conexión a la base de datos previamente creada.
            
            String url = "jdbc:mariadb://127.0.0.1:3306/construirsa_act12";
            String usuario= "root";
            String contrasenia = "";
            Connection conexion=  DriverManager.getConnection(url, usuario, contrasenia);
          //  System.out.println("correcta conexion");
            
            
            //3. Insertar 3 empleados.
            /*
            String sqlEmpleado = "INSERT INTO empleado (dni, apellido, nombre, acceso, estado) "
                    + "VALUES (3881575, 'Gonzalez', 'Ana Maria', '1998-04-30', true), "
                    + "(35974852, 'Camargo', 'Juan Ignacio', '1992-01-30', true), "
                    + "(31988756, 'Bustos', 'Maria Belen', '1998-09-11', true)";

             PreparedStatement psEmpleado=  conexion.prepareStatement( sqlEmpleado );
            //Envia datos a la tabla, se agrega con if para saber si se agrego una fila - camppo        
            int filas = psEmpleado.executeUpdate();
            if (filas >0) {
                JOptionPane.showMessageDialog(null, "Empleado agregado correctamente");
            }
            */
            
            
            //4. Insertar 2 herramientas.
           
            /*
            String sqlHerramienta = "INSERT INTO herramienta (   nombre, descripcion, stock, estado) "
                    + "VALUES ( 'Martillo neumatico', 'de 15, para hormigon', 11, true), "
                    + "( 'Llave francesa', 'marca bosch', 12, true) ";

            PreparedStatement psHerramienta = conexion.prepareStatement(sqlHerramienta);
            //Envia datos a la tabla, se agrega con if para saber si se agrego una fila - camppo        
            int filaHerramienta = psHerramienta.executeUpdate();
            if (filaHerramienta > 0) {
                JOptionPane.showMessageDialog(null, "Herramienta agregada correctamente");
            }
      */

            
            
            //5. Listar todas las herramientas con stock superior a 10.
            String sqlStock = "SELECT * FROM herramienta h \n"
                    + "WHERE h.stock>10;";
            PreparedStatement psStock = conexion.prepareStatement(sqlStock);
            ResultSet rsStock = psStock.executeQuery();
            //devuelve tru, mientras haya datos0filas para mostrar  rsCalificacion.next();
            while (rsStock.next()) {
                int idHerramienta = rsStock.getInt("idHerramienta");
                String nombre = rsStock.getString("nombre");
                String descripcion = rsStock.getString("descripcion");
                int stock = rsStock.getInt("stock");
                 System.out.println("\n");
                System.out.println("id herramienta " + idHerramienta);
                System.out.println("nombre " + nombre);
                System.out.println("descripcion " + descripcion);
                System.out.println("stock"  + stock);
            }
             conexion.close();
                
                
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error al conectarse a la base de datos");
                    ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error SQL");
                    ex.printStackTrace();
        }
    }
    
}
