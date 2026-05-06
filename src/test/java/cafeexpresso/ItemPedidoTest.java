package cafeexpresso;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemPedidoTest {

    @Test
    void deveCalcularSubtotalCorretamente() {
        Produto produto = new Produto("Cappuccino", 8.0);
        ItemPedido item = new ItemPedido(produto, 3);
        assertEquals(24.0, item.calcularSubtotal());
    }

    @Test
    void naoDeveCriarItemComProdutoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ItemPedido(null, 2);
        });
    }

    @Test
    void naoDeveCriarItemComQuantidadeZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Produto produto = new Produto("Cappuccino", 8.0);
            new ItemPedido(produto, 0);
        });
    }

    @Test
    void naoDeveCriarItemComQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            Produto produto = new Produto("Cappuccino", 8.0);
            new ItemPedido(produto, -1);
        });
    }
}
