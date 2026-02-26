package com.github.hpbtw.ms_produto.service;

import com.github.hpbtw.ms_produto.dto.ProdutoDto;
import com.github.hpbtw.ms_produto.entities.Produto;
import com.github.hpbtw.ms_produto.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepo;

    @Transactional(readOnly = true)
    public List<ProdutoDto> findAllProdutos() {
        List<Produto> produtos = produtoRepo.findAll();

        return produtos.stream().map(ProdutoDto::new).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoDto findProdutoById(Long id) {
        Produto prod = produtoRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Produto de ID '" + id + "' não encontrado")
            );
        return new ProdutoDto(prod);
    }

    @Transactional
    public ProdutoDto saveProduto(ProdutoDto prodDto) {
        Produto prod = new Produto();

        copyDtoToProduto(prodDto, prod);
//        prod = produtoRepo.save(prod);
//        return new ProdutoDto(prod);
        return new ProdutoDto(produtoRepo.save(prod));
    }

    private void copyDtoToProduto(ProdutoDto prodDto, Produto prod) {
        prod.setNome(prodDto.getNome());
        prod.setDescricao(prodDto.getDescricao());
        prod.setValor(prodDto.getValor());
    }

    @Transactional
    public ProdutoDto updateProduto(Long id, ProdutoDto prodDto) {
        try {
            Produto prod = produtoRepo.getReferenceById(id);
            copyDtoToProduto(prodDto, prod);
            return new ProdutoDto(produtoRepo.save(prod));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Produto de ID '" + id + "' não encontrado!");
        }
    }

    @Transactional
    public void deleteProdutoById(Long id) {
        if (!produtoRepo.existsById(id)) {
            throw new EntityNotFoundException("Produto de ID '" + id + "' não encontrado!");
        }
        produtoRepo.deleteById(id);
    }
}
