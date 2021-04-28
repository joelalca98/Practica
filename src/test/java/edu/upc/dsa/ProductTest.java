package edu.upc.dsa;

import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.Producto;
import edu.upc.dsa.util.ProductManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {


    @Before

    public void SetUp ()
    {
        ProductManagerImpl.getInstance().addProduct(2, "cocola", 3);
        ProductManagerImpl.getInstance().addProduct(3, "leche", 2);
        ProductManagerImpl.getInstance().addProduct(4, "cortado", 5);

        Pedido pedido = new Pedido();
        pedido.setCliente("Cris");
        pedido.addProducto(3,"manzana",5);
        pedido.addProducto(4,"red bull",5);
        ProductManagerImpl.getInstance().newPedido(pedido);
    }

    @Test
    public void CrearProducto() //Singletone creado
    {
        ProductManagerImpl.getInstance().addProduct(5, "cocacola", 10);
        assertEquals(4, ProductManagerImpl.getInstance().sizeProductos());

    }
    @Test
    public void ProcesarPedido()
    {
        ProductManagerImpl.getInstance().processPedido();
        assertEquals(0, ProductManagerImpl.getInstance().sizePedidos());
    }

    @After
    public void tearDown()
    {
        ProductManagerImpl.delete();
    }

}
