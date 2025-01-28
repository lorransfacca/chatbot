async function sendMessage() {
    const userInput = document.getElementById('user-input').value.trim();
    if (userInput === "") {
        alert("Por favor, digite uma mensagem.");
        return;
    }

    const chatBox = document.getElementById('chat-box');
    chatBox.innerHTML += `<div class="user-message">${userInput}</div>`;
    chatBox.scrollTop = chatBox.scrollHeight;

    document.getElementById('user-input').value = "";

    try {
        const response = await fetch('http://localhost:5001/classificar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ impacto: userInput })
        });

        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}`);
        }

        const data = await response.json();

        chatBox.innerHTML += `<div class="bot-message">Prioridade: ${data.prioridade}</div>`;
        chatBox.scrollTop = chatBox.scrollHeight;
    } catch (error) {
        console.error('Erro ao enviar a mensagem:', error);
        chatBox.innerHTML += `<div class="bot-message">Desculpe, ocorreu um erro ao processar sua mensagem.</div>`;
        chatBox.scrollTop = chatBox.scrollHeight;
    }
}