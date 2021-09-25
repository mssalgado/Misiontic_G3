package to;


import java.util.Date;

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

   
    public TOUsuarios(int idUsuarios, String nombreUsuario, String clave, String rolUsuario, String nombres, String apellidos) {
        this.idUsuarios = idUsuarios;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rolUsuario = rolUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
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

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCiudadDomicilio() {
        return ciudadDomicilio;
    }

    public void setCiudadDomicilio(String ciudadDomicilio) {
        this.ciudadDomicilio = ciudadDomicilio;
    }
 
   
}
