package com.psii.appproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.psii.appproduto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
