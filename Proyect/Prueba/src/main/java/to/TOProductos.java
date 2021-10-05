
package to;

import java.util.Date;

public class TOProductos {
    
    private int idProductos;
     private String nombreProducto;
     private String categoria;
     private String descripcion;
     private int stock;
     private Date  vencimiento;
    // private String proveedor;
     private double precioVentaUnitario;
     private double valorUnitario;

    public TOProductos() {
    }

    public TOProductos(int idProductos, String nombreProducto, String categoria, String descripcion, int stock, Date vencimiento, /*String proveedor,*/ double precioVentaUnitario, double valorUnitario) {
        this.idProductos = idProductos;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.stock = stock;
        this.vencimiento = vencimiento;
        //this.proveedor = proveedor;
        this.precioVentaUnitario = precioVentaUnitario;
        this.valorUnitario = valorUnitario;
    }

 

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }
/*
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
*/
    public double getPrecioVentaUnitario() {
        return precioVentaUnitario;
    }

    public void setPrecioVentaUnitario(double precioVentaUnitario) {
        this.precioVentaUnitario = precioVentaUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


     
     
}
