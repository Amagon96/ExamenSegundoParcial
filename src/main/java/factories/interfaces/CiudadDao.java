package factories.interfaces;

import models.Ciudad;

import java.util.List;

public interface CiudadDao {

    public void create(Ciudad obj);

    public List<Ciudad> read(String criteria);

    public Ciudad read(Long id);

    public void update(Ciudad obj);

    public void delete(Long id);

}
