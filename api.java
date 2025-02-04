import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Api {
    public static void main(String[] args) {
        Map<String, String[]> prioridadeMap = new HashMap<>();
        prioridadeMap.put("P0", new String[]{"Crítico", "Extenso", "Falha/interrupção do sistema"});
        prioridadeMap.put("P1", new String[]{"Alto", "Grande", "Mau funcionamento do recurso principal"});
        prioridadeMap.put("P2", new String[]{"Moderado", "Moderado", "Mau funcionamento de recursos menores"});
        prioridadeMap.put("P3", new String[]{"Baixo", "Menor", "Funcionalidade ou recurso que impede alguns usuários de usar o produto"});
        prioridadeMap.put("P4", new String[]{"Negligenciável", "Negligenciável", "É bom ter um recurso que poderia ser incluído no produto atual"});

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a prioridade (P0-P4): ");
        String prioridade = scanner.nextLine().toUpperCase();

        if (prioridadeMap.containsKey(prioridade)) {
            String[] dados = prioridadeMap.get(prioridade);
            System.out.println("Prioridade: " + prioridade);
            System.out.println("Nível: " + dados[0]);
            System.out.println("Impacto: " + dados[1]);
            System.out.println("Exemplo: " + dados[2]);
        } else {
            System.out.println("Prioridade inválida!");
        }
        scanner.close();
    }
}
