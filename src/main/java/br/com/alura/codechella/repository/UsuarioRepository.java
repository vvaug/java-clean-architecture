package br.com.alura.codechella.repository;

import br.com.alura.codechella.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
