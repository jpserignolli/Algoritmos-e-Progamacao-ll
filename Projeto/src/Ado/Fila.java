/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ado;
import java.util.ArrayList;

/**
 *
 * @author joao.psborin
 */
public class Fila {

    ArrayList<Musicas> vetor = new ArrayList<Musicas>();
    private int primeiro;
    private int ultimo;
    private int total;
    public Object listarMusicas;

    public Fila() {
        primeiro = 0;
        ultimo = 0;
        total = 0;
    }

    public void inserir(String nome,String Artista,float tempo) {
        Musicas m = new Musicas(nome,Artista,tempo);
        vetor.add(m);
        ultimo = (ultimo + 1) % vetor.size();
        total++;
    }

    public Musicas retirar() {
        String nome = vetor.get(primeiro).getNome();
        String artista = vetor.get(primeiro).getArtista();
        float  tempo = vetor.get(primeiro).getTempo();
        Musicas m = new Musicas(nome,artista,tempo);
        primeiro = (primeiro + 1) % vetor.size();
        total--;
        return m;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total == vetor.size();
    }
    
    public void ordenarMusicas() {        
        for (int i = 0; i < vetor.size() - 1; i++) {
            for (int j = 0; j < vetor.size() - i - 1; j++) {
                if (vetor.get(j).getNome().compareTo(vetor.get(j + 1).getNome()) > 0) {
                    Musicas aux = vetor.get(j);
                    vetor.set(j, vetor.get(j + 1));
                    vetor.set(j + 1, aux);                    
                }
            }
        }
    }

    
    public Musicas pesquisaBinaria(String nome){
        int inicio = 0;
        int fim = vetor.size() - 1;
        while(inicio <= fim){
            int meio = (inicio + fim) / 2;
            int comparacao = vetor.get(meio).getNome().compareTo(nome);
            if(comparacao == 0){
                return vetor.get(meio);
            }else if (comparacao < 0){
                inicio = meio + 1;
            }else{
                fim = meio -1;
            }
        }
        return null;
    }
    
    public void listarMusicas(){
        for(Musicas musica : vetor){
            System.out.println("Nome da música: " + musica.getNome() +
                    "\nNome do Artista: " + musica.getArtista() +
                    "\nTempo de música: " + musica.getTempo() + " minutos" + "\n");
        }
    }
    public boolean removerMusica(String nome){
        for(int i = 0; i < vetor.size(); i++){
            if(vetor.get(i).getNome().equals(nome)){
                vetor.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean musicaRegistrada(String nome, String artista) {
        for (Musicas musica : vetor) {
            if (musica.getNome().equals(nome) && musica.getArtista().equals(artista)) {
                return true;
            }
        }
        return false;
    }
}
    
