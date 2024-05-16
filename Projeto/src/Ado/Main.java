/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ado;

import java.util.Scanner;

/**
 *
 * @author joao.psborin
 */
public class Main {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Fila f = new Fila();
        int r;
        do {
            System.out.println("Digite o nome da música: ");
            String nome = input.nextLine();
            System.out.println("Digite o nome do artista: ");
            String artista = input.nextLine();
            System.out.println("Digite a duração da música: ");
            float tempo = input.nextFloat();
            
            
            f.inserir(nome,artista,tempo);
            System.out.println("Deseja cadastra mais uma música ?" + "\n1) Sim" + "\n2) Não");
            r = input.nextInt();
            
        } while (r == 1);
        
        f.ordenarMusicas();
        
        int opcao = 0;
        do {
            System.out.println("1) Pesquisar uma música");
            System.out.println("2) Remover uma música");
            System.out.println("3) Listar todas as músicas");
            System.out.println("4) Sair");
            opcao = input.nextInt();
            input.nextLine();
            
            switch(opcao){
                case 1:
                    System.out.println("Digite o nome da música que deseja pesquisar: ");
                    String nomeP = input.nextLine();
                    Musicas encontrou = f.pesquisaBinaria(nomeP);
                    if(encontrou != null){
                        System.out.println("Música encontrada: " + encontrou.getNome() +
                                                           " - " + encontrou.getArtista() +
                                                            " - " + encontrou.getTempo() + " minutos");
                    }else {
                        System.out.println("Música não encontrada");
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome da música que deseja remover");
                    String remover = input.nextLine();
                    if(f.removerMusica(remover)){
                        System.out.println("Música Removida: " + remover);
                    }else {
                        System.out.println("Música não encontrada" + remover);
                    }
                    break;
                case 3:
                    f.listarMusicas();
                    break;
                case 4:
                    System.out.println("");
                    break;
                default:
                    System.out.println("opção inválida..");
            }
        } while (opcao != 4);
    }    
}

