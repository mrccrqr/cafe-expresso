package cafeexpresso;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void deveCriarProdutoComSucesso() {
        Produto produto = new Produto("Espresso", 5.0);
        assertEquals("Espresso", produto.getNome());
        assertEquals(5.0, produto.getPrecoUnitario());
    }

    @Test
    void naoDeveCriarProdutoComNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", 5.0);
        });
    }

    @Test
    void naoDeveCriarProdutoComPrecoZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Espresso", 0);
        });
    }

    @Test
    void naoDeveCriarProdutoComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Espresso", -3.0);
        });
    }
}