import controller.BuscaEnderecoCEP;
import controller.GeraArquivoEnderecos;
import controller.MenuPrincipal;
import controller.ValidaCEP;
import model.Endereco;
import model.EnderecoViaCEP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        Scanner r = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
        int op;

        do {
            menu.imprimeMenu();
            op = r.nextInt();
            r.nextLine(); // limpa o buffer

            switch (op) {
                case 1:
                    System.out.println("Digite o CEP que deseja encontrar o endereço: ");
                    String cep = r.nextLine();

                    try {
                        if(new ValidaCEP().isValid(cep)) {
                            EnderecoViaCEP enderecoViaCEP = new BuscaEnderecoCEP().buscaEnderecoCEP(cep);
                            enderecos.add(new Endereco(enderecoViaCEP));
                            System.out.println("Endereço encontrada com sucesso! Adicionado a lista de busca...\n\n");
                        } else {
                            System.out.println("O CEP informado é inválido! Tente novamente...\n\n");
                        }
                    } catch (InterruptedException | IOException e) {
                        System.out.println("Não foi possível obter o endereço a partir do CEP indicado...\n\n");
                    }
                    break;
                case 2:
                    try {
                        GeraArquivoEnderecos gerador = new GeraArquivoEnderecos();
                        gerador.salvaEndereco(enderecos);
                        System.out.println("Arquivo 'enderecos.json' foi GERADO com sucesso!\n\n");
                    } catch (IOException e) {
                        System.out.println("Não foi possível criar e gravar o endereço no arquivo!\n\n");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Opção Inválida! Digite uma opção válida...\n\n");
                    break;
            }
        } while(op != 0);
    }
}