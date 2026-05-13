package cafeexpresso;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens;
    private StatusPedido status;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("So e possivel adicionar itens em pedidos pendentes.");
        }
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void pagar() {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("So e possivel pagar um pedido pendente.");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Nao e possivel pagar um pedido sem itens.");
        }
        this.status = StatusPedido.PAGO;
    }

    public void enviarParaCozinha() {
        if (status != StatusPedido.PAGO) {
            throw new IllegalStateException("So e possivel enviar para a cozinha um pedido pago.");
        }
        this.status = StatusPedido.EM_PREPARO;
    }

    public void finalizarPedido() {
        if (status != StatusPedido.EM_PREPARO) {
            throw new IllegalStateException("So e possivel finalizar um pedido em preparo.");
        }
        this.status = StatusPedido.FINALIZADO;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}
