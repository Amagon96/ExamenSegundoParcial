package factories.implementations.plazaDao;

import connections.Conexion;
import factories.interfaces.CiudadDao;
import models.Plaza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlazaDao implements factories.interfaces.PlazaDao {

    CiudadDao ciudadDao;

    public PlazaDao() {
    }

    public PlazaDao(CiudadDao ciudadDao) {
        this.ciudadDao = ciudadDao;
    }

    @Override
    public void create(Plaza obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(Plaza.INSERT);
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getCategoria());
            ps.setLong(i++, obj.getCiudad().getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {

        }
    }

    @Override
    public List<Plaza> read(String criteria) {
        List<Plaza> plazas= new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getConn().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Plaza.Q_ALL, criteria));
            while(rs.next()){
                plazas.add(makePlaza(rs));
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return plazas;
    }

    @Override
    public Plaza read(Long id) {
        Plaza plaza = null;
        try {
            Connection conexion = Conexion.getInstance().getConn();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",plaza.Q_BY_ID, id));
            if(rs.next()){
                plaza = makePlaza(rs);
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return plaza;
    }

    @Override
    public void update(Plaza obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(String.format("%s, %s", Plaza.UPDATE, obj.getId()));
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getCategoria());
            ps.setLong(i++, obj.getCiudad().getId());
            ps.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex){

        }
    }

    @Override
    public void delete(Long id) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(Plaza.DELETE);
            ps.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex){

        }
    }

    private Plaza makePlaza(ResultSet rs) throws SQLException {
        Plaza plaza = new Plaza();
        Integer i = 1;
        plaza.setId(rs.getLong(i++));
        plaza.setCategoria(rs.getString(i++));
        Long ciudadId = rs.getLong(i++);
        plaza.setCiudad(ciudadDao.read(ciudadId));
        return plaza;
    }

    public CiudadDao getCiudadDao() {
        return ciudadDao;
    }

    public void setCiudadDao(CiudadDao ciudadDao) {
        this.ciudadDao = ciudadDao;
    }
}
