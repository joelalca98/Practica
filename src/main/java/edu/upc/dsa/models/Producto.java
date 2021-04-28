package edu.upc.dsa.models;

public class Producto {

    Integer cantidad;
    String id;
    double precio;

    public Producto() {
    }

    public Producto(Integer cantidad, String id, double precio) {
        this.cantidad = cantidad;
        this.id = id;
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
