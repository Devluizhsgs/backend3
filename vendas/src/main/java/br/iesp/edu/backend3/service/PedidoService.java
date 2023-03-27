package br.iesp.edu.backend3.service;

import br.iesp.edu.backend3.domain.entity.Pedido;
import br.iesp.edu.backend3.domain.enums.StatusPedido;
import br.iesp.edu.backend3.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}