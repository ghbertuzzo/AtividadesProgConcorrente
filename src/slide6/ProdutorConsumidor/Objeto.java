/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    1. Atividade: Implemente uma solução para o problema do
    Produtor-Consumidor
 */

package slide6.ProdutorConsumidor;

public class Objeto {

    public String buffer;

    public Objeto(String buffer) {
        this.buffer = buffer;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

}
