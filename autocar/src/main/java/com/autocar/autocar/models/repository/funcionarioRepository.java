package com.autocar.autocar.models.repository;
import com.autocar.autocar.models.entity.funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface funcionarioRepository extends JpaRepository<funcionario, Integer>{

    @Query(value = "SELECT *FROM funcionario WHERE nome = :nome AND senha = :senha", nativeQuery = true)
    funcionario FindByNomeAndSenha(String nome, String senha);
    
}
