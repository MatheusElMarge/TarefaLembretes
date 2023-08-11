package lembretes.demo.controllers;

import lembretes.demo.entitys.Lembrete;
import lembretes.demo.entitys.Pessoa;
import lembretes.demo.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    @PostMapping
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.createPessoa(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.getPessoaById(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa updatedPessoa = pessoaService.updatePessoa(id, pessoa);
        if (updatedPessoa != null) {
            return ResponseEntity.ok(updatedPessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{nome}/lembretes")
    public ResponseEntity<List<Lembrete>> getLembretesByNomePessoa(@PathVariable String nome) {
        List<Lembrete> lembretes = pessoaService.getLembretesByNomePessoa(nome);
        if (lembretes != null) {
            return ResponseEntity.ok(lembretes);
        }
        return ResponseEntity.notFound().build();
    }
}