package to;

import java.util.Date;

public class TOFacturas {

    private int idFacturas;
    private int idUsuarioFactura;
    private double valorTotal;
    private Date fechaCompra;
    private String tipoFactura;
    private String nombreVendedor;
    private String apellidoVendedor;
    private String tipoDocumentoVendedor;
    private String documentoVendedor;

    public TOFacturas() {
    }
/*
    public TOFacturas(int idUsuarioFactura, double valorTotal, Date fechaCompra, String tipoFactura, String nombres, String apellidos) {
        this.idUsuarioFactura = idUsuarioFactura;
        this.valorTotal = valorTotal;
        this.fechaCompra = fechaCompra;
        this.tipoFactura = tipoFactura;
    }
*/
    public int getIdFacturas() {
        return idFacturas;
    }

    public int getIdUsuario() {
        return idUsuarioFactura;
    }

    public void setIdUsuario(int idUsuarioFactura) {
        this.idUsuarioFactura = idUsuarioFactura;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public int getIdUsuarioFactura() {
        return idUsuarioFactura;
    }

    public void setIdUsuarioFactura(int idUsuarioFactura) {
        this.idUsuarioFactura = idUsuarioFactura;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApellidoVendedor() {
        return apellidoVendedor;
    }

    public void setApellidoVendedor(String apellidoVendedor) {
        this.apellidoVendedor = apellidoVendedor;
    }

    public String getTipoDocumentoVendedor() {
        return tipoDocumentoVendedor;
    }

    public void setTipoDocumentoVendedor(String tipoDocumentoVendedor) {
        this.tipoDocumentoVendedor = tipoDocumentoVendedor;
    }

    public String getDocumentoVendedor() {
        return documentoVendedor;
    }

    public void setDocumentoVendedor(String documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
    }

    
    
}
