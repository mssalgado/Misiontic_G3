
package to;

import java.util.Date;


public class TODetalleFacturas extends TOFacturas {
    
   private int idDetalleFactura;
   private int idFacturasEnDetalle;
   private int idProductosEnDetalle;
   private int cantidad;
   private double iva;
      // DE LA TABLA PRODUCTO
   private String nombreProducto;
   private double precioVentaUnitario;

   
    public TODetalleFacturas() {
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getIdFacturasEnDetalle() {
        return idFacturasEnDetalle;
    }

    public void setIdFacturasEnDetalle(int idFacturasEnDetalle) {
        this.idFacturasEnDetalle = idFacturasEnDetalle;
    }

    public int getIdProductosEnDetalle() {
        return idProductosEnDetalle;
    }

    public void setIdProductosEnDetalle(int idProductosEnDetalle) {
        this.idProductosEnDetalle = idProductosEnDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioVentaUnitario() {
        return precioVentaUnitario;
    }

    public void setPrecioVentaUnitario(double precioVentaUnitario) {
        this.precioVentaUnitario = precioVentaUnitario;
    }

   

   
    
   







    
    
    
}
