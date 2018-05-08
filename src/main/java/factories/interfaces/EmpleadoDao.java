package factories.interfaces;

import models.Empleado;

import java.util.List;

public interface EmpleadoDao {

    public void create(Empleado obj);

    public List<Empleado> read(String criteria);

    public Empleado read(Long id);

    public void update(Empleado obj);

    public void delete(Long id);

}
