package factories.implementations.ciudadDao;

import connections.Conexion;
import models.Ciudad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadDao implements factories.interfaces.CiudadDao {
    @Override
    public void create(Ciudad obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(Ciudad.INSERT);
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setBoolean(i++, obj.getActivo());
            ps.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex){

        }
    }

    @Override
    public List<Ciudad> read(String criteria) {
        List<Ciudad> ciudades = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getConn().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Ciudad.Q_ALL, criteria));
            while(rs.next()){
                ciudades.add(makeCiudad(rs));
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return ciudades;
    }

    @Override
    public Ciudad read(Long id) {
        Ciudad region = null;
        try {
            Connection conexion = Conexion.getInstance().getConn();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Ciudad.Q_BY_ID, id));
            if(rs.next()){
                region = makeCiudad(rs);
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return region;
    }

    @Override
    public void update(Ciudad obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(String.format("%s, %s", Ciudad.UPDATE, obj.getId()));
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setBoolean(i++, obj.getActivo());
            ps.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex){

        }
    }

    @Override
    public void delete(Long id) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(Ciudad.DELETE);
            Integer i = 1;
            ps.setLong(i++, id);
            ps.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex){

        }
    }

    private Ciudad makeCiudad(ResultSet rs) throws SQLException {
        Ciudad ciudad = new Ciudad();
        Integer i = 1;
        ciudad.setId(rs.getLong(i++));
        ciudad.setNombre(rs.getString(i++));
        ciudad.setActivo(rs.getBoolean(i++));
        return ciudad;
    }
}
