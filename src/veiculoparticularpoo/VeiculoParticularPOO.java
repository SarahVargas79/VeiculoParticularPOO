/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculoparticularpoo;

import controller.CCarro;
import controller.CProprietario;
import java.util.Scanner;
import model.Carro;
import model.Proprietario;
import util.Validadores;

/**
 *
 * @author 182010049
 */
public class VeiculoParticularPOO {

    /**
     * @param args the command line arguments
     */
    public static CProprietario cadProprietario = new CProprietario();
    public static CCarro cadCarro = new CCarro();
    public static Scanner leia = new Scanner(System.in);

    public static int leiaNumInt() {//Dois scanner para não crachar a aplicação.
        Scanner leiaNum = new Scanner(System.in);
        int num = 99; //valor inválido
        try {//try como um "TENTAR EXECUTAR UM TRECHO DE CÓDIGO", se não executar esse trecho vai se para o cath onde as chamadas exceções (erros) são tratadas, se não ele é ignorado.
            return leiaNum.nextInt();
        } catch (Exception e) {//O bloco try diz "que tal código pode gerar exceção(erro)" e o bloco catch faz o "tratamento  para essa exceção(erro)".
            System.out.println("Tente novamente!");
            leiaNumInt();
        }
        return num;
    }

    public static void menuP() {
        System.out.println("\n.:Veículo Particular:.");
        System.out.println("1 - Adm.Proprietários");
        System.out.println("2 - Adm.Carros");
        System.out.println("0 - sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void subMenu(int op) {
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Proprietário";
                break;
            case 2:
                tpCad = "Carro";
                break;
        }
        System.out.println("\nAdm." + tpCad + ":.");
        System.out.println("1 - Cadastrar" + tpCad);
        System.out.println("2 - Editar" + tpCad);
        System.out.println("3 - Listar" + tpCad + "s");
        System.out.println("4 - Deletar" + tpCad);
        System.out.println("0 - Voltar");
        System.out.print("Digite uma opção: ");
    }

    public static void cadastrarProprietario() {
        int idProprietario;
        String nomeProprietario;
        String sobrenomeProprietario;
        int idade;
        String cpf;
        String endereco;

        System.out.println("-- Cadastro de Proprietário --");
        System.out.print("\nDigite o CPF do proprietário: ");
        boolean cpfIs;
        int opCPF;
        do {
            cpf = leia.nextLine();
            cpfIs = Validadores.isCPF(cpf);
            if (!cpfIs) {
                System.out.println("\nCPF inválido, \nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opCPF = leiaNumInt();
                if (opCPF == 1) {
                    System.out.print("\nDigite o CPF do proprietário: ");
                } else if (opCPF == 2) {
                    System.out.println("\nCadastro cancelado pelo usuário!");
                    break;
                }

            } else if (cadProprietario.getProprietarioCPF(cpf) != null) {
                System.out.println("\nProprietário já cadastrado!");
            } else {
                System.out.print("\nInforme o nome: ");
                nomeProprietario = leia.nextLine();
                System.out.print("\nInforme o sobrenome: ");
                sobrenomeProprietario = leia.nextLine();
                System.out.print("\nInforme a idade: ");
                idade = leiaNumInt();
                System.out.print("\nInforme o endereço: ");
                endereco = leia.nextLine();
                idProprietario = cadProprietario.geraID();
                Proprietario prop = new Proprietario(idProprietario, nomeProprietario, sobrenomeProprietario, idade, cpf, endereco);
                cadProprietario.addProprietario(prop);
                System.out.println("\nProprietario cadastrado com sucesso!");
            }
        } while (!cpfIs);
    }//fim cadastrar proprietário

    private static void editarProprietario() {
        System.out.println("-- Editar Proprietário --");
        System.out.print("\nDigite o CPF do proprietário: ");
        String cpf = leia.nextLine();
        if (Validadores.isCPF(cpf)) {
            Proprietario prop = cadProprietario.getProprietarioCPF(cpf);
            if (prop != null) {
                System.out.println("1 - Nome:\t" + prop.getNomeProprietario());
                System.out.println("2 - Sobrenome:\t" + prop.getSobrenomeProprietario());
                System.out.println("3 - Idade:\t" + prop.getIdade());
                System.out.println("4 - Endereço:\t" + prop.getEndereco());
                System.out.println("5 - Todos os campos acima?");
                System.out.print("\nQual campo deseja alterar? \nDigite aqui sua opção: ");
                int opEditar = leiaNumInt();

                if (opEditar == 1 || opEditar == 5) {// "||" pipe significa "ou"
                    System.out.print("\nInforme o nome: ");
                    prop.setNomeProprietario(leia.nextLine());
                }
                if (opEditar == 2 || opEditar == 5) {
                    System.out.print("\nInforme o sobrenome: ");
                    prop.setSobrenomeProprietario(leia.nextLine());
                }
                if (opEditar == 3 || opEditar == 5) {
                    System.out.print("\nInforme a idade: ");
                    prop.setIdade(leiaNumInt());
                }
                if (opEditar == 4 || opEditar == 5) {
                    System.out.print("\nInforme o endereço: ");
                    prop.setEndereco(leia.nextLine());
                }
                if (opEditar < 1 || opEditar > 5) {
                    System.out.println("\nOpção inexistente");
                }

                System.out.println("\nProprietário:\n" + prop.toString());
            } else {
                System.out.println("\nProprietário não cadastrado!");
            }
        } else {
            System.out.println("\nCPF inválido!");
        }
    }//fim editar proprietário

    public static void imprimirListaProprietarios() {
        System.out.println("-- Lista de Proprietários --");
        for (Proprietario prop : cadProprietario.getProprietarios()) {
            System.out.println("\n---");
            System.out.println("1 - Nome:\t" + prop.getNomeProprietario());//\t faz tabulação
            System.out.println("2 - Sobrenome:\t" + prop.getSobrenomeProprietario());
            System.out.println("3 - Idade:\t" + prop.getIdade());
            System.out.println("4 - Cpf:\t" + prop.getCpf());
            System.out.println("5 - Endereço:\t" + prop.getEndereco());
        }
    }//fim imprimir lista de proprietários

    public static void deletarProprietario() {
        System.out.println("-- Deletar Proprietário --");
        System.out.print("\nDigite o CPF do proprietário: ");
        String cpf = leia.next();
        if (Validadores.isCPF(cpf)) {
            Proprietario prop = cadProprietario.getProprietarioCPF(cpf);
            if (prop != null) {
                cadProprietario.removeProprietario(prop);
                System.out.println("\nProprietário deletado com sucesso!");
            } else {
                System.out.println("\nProprietário não consta na base de dados!");
            }
        } else {
            System.out.println("\nCPF inválido!");
        }
    }//fim deletar proprietário

    private static void registrarCarro() {
        System.out.println("-- Registro de Carro --");
        System.out.print("\nDigite a placa: ");
        String placa;
        boolean placaValidar;
        int opPlaca;
        do {
            placa = leia.nextLine();
            placaValidar = Validadores.validarPlaca(placa);
            if (!placaValidar) {
                System.out.println("\nPlaca inválida, \nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opPlaca = leiaNumInt();

                if (opPlaca == 1) {
                    System.out.print("\nDigite a placa: ");

                } else if (opPlaca == 2) {
                    System.out.println("\nRegistro cancelado pelo usuário!");
                    
                    return;
                }
            } else if (cadCarro.getCarroPlaca(placa) != null) {
                System.out.println("\nCarro já registrado!");
            }
        } while (!placaValidar);
        System.out.print("\nInforme a marca: ");
        String marca = leia.nextLine();
        System.out.print("\nInforme o modelo: ");
        String modelo = leia.nextLine();
        System.out.print("\nInforme o ano: ");
        int ano = leiaNumInt();
        boolean isCPF = false;
        Proprietario idProprietario = null;
        do {
            System.out.print("\nInforme o CPF do proprietário: ");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                idProprietario = cadProprietario.getProprietarioCPF(cpf);
                if (idProprietario == null) {
                    System.out.println("\nProprietário não cadastrado");
                    isCPF = false;
                } else {
                    System.out.println("\nProprietário: " + idProprietario.getNomeProprietario());
                }
            } else {
                System.out.println("\nCPF inválido!");
            }
        } while (!isCPF);

        int dCarro = cadCarro.geraID();
        Carro car = new Carro(dCarro, marca, modelo, ano, placa, idProprietario);
        cadCarro.addCarro(car);
        System.out.println("\nCarro registrado com seucesso!");

    }//fim registro carro

    private static void editarCarro() {
        System.out.println("-- Editar Carro --");
        System.out.print("\nDigite a placa: ");
        String placa = leia.nextLine();
        Carro car = cadCarro.getCarroPlaca(placa);
        if (car != null) {
            System.out.println("1 - Marca: \t" + car.getMarca());
            System.out.println("2 - Modelo:\t" + car.getModelo());
            System.out.println("3 - Ano:    \t" + car.getAno());
            System.out.println("4 - Todos as informações acima? ");
            System.out.print("\nQual informação deseja alterar? \nDigite aqui sua opção: ");
            int opEditar = leiaNumInt();
            if (opEditar == 1 || opEditar == 4) {
                System.out.print("\nInforme a marca: ");
                car.setMarca(leia.nextLine());
            }
            if (opEditar == 2 || opEditar == 4) {
                System.out.print("\nInforme o modelo: ");
                car.setModelo(leia.nextLine());
            }
            if (opEditar == 3 || opEditar == 4) {
                System.out.print("\nInforme o ano: ");
                car.setAno(leiaNumInt());
            }
            if (opEditar < 1 || opEditar > 4) {
                System.out.println("\nOpção inexistente");
            }

            System.out.println("\nProprietário:\n" + car.toString());
        } else {
            System.out.println("\nProprietário não cadastrado!");
        }
    }//fim editar carro

    private static void imprimirListaCarros() {
        System.out.println("-- Lista de Carros --");
        for (Carro car : cadCarro.getCarros()) {
            System.out.println("---\nMarca:\t\t" + car.getMarca());
            System.out.println("Modelo:         \t" + car.getModelo());
            System.out.println("Ano:   \t" + car.getAno());
            System.out.println("Placa:          \t" + car.getPlaca());
            System.out.println("Proprietário:     \t" + car.getIdProprietario().getNomeProprietario());
        }
    }//fim imprimir lista de carros

    private static void removerCarro() {
        System.out.println("-- Remover Carro --");
        System.out.print("\nDigite a placa: ");
        String placa = leia.nextLine();
        Carro car = cadCarro.getCarroPlaca(placa);
        if (car != null) {
            System.out.println("\nConfirmar remover carro? 1 - Sim | 2 - Não");
            cadCarro.removeCarros(car);
            int opRemover = leiaNumInt();
            if (opRemover == 1) {
                System.out.println("\nCarro: " + car.getMarca() + "" + car.getModelo() + "" + car.getPlaca() + " deletado!");
            } else if (opRemover == 2) {
                System.out.println("Usuário cancelou remoção de carro!");
            }
        } else {
            System.out.println("\nPlaca não encontrada!");
        }
    }//fim removerCarro

    public static void main(String[] args) {
        //CProprietario cprop = new CProprietario();
        //Chamando mock. 
        cadProprietario.mockProprietario();
        cadCarro.mockCarros();

        int opM;

        do {
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:

                    int opSM;

                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                System.out.println("\n-- Cadastramento --\n");
                                //usar opM para definir qual cadastro
                                if (opM == 1) {
                                    cadastrarProprietario();
                                } else if (opM == 2) {
                                    registrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println("\n-- Edição --\n");
                                if (opM == 1) {
                                    editarProprietario();
                                } else if (opM == 2) {
                                    editarCarro();
                                }
                                break;
                            case 3:
                                System.out.println("\n-- Lista --\n");
                                if (opM == 1) {
                                    imprimirListaProprietarios();
                                } else if (opM == 2) {
                                    imprimirListaCarros();
                                }
                                break;
                            case 4:
                                System.out.println("\n-- Delete --\n");
                                if (opM == 1) {
                                    deletarProprietario();
                                } else if (opM == 2) {
                                    removerCarro();
                                }
                                break;
                            case 0:
                                System.out.println("\n-- Menu Principal --");
                                break;
                            default:
                                System.out.println("Opção inexistente, tente novamente!");
                                break;
                        }

                    } while (opSM != 0);//subMenu
                    break;
                case 0:
                    System.out.println("\nAplicação encerrada pelo usuário!!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (opM != 0);//fim sistema
    }

}
