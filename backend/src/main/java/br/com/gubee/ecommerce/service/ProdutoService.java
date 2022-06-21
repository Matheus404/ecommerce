package br.com.gubee.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gubee.ecommerce.model.Produto;
import br.com.gubee.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto findById(Long id) {
		Optional<Produto> produtoOpt = repository.findById(id);
		return produtoOpt.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id, 
				Produto.class.getName()));
	}
	
	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}
	
	public List<Produto> listarProdutos(){
		return repository.findAll();
	}
	
	public Produto atualizar(Produto produto) {
		Produto aux = findById(produto.getId());
		aux.setNome(produto.getNome());
		aux.setDescricao(produto.getDescricao());
		aux.setMercadoAlvo(produto.getMercadoAlvo());
		aux.setStack(produto.getStack());
		return repository.save(aux);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
}
