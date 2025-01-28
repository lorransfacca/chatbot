import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/incidentes")
public class IncidentController {

    private static final Map<String, String> STATUS_MAP = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(IncidentController.class, args);
        
        STATUS_MAP.put("1", "Aberto");
        STATUS_MAP.put("2", "Em progresso");
        STATUS_MAP.put("3", "Concluído");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarIncidente(@RequestBody IncidentRequest request) {
        if (request.getPrioridade() == null || request.getDescricao() == null) {
            return ResponseEntity.badRequest().body("Prioridade e descrição são obrigatórias.");
        }
        String response = "Incidente com prioridade " + request.getPrioridade() + " criado com sucesso!";
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<String> statusIncidente(@PathVariable String id) {
        String status = STATUS_MAP.get(id);
        if (status == null) {
            return ResponseEntity.status(404).body("Incidente não encontrado.");
        }
        return ResponseEntity.ok("Status do incidente " + id + ": " + status);
    }
}

class IncidentRequest {
    private String prioridade;
    private String descricao;

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}