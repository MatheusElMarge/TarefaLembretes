package lembretes.demo.services;

import lembretes.demo.entitys.Lembrete;
import lembretes.demo.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRepository;

    public List<Lembrete> getAllLembretes() {
        return lembreteRepository.findAll();
    }

    public Lembrete createLembrete(Lembrete lembrete) {
        return lembreteRepository.save(lembrete);
    }

    public Lembrete getLembreteById(Long id) {
        return lembreteRepository.findById(id).orElse(null);
    }

    public Lembrete updateLembrete(Long id, Lembrete lembrete) {
        lembrete.setId(id);
        return lembreteRepository.save(lembrete);
    }

    public void deleteLembrete(Long id) {
        lembreteRepository.deleteById(id);
    }
}