import json
from flask import Flask, jsonify, request, abort
import Client

app = Flask(__name__)

json_clients = []
for client in Client.clients:
    json_clients.append(client.to_dict())

@app.route('/clientes', methods=['GET'])
def returnClientes():
    if request.method == 'GET':
        return jsonify(json_clients)


@app.route('/cliente/<int:codigo>', methods=['GET'])
def returnClient(codigo):
    if request.method == 'GET':
        for cliente in json_clients:
            if cliente['codigo'] == (codigo):
                return jsonify(cliente)
        abort(404)

@app.route('/cliente', methods=['POST'])
def addClient():
    if (request.headers.get('Content-Type')=='application/json'):
        client = request.json
        json_clients.append(client)
        return "OK"
    else:
        abort(400, 'No valido')

if __name__ == '__main__':
    app.run(debug=True)