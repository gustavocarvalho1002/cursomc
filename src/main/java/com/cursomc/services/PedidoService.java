package com.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Pedido;
import com.cursomc.repositories.PedidoRepository;
import com.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		// return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
