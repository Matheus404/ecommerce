package br.com.gubee.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gubee.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public Optional<Produto> findByNome(String nome);
	
}
