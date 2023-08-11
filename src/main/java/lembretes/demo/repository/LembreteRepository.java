package lembretes.demo.repository;

import lembretes.demo.entitys.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
    List<Lembrete> findByPessoaNome(String nome);
}
