package com.github.hpbtw.ms_produto.controller;

import com.github.hpbtw.ms_produto.dto.ProdutoRequestDTO;
import com.github.hpbtw.ms_produto.dto.ProdutoResponseDTO;
import com.github.hpbtw.ms_produto.entities.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

//    @GetMapping
//    public ResponseEntity<Produto> getProduto() {
//        Produto prod = new Produto(1L, "Nome", "Descrição", 100.50);
//
//        return ResponseEntity.ok(prod);
//    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getProduto() {
//        List<Produto> listaProd = new ArrayList<>();
//        listaProd.add(new Produto(1L, "Produto1", "Descrição1", 100.10));
//        listaProd.add(new Produto(2L, "Produto2", "Descrição2", 200.20));
//        listaProd.add(new Produto(3L, "Produto3", "Descrição3", 300.30));

//        return ResponseEntity.ok(listaProd);

//        ProdutoResponseDTO dto = ProdutoResponseDTO.createMock();
        List<ProdutoResponseDTO> listaDto = ProdutoResponseDTO.createMock();
        return ResponseEntity.ok(listaDto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto (
            @RequestBody ProdutoRequestDTO requestDTO) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO(1L, requestDTO.getNome(), requestDTO.getDescricao(), requestDTO.getValor());

        return ResponseEntity.created(null).body(dto);
    }

    //test Insomnia -> POST trocar body pra JSON
//    {
//        "nome": "nomeTest",
//            "descricao": "descTest",
//            "valor": 10.10
//    }
}
