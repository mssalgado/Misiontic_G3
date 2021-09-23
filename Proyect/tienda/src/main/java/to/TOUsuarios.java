package to;

import java.util.Date;

/**
 *
 * @author sebastian
 */
public class TOUsuarios {

    private int idUsuarios;
    private String nombreUsuario;
    private String clave;
    private String rolUsuario;
    private String nombres;
    private String apellidos;
    private String genero;
    private Date fechaNacimiento;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String direccion;
    private String telefono;
    private String correoPersonal;
    private String ciudadDomicilio;

    public TOUsuarios(String nombreUsuario, String clave, String rolUsuario, String nombres, String apellidos, String genero, Date fechaNacimiento, String tipoIdentificacion, String numeroIdentificacion, String correoPersonal) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rolUsuario = rolUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correoPersonal = correoPersonal;
    }

    public TOUsuarios(int idUsuarios, String nombreUsuario, String clave, String rolUsuario, String nombres, String apellidos, String genero, Date fechaNacimiento, String tipoIdentificacion, String numeroIdentificacion, String direccion, String telefono, String correoPersonal, String ciudadDomicilio) {
        this.idUsuarios = idUsuarios;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rolUsuario = rolUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoPersonal = correoPersonal;
        this.ciudadDomicilio = ciudadDomicilio;
    }

    public TOUsuarios() {
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public String getCiudadDomicilio() {
        return ciudadDomicilio;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public void setCiudadDomicilio(String ciudadDomicilio) {
        this.ciudadDomicilio = ciudadDomicilio;
    }

}
