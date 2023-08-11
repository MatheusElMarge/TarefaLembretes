package lembretes.demo.controllers;

import lembretes.demo.entitys.Lembrete;
import lembretes.demo.services.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {
    @Autowired
    private LembreteService lembreteService;

    @GetMapping
    public List<Lembrete> getAllLembretes() {
        return lembreteService.getAllLembretes();
    }

    @PostMapping
    public Lembrete createLembrete(@RequestBody Lembrete lembrete) {
        return lembreteService.createLembrete(lembrete);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lembrete> getLembreteById(@PathVariable Long id) {
        Lembrete lembrete = lembreteService.getLembreteById(id);
        if (lembrete != null) {
            return ResponseEntity.ok(lembrete);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lembrete> updateLembrete(@PathVariable Long id, @RequestBody Lembrete lembrete) {
        Lembrete updatedLembrete = lembreteService.updateLembrete(id, lembrete);
        if (updatedLembrete != null) {
            return ResponseEntity.ok(updatedLembrete);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLembrete(@PathVariable Long id) {
        lembreteService.deleteLembrete(id);
        return ResponseEntity.noContent().build();
    }
}