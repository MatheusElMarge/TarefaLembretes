package lembretes.demo.repository;

import lembretes.demo.entitys.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByNome(String nome);
}