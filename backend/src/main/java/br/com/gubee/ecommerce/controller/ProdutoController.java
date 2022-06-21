package br.com.gubee.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gubee.ecommerce.model.Produto;
import br.com.gubee.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(service.listarProdutos());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return ResponseEntity.ok(service.salvar(produto));
    }
    
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
    	return ResponseEntity.ok(service.atualizar(produto));
    }
    
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
    	try {
    		service.deletar(id);
        	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>("Produto não encontrado!", HttpStatus.NOT_FOUND);
		}
    	
    }
	
}
