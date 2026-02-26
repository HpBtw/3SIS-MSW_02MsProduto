package com.github.hpbtw.ms_produto.controller;

import com.github.hpbtw.ms_produto.dto.ProdutoDto;
import com.github.hpbtw.ms_produto.entities.Produto;
import com.github.hpbtw.ms_produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService prodService;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> getAllProdutos() {
        List<ProdutoDto> list = prodService.findAllProdutos();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> getProdutoById(@PathVariable Long id) {
        ProdutoDto prodDto = prodService.findProdutoById(id);

        return ResponseEntity.ok(prodDto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> createProduto(@RequestBody @Valid ProdutoDto prodDto) {
        prodDto = prodService.saveProduto(prodDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{ìd}")
                .buildAndExpand(prodDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(prodDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> updateProduto(@PathVariable Long id,
                                                    @RequestBody ProdutoDto prodDto) {
        prodDto = prodService.updateProduto(id, prodDto);

        return ResponseEntity.ok(prodDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDto> deleteProduto(@PathVariable Long id) {
        prodService.deleteProdutoById(id);

        return ResponseEntity.noContent().build();
    }





//
////    @GetMapping
////    public ResponseEntity<Produto> getProduto() {
////        Produto prod = new Produto(1L, "Nome", "Descrição", 100.50);
////
////        return ResponseEntity.ok(prod);
////    }
//
//    @GetMapping
//    public ResponseEntity<List<ProdutoResponseDTO>> getProduto() {
////        List<Produto> listaProd = new ArrayList<>();
////        listaProd.add(new Produto(1L, "Produto1", "Descrição1", 100.10));
////        listaProd.add(new Produto(2L, "Produto2", "Descrição2", 200.20));
////        listaProd.add(new Produto(3L, "Produto3", "Descrição3", 300.30));
//
////        return ResponseEntity.ok(listaProd);
//
////        ProdutoResponseDTO dto = ProdutoResponseDTO.createMock();
//        List<ProdutoResponseDTO> listaDto = ProdutoResponseDTO.createMock();
//        return ResponseEntity.ok(listaDto);
//    }
//
//    @PostMapping
//    public ResponseEntity<ProdutoResponseDTO> createProduto (
//            @RequestBody ProdutoRequestDTO requestDTO) {
//        ProdutoResponseDTO dto = new ProdutoResponseDTO(1L, requestDTO.getNome(), requestDTO.getDescricao(), requestDTO.getValor());
//
//        return ResponseEntity.created(null).body(dto);
//    }
//
//    //test Insomnia -> POST trocar body pra JSON
////    {
////        "nome": "nomeTest",
////            "descricao": "descTest",
////            "valor": 10.10
////    }
}
