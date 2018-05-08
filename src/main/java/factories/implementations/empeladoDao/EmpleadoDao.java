package factories.implementations.empeladoDao;

import connections.Conexion;
import factories.interfaces.PlazaDao;
import models.Empleado;
import models.Plaza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao implements factories.interfaces.EmpleadoDao {

    PlazaDao plazaDao;

    public EmpleadoDao(PlazaDao plazaDao) {
        this.plazaDao = plazaDao;
    }

    @Override
    public void create(Empleado obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(Empleado.INSERT);
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setString(i++, obj.getApellido());
            ps.setDate(i++, (Date) obj.getFecha_nacimiento());
            ps.setLong(i++, obj.getPlaza().getId());
            ps.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex){

        }
    }

    @Override
    public List<Empleado> read(String criteria) {
        List<Empleado> empleados = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getConn().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Empleado.Q_ALL, criteria));
            while(rs.next()){
                empleados.add(makeEmpleado(rs));
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return empleados;
    }

    @Override
    public Empleado read(Long id) {
        Empleado empleado = null;
        try {
            Connection conexion = Conexion.getInstance().getConn();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Empleado.Q_BY_ID, id));
            if(rs.next()){
                empleado = makeEmpleado(rs);
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return empleado;
    }

    @Override
    public void update(Empleado obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(String.format("%s, %s", Empleado.UPDATE, obj.getId()));
            Integer i = 1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getNombre());
            ps.setString(i++, obj.getApellido());
            ps.setDate(i++, (Date) obj.getFecha_nacimiento());
            ps.setLong(i++, obj.getPlaza().getId());
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

    private Empleado makeEmpleado(ResultSet rs) throws SQLException {
        Empleado empleado = new Empleado();
        Integer i = 1;
        empleado.setId(rs.getLong(i++));
        empleado.setNombre(rs.getString(i++));
        empleado.setApellido(rs.getString(i++));
        empleado.setFecha_nacimiento(rs.getDate(i++));
        Long plazaId = rs.getLong(i++);
        empleado.setPlaza(plazaDao.read(plazaId));
        return empleado;
    }

    public PlazaDao getPlazaDao() {
        return plazaDao;
    }

    public void setPlazaDao(PlazaDao plazaDao) {
        this.plazaDao = plazaDao;
    }
}
