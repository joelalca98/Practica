package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Pedido {

    List<Producto> productos = new LinkedList<>();
    String cliente; //Un cliente hará una lista de pedidos


    public Pedido(List<Producto> productos, String cliente) {
        this.productos = productos;
        this.cliente = cliente;
    }
    public void addProducto(int cantidad, String id, double precio){
        this.productos.add(new Producto(cantidad,id,precio));
    }

    public Pedido() {
    }

    public List<Producto> getPedidos() {
        return productos;
    }

    public void setPedidos(List<Producto> pedidos) {
        this.productos = pedidos;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
