from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.route('/classificar', methods=['POST'])
def classificar():
    data = request.json

    impacto = data.get('impacto', '').lower()
    if impacto not in ['alto', 'médio', 'baixo']:
        return jsonify({'erro': 'Impacto inválido. Use alto, médio ou baixo.'}), 400

    if impacto == 'alto':
        prioridade = 'P1'
    elif impacto == 'médio':
        prioridade = 'P2'
    else:
        prioridade = 'P3'

    return jsonify({'prioridade': prioridade})

if __name__ == "__main__":
    app.run(port=5001)