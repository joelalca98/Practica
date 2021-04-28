package edu.upc.dsa.util;

import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.Producto;

import java.util.List;

public interface ProductManager {

    public List<Producto> getProductAsc(); // Listado de productos ordenados ascendientemente
    public void newPedido (Pedido pedido); //Realizar un pedido
    public Pedido processPedido(); //Servir un pedido
    public List<Pedido> getPedidoUser (String idUser); //Listado de productos de un usuario
    public List<Producto> getProductDesc(); //Listado e productos ordenados descendientemente
    public void addProduct (Integer cantidad, String id, double precio);
    public int sizeProductos ();
    public int sizePedidos ();
    public int sizeHistorial();

}
