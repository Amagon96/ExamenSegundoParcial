package models;

import java.util.Date;

public class Empleado extends Model{
    public static final String FIELDS = "empleado_id, nombre, apellido, fecha_nacimiento, gerente_id, plaza_id";
    public static final String TABLE = "empleado";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_BY_ID = String.format("%s WHERE empleado_id = ", Q_ALL);
    public  static final String INSERT = String.format("INSERT INTO %s (%s) VALUES%s", TABLE, FIELDS, fieldsToInsert(6));
    public static final String UPDATE = String.format("UPDATE %s SET empleado_id = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, gerente_id = ?, plaza_id = ? WHERE empleado_id =", TABLE);
    public static final String DELETE = String.format("DELETE FROM %s WHERE empleado_id = ?", TABLE);

    private Long id;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private Empleado gerente;
    private Plaza plaza;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String apellido, Date fecha_nacimiento, Empleado gerente, Plaza plaza) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.gerente = gerente;
        this.plaza = plaza;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Empleado getGerente() {
        return gerente;
    }

    public void setGerente(Empleado gerente) {
        this.gerente = gerente;
    }

    public Plaza getPlaza() {
        return plaza;
    }

    public void setPlaza(Plaza plaza) {
        this.plaza = plaza;
    }
}
