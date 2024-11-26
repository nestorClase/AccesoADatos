package DAO;

import entidades.AlumnoEntidad;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModulosDAOImplementacion implements ModulosDAO {

    private static ModulosDAOImplementacion instancia;
    private DataSource dataSource;

    private ModulosDAOImplementacion(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ModulosDAOImplementacion getInstancia(DataSource dataSource) {
        if (instancia == null) {
            instancia = new ModulosDAOImplementacion(dataSource);
        }
        return instancia;
    }

    public ArrayList<String> obtenerModulosPorIdProfesor(String idProfesor) {
        ArrayList<String> modulos = new ArrayList<>();
        String sql = "select nombre_modulo from modulo where cod_profesor = ?";
        try(Connection connection = dataSource.getConnection()) {
            connection.prepareStatement(sql);
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, idProfesor);
            try(ResultSet resultSet = pst.executeQuery()) {
                while (resultSet.next()) {
                    modulos.add(resultSet.getString("nombre_modulo"));
                }
                return modulos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
