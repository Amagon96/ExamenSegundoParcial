import factories.interfaces.CiudadDao;
import models.Ciudad;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CiudadTest {


    @Test
    public void readTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        List<Ciudad> ciudades = ciudadDao.read("WHERE region_id = 1");
        Assert.assertNotNull(ciudades);
        for (Ciudad ciudadesList : ciudades){
            System.out.println(ciudadesList);
            Assert.assertNotNull(ciudadesList);
        }
    }

    @Test
    public void readByIdTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        Ciudad ciudad = ciudadDao.read(new Long("1"));
        Assert.assertNotNull(ciudad);
        System.out.println(ciudad);
    }

    @Test
    public void createTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        Ciudad ciudades = new Ciudad(new Long("1"), "Chihuahua", true);
        ciudadDao.create(ciudades);
        Ciudad ciudadToTry = ciudadDao.read(new Long("1"));
        Assert.assertNotNull(ciudadToTry);
    }

    @Test
    public void updateTest(){
        CiudadDao ciudadDao = new factories.implementations.ciudadDao.CiudadDao();
        Ciudad ciudad =  ciudadDao.read(new Long("1"));
        ciudad.setNombre("Chihuahua");
        ciudadDao.update(ciudad);
        Ciudad ciudadToTry = ciudadDao.read(new Long("1"));
        Assert.assertNotNull(ciudadToTry);

    }

}
