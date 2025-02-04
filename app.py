prioridade_map = {
    "P0": {"nivel": "Crítico", "impacto": "Extenso", "exemplo": "Falha/interrupção do sistema"},
    "P1": {"nivel": "Alto", "impacto": "Grande", "exemplo": "Mau funcionamento do recurso principal"},
    "P2": {"nivel": "Moderado", "impacto": "Moderado", "exemplo": "Mau funcionamento de recursos menores"},
    "P3": {"nivel": "Baixo", "impacto": "Menor", "exemplo": "Funcionalidade ou recurso que impede alguns usuários de usar o produto"},
    "P4": {"nivel": "Negligenciável", "impacto": "Negligenciável", "exemplo": "É bom ter um recurso que poderia ser incluído no produto atual"}
}

def obter_prioridade(prioridade):
    p = prioridade_map.get(prioridade.upper())
    if p:
        return f"Prioridade: {prioridade}\nNível: {p['nivel']}\nImpacto: {p['impacto']}\nExemplo: {p['exemplo']}"
    return "Prioridade inválida!"


print(obter_prioridade("P1"))
