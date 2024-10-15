package javaproy7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Javaproy7 {

    public static void main(String[] args) {
        // Datos de conexión
        String url = "jdbc:mysql://localhost:3306/act77"; // Cambia 'act77' si es necesario
        String usuario = "root"; // Cambia si usas otro usuario
        String password = ""; // Cambia por la contraseña que usas

        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            // Establecer conexión
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa!");

            statement = conexion.createStatement();

            rs = statement.executeQuery("SELECT * FROM inventario");

            // Mostrar resultados
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                String codigoProducto = rs.getString("codigo_producto");
                
                System.out.println("Código: " + codigo + ", Nombre: " + nombre + ", Cantidad: " + cantidad + ", Código Producto: " + codigoProducto);    
             
        // Eliminación de un registro
            String eliminacionSQL = "DELETE FROM inventario WHERE codigo = '002'";
            statement.executeUpdate(eliminacionSQL);
            System.out.println("Registro eliminado.");
            mostrarInventario(statement);
                // Modificación de un registro
                // Mostrar la tabla después de la eliminación  
            String modificacionacionSQL = null;
            statement.executeUpdate(modificacionacionSQL);
            System.out.println("Registro modificado.");
            mostrarInventario(statement); // Mostrar la tabla después de la modificación
        // Inserción de un nuevo registro
           String insercionSQL = "INSERT INTO inventario (codigo, nombre, cantidad, codigo_producto) VALUES ('016', 'destornillador', 10, 'A016')";
            statement.executeUpdate(insercionSQL);
            System.out.println("Registro insertado: 'destornillador'.");
            
            }      
            
            
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Javaproy7.class.getName()).log(Level.SEVERE, null, ex);
              } 
        finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Javaproy7.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}
