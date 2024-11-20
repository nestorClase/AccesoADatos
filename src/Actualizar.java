import java.sql.*;

public class Actualizar {
    public static void main(String[] args) {
        try {
            // Se define la URL  a la base de datos
            String url = "jdbc:mysql://127.0.0.1/prueba";
            // Establecemos la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, "root", "123456789");
            // Desactivamos el auto-commit para gestionar manualmente las transacciones
            conexion.setAutoCommit(false);

            // Preparamos una sentencia SQL para seleccionar todos los registros de la tabla "persona"
            // El ResultSet es de tipo "TYPE_SCROLL_SENSITIVE" (puedes moverlo hacia adelante y atrás)
            // y "CONCUR_UPDATABLE" (permite actualizar los registros)
            PreparedStatement ps = conexion.prepareStatement("select * from persona",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Ejecutamos la consulta SQL y obtenemos los resultados en un ResultSet
            ResultSet rs = ps.executeQuery();

            // Iteramos sobre los resultados del ResultSet
            while (rs.next()) {
                // Actualizamos el valor de la columna 5 (por ejemplo, una columna de texto) añadiendo "-000"
                rs.updateString(5, rs.getString(5) + "-000");
                // Confirmamos los cambios realizados en esta fila específica
                rs.updateRow();
            }

            // Confirmamos (commit) todos los cambios realizados durante la transacción
            conexion.commit();
            // Cerramos el PreparedStatement para liberar los recursos
            ps.close();
        } catch (SQLException e) {
            // Si ocurre algún error en la conexión o en la consulta, lanzamos una excepción RuntimeException
            throw new RuntimeException(e);
        }
    }
}
