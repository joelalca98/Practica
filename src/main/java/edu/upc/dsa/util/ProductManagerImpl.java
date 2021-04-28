package edu.upc.dsa.util;

import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.Producto;
import org.apache.log4j.Logger;

import java.util.*;

public class ProductManagerImpl implements ProductManager {
    private static ProductManagerImpl manager;
    static final Logger logger = Logger.getLogger(ProductManagerImpl.class.getName());

    public static ProductManagerImpl getInstance() {
        if (manager==null) manager = new ProductManagerImpl();
        return manager;
    } /*Singletone, puerta de entrada a la instancia*/

    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");
    }

    Queue<Pedido> pedidos; //Cola de pedidos
    List<Producto> productos;//Lista de productos
    List<Pedido> historial;

    private ProductManagerImpl (){ //Inicializar contenedores
        this.pedidos = new LinkedList<Pedido>();
        this.productos = new LinkedList<Producto>();
        this.historial = new LinkedList<>();
    }


    @Override
    public List<Producto> getProductAsc() {
        {
            Collections.sort(this.productos, new Comparator <Producto>()
                    {
                        @Override
                        public int compare(Producto o1, Producto o2)
                        {
                            return Double.compare(o1.getPrecio(), o2.getPrecio());
                        }

                    }
            );
            return this.productos;
        }
    }

    @Override
    public void newPedido(Pedido pedido) {

        this.pedidos.add(pedido); //Añadir el pedido de un cliente

    }

    @Override
    public Pedido processPedido() {

        Pedido primerPedido = this.pedidos.poll();
        this.historial.add(primerPedido);
        //Procesa el primero de la cola --> poll
        return null;
    }

    @Override
    public List<Pedido> getPedidoUser(String idUser) {
        List<Pedido> milista = new LinkedList<Pedido>();
        for (Pedido p : this.pedidos)
        {
            if (p.getCliente().equals(idUser))

            {
                milista.add(p);
                logger.info("ha coincidido"+p.getCliente());
            }
        }
        return milista;
    }

    @Override
    public List<Producto> getProductDesc() {
        {
            Collections.sort(this.productos, new Comparator <Producto>()
                    {
                        @Override
                        public int compare(Producto o1, Producto o2)
                        {
                            return Double.compare(o2.getPrecio(), o1.getPrecio());
                        }

                    }
            );
            return this.productos;
        }
    }

    @Override
    public void addProduct (Integer cantidad, String id, double precio) {

        Producto producto = new Producto (cantidad, id, precio);
        this.productos.add(producto);
    }

    @Override
    public int sizeProductos() {
        int ret = this.productos.size();
        return ret;
    }

    @Override
    public int sizePedidos() {

        int ret = this.pedidos.size();
        return ret;
    }

    @Override
    public int sizeHistorial() {
        int ret = this.historial.size();
        return ret;
    }
}
