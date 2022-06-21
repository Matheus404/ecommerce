package br.com.gubee.ecommerce.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


import br.com.gubee.ecommerce.enumerations.MercadoAlvo;
import br.com.gubee.ecommerce.enumerations.Stack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name="Produto")
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@ElementCollection(targetClass = MercadoAlvo.class)
	@CollectionTable(name = "mercado_alvo", joinColumns = @JoinColumn(name = "produto_id"))
	@Enumerated(EnumType.STRING)
	private List<MercadoAlvo> mercadoAlvo;
	
	@ElementCollection(targetClass = Stack.class)
	@CollectionTable(name = "stack", joinColumns = @JoinColumn(name = "produto_id"))
	@Enumerated(EnumType.STRING)
	private List<Stack> stack;
	
	
}
