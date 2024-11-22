package DAO;

import com.mysql.cj.jdbc.MysqlDataSource;
import entidades.AlumnoEntidad;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAOImplementacion implements AlumnoDAO {

    private static AlumnoDAOImplementacion instancia;
    private DataSource dataSource;

    private AlumnoDAOImplementacion(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static AlumnoDAOImplementacion getInstancia(DataSource dataSource) {
        if (instancia == null) {
            instancia = new AlumnoDAOImplementacion(dataSource);
        }
        return instancia;
    }

    @Override
    public void crearAlumno(AlumnoEntidad alumno) {
        String sql = "insert into alumno (cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo) VALUES (?,?,?,?,?)";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, alumno.getCodAlumno());
            pst.setString(2, alumno.getNombreAlumno());
            pst.setString(3, alumno.getApellidoAlumno());
            pst.setDate(4, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
            pst.setString(5, String.valueOf(alumno.getGrupo()));
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AlumnoEntidad obtenerAlumnoPorId(String id) {
        String sql = "select * from alumno where cod_alumno = ?";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            try(ResultSet resultSet = pst.executeQuery()) {
                if (resultSet.next()) {
                    return new AlumnoEntidad(
                            resultSet.getString("cod_alumno"),
                            resultSet.getString("nombre_alumno"),
                            resultSet.getString("apellidos_alumno"),
                            resultSet.getDate("fecha_nacimiento"),
                            resultSet.getString("grupo").charAt(0)
                    );
                }
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AlumnoEntidad> obtenerTodosLosAlumnos() {
        List<AlumnoEntidad> alumnos = new ArrayList<>();
        String sql = "select * from alumno";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            try(ResultSet resultSet = pst.executeQuery()) {
                while (resultSet.next()) {
                    alumnos.add(new AlumnoEntidad(
                            resultSet.getString("cod_alumno"),
                            resultSet.getString("nombre_alumno"),
                            resultSet.getString("apellidos_alumno"),
                            resultSet.getDate("fecha_nacimiento"),
                            resultSet.getString("grupo").charAt(0)
                    ));
                }
                return alumnos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarAlumno(AlumnoEntidad alumno) {
        String sql = "update alumno set nombre_alumno = ?, apellidos_alumno = ?, fecha_nacimiento = ?, grupo = ? where cod_Alumno = ?";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, alumno.getNombreAlumno());
            pst.setString(2, alumno.getApellidoAlumno());
            pst.setDate(3, new java.sql.Date(alumno.getFechaNacimiento().getTime()));
            pst.setString(4, String.valueOf(alumno.getGrupo()));
            pst.setString(5, alumno.getCodAlumno());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarAlumno(String id) {
        String sql = "delete from alumno where cod_Alumno = ?";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
