import java.sql.*;

/**
 * En esta clase aprenderemos a crear una conexion desde java a nuestra base de datos
 */
public class Main {
    public static void main(String[] args) {
        try{
            // Ahora estamos creando la conexion con la base de datos
            String url = "jdbc:mysql://127.0.0.1/prueba";
            Connection conexion = DriverManager.getConnection(url,"root","123456789");

            //Creamos la conexion
            Statement stmt1=conexion.createStatement();
            //Preparamos la consulta
            String sql = "insert into persona (nombre, apellido, edad, numero_telefo) VALUES (?,?,?,?)";

            //Preparamos la informacion para mandarle
            PreparedStatement pst = conexion.prepareStatement(sql);
            //mandamos los datos dependiendo de su tipo de dato
            pst.setString(1,"pedro");
            pst.setString(2,"fernandez");
            pst.setInt(3,35);
            pst.setString(4,"+34 856321456");
            //Mandamos la consulta con los datos
            pst.executeUpdate();

            Statement stmtUpdate = conexion.createStatement();
            String sql2 = "update persona " +
                    "set nombre= "+'?'+
                    "where id = 1";
            PreparedStatement pst1 = conexion.prepareStatement(sql2);
            pst1.setString(1,"perororo");
            pst1.executeUpdate();



            //Una vez la conexion ya esta preparada la iniciamos
            Statement stmt = conexion.createStatement();
            //Aqui le ponemos la consulta a hacer en este caso sacar info
            String sql1 = "select id, nombre, apellido from persona";
            // metemos el resultado en esta variable
            ResultSet resultado = stmt.executeQuery(sql1);

            // Esto nos devuelve uno a uno los resultados
            while (resultado.next()){
                //Creamos varibles para almacenar los resultados dependiendo de si tipo de dato
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String apellido = resultado.getString("apellido");
                // imprimimos los resultados
                System.out.println("persona "+ id + ": " +
                        "\nnombre ="+nombre+
                        "\napellido ="+apellido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}