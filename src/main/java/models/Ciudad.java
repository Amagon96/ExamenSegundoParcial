package models;

public class Ciudad extends Model{

    public static final String FIELDS = "ciudad_id, nombre, activo";
    public static final String TABLE = "ciudad";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_BY_ID = String.format("%s WHERE ciudad_id = ", Q_ALL);
    public  static final String INSERT = String.format("INSERT INTO %s (%s) VALUES%s", TABLE, FIELDS, fieldsToInsert(3));
    public static final String UPDATE = String.format("UPDATE %s SET ciudad_id = ?, nombre = ? , activo = ? WHERE ciudad_id =", TABLE);
    public static final String DELETE = String.format("DELETE FROM %s WHERE ciudad_id = ?", TABLE);

    private Long id;
    private String nombre;
    private Boolean activo;

    public Ciudad() {
    }

    public Ciudad(Long id, String nombre, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
