package br.com.alura.codechella.naousar.repository;

import br.com.alura.codechella.naousar.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
