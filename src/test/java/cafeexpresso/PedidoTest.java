package cafeexpresso;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void deveIniciarComStatusPendente() {
        Pedido pedido = new Pedido();
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void deveAdicionarItemAoPedido() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Espresso", 5.0);
        pedido.adicionarItem(produto, 2);
        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveCalcularTotalCorretamente() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 2);
        pedido.adicionarItem(new Produto("Cappuccino", 8.0), 1);
        assertEquals(18.0, pedido.calcularTotal());
    }
}
