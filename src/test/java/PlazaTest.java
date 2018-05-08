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

        ciudadDao.read(new Long("1"));

        Ciudad ciudad = ciudadDao.read(new Long("1"));

        Plaza plaza = new Plaza(new Long("1"), "Categoria1", ciudad);
        plazaDao.create(plaza);
        Ciudad ciudadToTry = ciudadDao.read(new Long("1"));
        Assert.assertNotNull(ciudadToTry);
    }

    @Test
    public void readByIdTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        PlazaDao plazaDao = new factories.implementations.plazaDao.PlazaDao(ciudadDao);
        ciudadDao.read("1");
        Plaza plaza = plazaDao.read(new Long("1"));
        Assert.assertNotNull(plaza);
        System.out.println(plaza);
    }

    @Test
    public void readTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();

        ciudadDao.read("1");

        Ciudad ciudad = ciudadDao.read(new Long("1"));
        PlazaDao plazaDao = new factories.implementations.plazaDao.PlazaDao(ciudadDao);

        List<Plaza> plazas = plazaDao.read("WHERE country_id = 1");
        for (Plaza plaza : plazas){
            System.out.println(plaza);
            Assert.assertNotNull(plaza);
        }
    }

    @Test
    public void updateTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        PlazaDao plazaDao = new factories.implementations.plazaDao.PlazaDao();
        ciudadDao.read("1");

        Ciudad ciudad = ciudadDao.read(new Long("1"));
        Plaza plaza =  plazaDao.read(new Long("1"));
        plaza.setCategoria("categoria nueva");
        plaza.setCiudad(ciudad);
        plazaDao.update(plaza);
        Plaza plazaToTry = plazaDao.read(new Long("1"));
        Assert.assertEquals(plaza, plazaToTry);
    }

    @Test
    public void deleteTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        ciudadDao.read("1");
        PlazaDao plazaDao = new factories.implementations.plazaDao.PlazaDao(ciudadDao);
        plazaDao.delete(new Long("1"));
    }

}
