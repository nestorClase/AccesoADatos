import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionFichero {

    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            // Cargar propiedades desde el archivo
            FileInputStream fis = new FileInputStream("src/DB.PROPERTIES");
            props.load(fis);

            // Configurar el DataSource con las propiedades cargadas
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl(props.getProperty("URL"));
            mysqlDataSource.setUser(props.getProperty("USUARIO"));
            mysqlDataSource.setPassword(props.getProperty("PASSWORD"));

            // Establecer conexión
            Connection conexion = mysqlDataSource.getConnection();
            Statement stmt = conexion.createStatement();

            // Realizar una consulta SQL
            String sql1 = "select id, nombre, apellido from persona";
            ResultSet resultado = stmt.executeQuery(sql1);

            // Procesar e imprimir resultados
            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String apellido = resultado.getString("apellido");
                System.out.println("persona " + id + ": " +
                        "\nnombre =" + nombre +
                        "\napellido =" + apellido);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo de propiedades no encontrado: " + e.getMessage(), e);
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión a la base de datos: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de propiedades: " + e.getMessage(), e);
        }
    }
}
