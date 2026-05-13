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

    @Test
    void devePagarPedidoComSucesso() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 1);
        pedido.pagar();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void naoDevePagarPedidoSemItens() {
        Pedido pedido = new Pedido();
        assertThrows(IllegalStateException.class, () -> {
            pedido.pagar();
        });
    }

    @Test
    void naoDevePagarPedidoJaPago() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 1);
        pedido.pagar();
        assertThrows(IllegalStateException.class, () -> {
            pedido.pagar();
        });
    }

    @Test
    void deveEnviarParaCozinhaComSucesso() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 1);
        pedido.pagar();
        pedido.enviarParaCozinha();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    void naoDeveEnviarParaCozinhaSemPagar() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 1);
        assertThrows(IllegalStateException.class, () -> {
            pedido.enviarParaCozinha();
        });
    }

    @Test
    void naoDeveAdicionarItemEmPedidoNaoPendente() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 1);
        pedido.pagar();
        assertThrows(IllegalStateException.class, () -> {
            pedido.adicionarItem(new Produto("Cappuccino", 8.0), 1);
        });
    }

    @Test
    void deveFinalizarPedidoComSucesso() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 1);
        pedido.pagar();
        pedido.enviarParaCozinha();
        pedido.finalizarPedido();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

    @Test
    void naoDeveFinalizarPedidoSemEstarEmPreparo() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new Produto("Espresso", 5.0), 1);
        pedido.pagar();
        assertThrows(IllegalStateException.class, () -> {
            pedido.finalizarPedido();
        });
    }
}
