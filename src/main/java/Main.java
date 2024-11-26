import DTO.AlumnoDTO;
import DTO.ProfesorDTO;
import Servicios.AlumnoServicio;
import Servicios.ProfesorServicio;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        ProfesorServicio profesor = ProfesorServicio.getInstancia(getMySqlDataSource());
        System.out.println(profesor.crearProfesor(new ProfesorDTO("1", "Pedro", "Oviedo")));
        System.out.println(profesor.obtenerProfesorPorId("1").toString());
        System.out.println(profesor.actualizarProfesor("1", new ProfesorDTO("1", "alejandro", "Aviles")));
        System.out.println(profesor.obtenerProfesorPorId("1").toString());
        System.out.println(profesor.eliminarProfesor("1"));
        System.out.println(profesor.obtenerTodosLosProfesores());
        System.out.println(profesor.obetenermodulos("02"));
    }

    public static DataSource getMySqlDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/java/DB.PROPERTIES");
            props.load(fis);
            dataSource.setURL(props.getProperty("URL"));
            dataSource.setUser(props.getProperty("USUARIO"));
            dataSource.setPassword(props.getProperty("PASSWORD"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo de propiedades no encontrado: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de propiedades: " + e.getMessage(), e);
        }
        return dataSource;
    }
}