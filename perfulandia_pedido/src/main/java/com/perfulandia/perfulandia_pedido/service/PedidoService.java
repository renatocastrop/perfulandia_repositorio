
package com.perfulandia.perfulandia_pedido.service;

import com.perfulandia.perfulandia_pedido.model.Pedido;
import com.perfulandia.perfulandia_pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPedido(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido actualizarPedido(int id, Pedido pedido) {
        Pedido existente = pedidoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setCliente(pedido.getCliente());
            existente.setProducto(pedido.getProducto());
            existente.setCantidad(pedido.getCantidad());
            existente.setTotal(pedido.getTotal());
            existente.setFecha(pedido.getFecha());
            return pedidoRepository.save(existente);
        }
        return null;
    }

    public void eliminarPedido(int id) {
        pedidoRepository.deleteById(id);
    }
}
