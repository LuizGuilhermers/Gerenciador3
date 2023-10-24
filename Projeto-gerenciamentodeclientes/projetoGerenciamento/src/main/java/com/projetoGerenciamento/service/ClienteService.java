package com.projetoGerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoGerenciamento.entities.Cliente;
import com.projetoGerenciamento.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService (ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> buscaTodosClientes () {
		return clienteRepository.findAll ();
	}
	
	public Cliente buscaClienteld (Long id) {
	Optional <Cliente> Cliente = clienteRepository.findById(id); 
	return Cliente.orElse(null);
	}

	public Cliente salvaCliente (Cliente cliente) 
	{
		return clienteRepository.save(cliente);
	}
	
	public Cliente alterarCliente (Long id, Cliente alterarC) {
		Optional <Cliente> existeCliente = clienteRepository.findById(id);
		if(existeCliente.isPresent()) {
			alterarC.setId(id);
			return clienteRepository.save(alterarC);
		}
		
		return null;
	}
		
		public boolean apagarCliente (Long id) {
			Optional <Cliente> existeCliente = clienteRepository.findById(id);
			if (existeCliente.isPresent()) {
				clienteRepository.deleteById(id);
				return true;
			}
			return false;
		
	}
	

}
