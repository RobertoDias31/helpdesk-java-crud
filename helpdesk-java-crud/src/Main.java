import entidades.Chamado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Chamado> chamados = new ArrayList<>();
        int contadorId = 1;

        int opcao;

        do {
            System.out.println("""
                    \n
                    1- Criar chamado
                    2- Consultar chamado
                    3- Excluir chamado
                    4- Editar chamado
                    5 - Finalizar chamado
                    6 - sair
                    \n
                    """);

            System.out.println("Escolha uma das opções: ");
            opcao = entrada.nextInt();

            switch (opcao){
                case 1:
                    entrada.nextLine();
                    System.out.println("Faça um breve resumo sobre o chamado: ");
                    String desc = entrada.nextLine();
                    Chamado novoChamado = new Chamado(contadorId++, desc);
                    chamados.add(novoChamado);
                    System.out.println("Chamado Criado!");
                    break;

                case 2:
                    if (chamados.isEmpty()){
                        System.out.println("Não há chamados");
                    }else{
                        chamados.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID dso chamado para excluir: ");
                    int idExcluir = entrada.nextInt();
                    chamados.removeIf(c-> c.getId() == idExcluir);
                    System.out.println("Chamado removido (se existia).");
                    break;

                case 4:
                    System.out.print("Digite o ID para editar: ");
                    int idEditar = entrada.nextInt();
                    entrada.nextLine();

                    for (Chamado c : chamados) {
                        if (c.getId() == idEditar) {
                            System.out.print("Nova descrição: ");
                            c.setDescricao(entrada.nextLine());
                            System.out.println("Atualizado!");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Digite o ID para finalizar: ");
                    int idFinalizar = entrada.nextInt();

                    chamados.removeIf(c -> c.getId() == idFinalizar);

                    System.out.println("Chamado finalizado!");
                    break;

                case 6:
                    System.out.println("Saindo!");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 6);
    }
}
