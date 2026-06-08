package dev.java10x.ProjetoDDD;

import dev.java10x.ProjetoDDD.application.CampanhaApplication;
import dev.java10x.ProjetoDDD.domain.Campanha;
import dev.java10x.ProjetoDDD.domain.Usuario;
import dev.java10x.ProjetoDDD.infraestructure.UsuarioRepositoryMemoria;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("=== INICIANDO O SISTEMA CROWDFUNDING (DDD) ===");
        System.out.println("==============================================\n");

        Scanner teclado = new Scanner(System.in);
        UsuarioRepositoryMemoria usuarioRepository = new UsuarioRepositoryMemoria();
        CampanhaApplication campanhaApp = new CampanhaApplication(null);

        Usuario doador = new Usuario("usr-777", "Hakari Kinji");
        usuarioRepository.salvar(doador);
        System.out.println("[SUCESSO] Usuário cadastrado: " + doador.getNome());

        Campanha campanha = new Campanha("camp-01", "Jackpot Infinito", 1000.0);
        System.out.println("[SUCESSO] Campanha criada: '" + campanha.getCampanhaNome() + "' | Meta: R$" + campanha.getObjetivo());

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n-------------------------------------------");
            System.out.println("=== MENU DE DOAÇÕES (FEBRE ATIVA) ===");
            System.out.println("1. Realizar Nova Doação");
            System.out.println("2. Ver Status e Total Arrecadado");
            System.out.println("3. Fechar Sistema");
            System.out.print("Escolha uma opção: ");
            
            int opcao = 0;

            try {
                opcao = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("[ERRO] Digite apenas números válidos!");
                teclado.nextLine(); 
                continue; 
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da doação: R$ ");
                    double valor = 0;
                    
                    try {
                        valor = teclado.nextDouble();
                        doador.realizarDoacao(campanha, valor);
                        System.out.println("[SUCESSO] Doação de R$ " + valor + " realizada por " + doador.getNome() + "!");
                    } catch (Exception e) {
                        System.out.println("[ERRO] Valor inválido! Digite apenas números.");
                        teclado.nextLine(); 
                    }
                    break;

                case 2:
                    System.out.println("\n--- STATUS ATUAL ---");
                    System.out.println("Campanha: " + campanha.getCampanhaNome());
                    System.out.println("Meta de Arrecadação: R$ " + campanha.getObjetivo());
                    System.out.println("Total Arrecadado até agora: R$ " + campanha.getTotalRecebido());
                    System.out.println("A meta foi atingida? " + (campanha.bateuMeta() ? "SIM! JACKPOT! 👑🎰" : "Ainda não."));
                    break;

                case 3:
                    System.out.println("\nSaindo do sistema... Febre encerrada.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida! Escolha de 1 a 3.");
                    break;
            }
        }

        teclado.close();
    }
}
