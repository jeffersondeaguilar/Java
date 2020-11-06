package pt.com.raliugasoftware.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pt.com.raliugasoftware.api.model.Produtos;
import pt.com.raliugasoftware.api.repository.ProdutosRepository;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutosResource {
	
	@Autowired
	ProdutosRepository produtosRepository;
	
	@GetMapping("/produto")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produtos> listaPilotos(){
		return produtosRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um produto")
	public void listaPiloto(@PathVariable(value ="id") Integer id) {
		produtosRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Insere um produto na lista de produtos")
	public Produtos insereProduto(@RequestBody Produtos produtos) {
		return produtosRepository.save(produtos);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um roduto da lista de produtos")
	public void deletaProduto(@RequestBody Produtos produtos) {
		produtosRepository.delete(produtos);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza um produto na  lista de produtos")
	public Produtos atualizaProduto(@RequestBody Produtos produtos) {
		return produtosRepository.save(produtos);
	}

}
