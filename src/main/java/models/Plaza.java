package models;

public class Plaza extends Model {
    public static final String FIELDS = "plaza_id, categoria, ciudad_id";
    public static final String TABLE = "plaza";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_BY_ID = String.format("%s WHERE ciudad_id = ", Q_ALL);
    public  static final String INSERT = String.format("INSERT INTO %s (%s) VALUES%s", TABLE, FIELDS, fieldsToInsert(3));
    public static final String UPDATE = String.format("UPDATE %s SET plaza_id = ?, categoria = ? , ciudad_id = ? WHERE plaza_id =", TABLE);
    public static final String DELETE = String.format("DELETE FROM %s WHERE plaza_id = ?", TABLE);

    private Long id;
    private String categoria;
    private Ciudad ciudad;

    public Plaza() {
    }

    public Plaza(Long id, String categoria, Ciudad ciudad) {
        this.id = id;
        this.categoria = categoria;
        this.ciudad = ciudad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
