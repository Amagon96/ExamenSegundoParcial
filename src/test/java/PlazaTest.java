import connections.Conexion;
import factories.interfaces.CiudadDao;
import factories.interfaces.PlazaDao;
import models.Ciudad;
import models.Plaza;
import org.junit.Assert;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlazaTest {

    @Test
    public void createTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        PlazaDao plazaDao = new factories.implementations.plazaDao.PlazaDao(ciudadDao);

        ciudadDao.read("1");

        Ciudad ciudad = ciudadDao.read(new Long("1"));

        Plaza plaza = new Plaza(new Long("1"), "Categoria1", ciudad);
        ciudadDao.create(ciudad);
        Ciudad countryToTry = ciudadDao.read(new Long("1"));
        Assert.assertNotNull(ciudadDao);
    }

    

}
