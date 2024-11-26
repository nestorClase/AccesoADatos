package DAO;

import entidades.AlumnoEntidad;
import entidades.ProfesorEntidad;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAOImplementacion implements ProfesorDAO{
    private static ProfesorDAOImplementacion instancia;
    private DataSource dataSource;

    private ProfesorDAOImplementacion(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public static ProfesorDAOImplementacion getInstancia(DataSource dataSource){
        if (instancia == null) {
            instancia = new ProfesorDAOImplementacion(dataSource);
        }
        return instancia;
    }

    @Override
    public void crearProfesor(ProfesorEntidad profesor) {
        String sql = "insert into profesor (cod_profesor, nombre_profesor, ciudad) VALUES (?,?,?)";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, profesor.getCodProfesor());
            pst.setString(2, profesor.getNombreProfesor());
            pst.setString(3, profesor.getCiudad());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProfesorEntidad obtenerProfesorId(String id) {
        String sql = "select * from profesor where cod_profesor = ?";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, id);
            try(ResultSet resultSet = pst.executeQuery()) {
                if (resultSet.next()) {
                    return new ProfesorEntidad(
                            resultSet.getString("cod_profesor"),
                            resultSet.getString("nombre_profesor"),
                            resultSet.getString("ciudad")
                    );
                }
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProfesorEntidad> obtenerTodosLosProfesores() {
        List<ProfesorEntidad> profesores = new ArrayList<>();
        String sql = "select * from profesor";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            try(ResultSet resultSet = pst.executeQuery()) {
                while (resultSet.next()) {
                    profesores.add(new ProfesorEntidad(
                            resultSet.getString("cod_profesor"),
                            resultSet.getString("nombre_profesor"),
                            resultSet.getString("ciudad")
                    ));
                }
                return profesores;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarProfesor(ProfesorEntidad profesor) {
        String sql = "update profesor set nombre_profesor = ?, ciudad = ? where cod_profesor = ?";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, profesor.getNombreProfesor());
            pst.setString(2, profesor.getCiudad());
            pst.setString(3, profesor.getCodProfesor());
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminarProfesor(String id) {
        String sql = "delete from profesor where cod_profesor = ?";
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
