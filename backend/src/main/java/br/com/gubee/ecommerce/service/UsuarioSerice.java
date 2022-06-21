package br.com.gubee.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gubee.ecommerce.model.UsuarioModel;
import br.com.gubee.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioSerice {
	
	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioModel findById(Long id) {
		Optional<UsuarioModel> userImdbOptional = repository.findById(id);
		return userImdbOptional.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id, 
				UsuarioModel.class.getName()));
	}
	
	public List<UsuarioModel> listarTodos() {
		return repository.findAll();
	}
	
	public UsuarioModel salvar(UsuarioModel userImdb) {
		return repository.save(userImdb);
	}
	
}
