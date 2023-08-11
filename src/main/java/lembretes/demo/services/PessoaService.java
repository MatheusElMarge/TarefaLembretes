package lembretes.demo.services;

import lembretes.demo.entitys.Lembrete;
import lembretes.demo.entitys.Pessoa;
import lembretes.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa getPessoaById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa updatePessoa(Long id, Pessoa pessoa) {
        pessoa.setId(id);
        return pessoaRepository.save(pessoa);
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public List<Lembrete> getLembretesByNomePessoa(String nome) {
        Pessoa pessoa = pessoaRepository.findByNome(nome);
        if (pessoa != null) {
            return pessoa.getLembretes();
        }
        return null;
    }
}