import DTO.AlumnoDTO;
import Servicios.AlumnoServicio;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        AlumnoServicio alumnoServicio = AlumnoServicio.getInstancia(getMySqlDataSource());
        System.out.println(alumnoServicio.crearAlumno(new AlumnoDTO("1", "Pedro", "Fernandez", 35, 'A')));
        System.out.println(alumnoServicio.obtenerAlumnoPorId("1").toString());
        System.out.println(alumnoServicio.actualizarAlumno("1", new AlumnoDTO("1", "alejandro", "pupu", 20, 'C')));
        System.out.println(alumnoServicio.obtenerAlumnoPorId("1").toString());
        System.out.println(alumnoServicio.eliminarAlumno("1"));
        System.out.println(alumnoServicio.obtenerTodosLosAlumnos());
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