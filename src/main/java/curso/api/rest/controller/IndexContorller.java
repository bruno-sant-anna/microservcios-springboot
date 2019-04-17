package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexContorller {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable (value = "id") Long id
										,@PathVariable (value = "venda") Long venda) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id); 
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable (value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id); 
		
		return new ResponseEntity(usuario.get(), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/", produces = "application/json")	
	public ResponseEntity<List<Usuario>> usuarios(){
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		Usuario novoCadastro = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(novoCadastro, HttpStatus.OK);
		
	}
	
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		
		Usuario novoCadastro = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(novoCadastro, HttpStatus.OK);
		
	}
	

	@PostMapping(value = "/{idusuario}/vendausuario/{idvenda}", produces = "application/json")
	public ResponseEntity venda(@PathVariable Long idusuario,
									@PathVariable Long idvenda){
		
//		Usuario novoCadastro = usuarioRepository.save(usuario);
		
		return new ResponseEntity("id usuario :" + idusuario + " id venda :" + idvenda, HttpStatus.OK);
		
	}

	
	
}
