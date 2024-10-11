package com.psii.appproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.psii.appproduto.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
