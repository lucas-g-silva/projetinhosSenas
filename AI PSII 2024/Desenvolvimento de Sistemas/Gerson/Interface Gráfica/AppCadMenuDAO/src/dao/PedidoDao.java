package dao;

import java.util.List;
import model.Pedido;

/**
 *
 * @author lucas-gabreil_silva
 */
public interface PedidoDao {
    void addPedido(Pedido pedido);
    Pedido getPedido(int id);
    List<Pedido> getAllPedidos();
    void deletePedido(int id);
    int getNextCod();
}
