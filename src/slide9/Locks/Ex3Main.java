/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
    Teste usando threads que realizam leitura e escrita para essa
    estrutura.
 */

package slide9.Locks;

public class Ex3Main {

    public static void main(String[] args) {
        ArrayListThreadSafe alts = new ArrayListThreadSafe();
        for (int i = 0; i < 2; i++) {
            Leitor leitor = new Leitor(alts);
            leitor.start();
        }
        for (int i = 0; i < 5; i++) {
            Escritor escritor = new Escritor(alts);
            escritor.start();
        }
    }
}
