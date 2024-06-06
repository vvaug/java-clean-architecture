package br.com.alura.codechella.naousar.controller;

import br.com.alura.codechella.naousar.model.Usuario;
import br.com.alura.codechella.naousar.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    /*
    Por exemplo, a classe que deveria ser o nosso domínio, que é a classe Usuario, está completamente vinculada ao tipo de persistência.
    Clicando em " Usuario" do lado esquerdo, observamos que ela possui anotações como @Document, o tipo do ID. Portanto, está completamente vinculada ao banco de dados.
    Se quiséssemos trocar ou testar o nosso domínio, como faríamos esse teste com essa entidade? Portanto, precisamos modificar isso.
    O primeiro ponto é como desacoplar isso. O mesmo ocorre com outras classes, como o UsuarioController, por exemplo. Estamos cheios de anotações do Spring, então também estamos vinculados ao framework.
    Se quiséssemos trocar agora, não temos código Java puro para trocar de um framework A para um framework B. E é isso que vamos começar a fazer agora.
    */

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder) {
        service.cadastrarUsuario(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

}
