package pt.com.raliugasoftware.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.raliugasoftware.api.model.Produtos;


public interface ProdutosRepository extends JpaRepository<Produtos, Integer>{
	Produtos findById(int id);

}