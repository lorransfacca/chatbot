function getPriorityInfo(priority) {
    const priorities = {
        'P0': { nivel: 'Crítico', urgencia: 'Extenso', impacto: 'Falha/interrupção do sistema', solucao: 'Restaurar o sistema imediatamente' },
        'P1': { nivel: 'Alto', urgencia: 'Grande', impacto: 'Mau funcionamento do recurso principal', solucao: 'Corrigir o recurso principal o mais rápido possível' },
        'P2': { nivel: 'Moderado', urgencia: 'Moderado', impacto: 'Mau funcionamento de recursos menores', solucao: 'Agendar correção em breve' },
        'P3': { nivel: 'Baixo', urgencia: 'Menor', impacto: 'Funcionalidade ou recurso que impede alguns usuários de usar o produto', solucao: 'Corrigir na próxima atualização' },
        'P4': { nivel: 'Negligenciável', urgencia: 'Negligenciável', impacto: 'É bom ter um recurso que poderia ser incluído no produto atual', solucao: 'Considerar para futuras versões' }
    };
    return priorities[priority] || { nivel: 'Desconhecido', urgencia: 'Desconhecido', impacto: 'Prioridade não reconhecida', solucao: 'Nenhuma solução disponível' };
}

document.getElementById('send-button').addEventListener('click', function() {
    const userInput = document.getElementById('user-input').value.toUpperCase();
    const info = getPriorityInfo(userInput);
    const chatBox = document.getElementById('chat-box');
    
    chatBox.innerHTML += `<div class='user-message'>${userInput}</div>`;
    chatBox.innerHTML += `<div class='bot-message'>
        <p><strong>Nível:</strong> ${info.nivel}</p>
        <p><strong>Urgência:</strong> ${info.urgencia}</p>
        <p><strong>Impacto:</strong> ${info.impacto}</p>
        <p><strong>Solução:</strong> ${info.solucao}</p>
    </div>`;
    
    document.getElementById('user-input').value = '';
});
