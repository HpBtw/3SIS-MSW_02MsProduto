package com.github.hpbtw.ms_produto.repositories;

import com.github.hpbtw.ms_produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
