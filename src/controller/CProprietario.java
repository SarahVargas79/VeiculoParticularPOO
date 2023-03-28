/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Proprietario;

/**
 *
 * @author 182010049
 */
public class CProprietario {

    ArrayList<Proprietario> proprietarios = new ArrayList<>();
    int idProprietario = 1;

    /**
     * geraID gerencia a gereção de id's autoincrement para proprietario.
     *
     * @return
     */
    public int geraID() {//Autoincremetou o id que já está em 1.
        return this.idProprietario++;
    }

    /**
     * addProprietario adiciona um proprietario na lista proprietarios.
     *
     * @param p
     */
    public void addProprietario(Proprietario p) {
        this.proprietarios.add(p);
    }

    /**
     * getProprietarios retorna a lista de proprietarios.
     *
     * @return
     */
    public ArrayList<Proprietario> getProprietarios() {//ArrayList tipa (int, string.)
        return this.proprietarios;//This faz referência a propria classe...
    }

    /**
     * removeProprietario remove Proprietario da lista de proprietarios.
     *
     * @param p
     */
    public void removeProprietario(Proprietario p) {//void uma ação não tem retorno
        this.proprietarios.remove(p);
    }

    /**
     * mockClientes inicializa aplicação com proprietarios.
     */
    public void mockProprietario() {
        Proprietario p1 = new Proprietario();
        p1.setIdProprietario(this.geraID());
        p1.setNomeProprietario("Lucas");
        p1.setSobrenomeProprietario("Santos Braga");
        p1.setIdade(20);
        p1.setCpf("79786685091");
        p1.setEndereco("Rua Duque de Caxias");
        this.addProprietario(p1);

        Proprietario p2 = new Proprietario();
        p2.setIdProprietario(this.geraID());
        p2.setNomeProprietario("Lívia");
        p2.setSobrenomeProprietario("Andrade Morais");
        p2.setIdade(24);
        p2.setCpf("80188950079");
        p2.setEndereco("Rua Osvaldo Pereira");
        this.addProprietario(p2);
    }

    /**
     * getProprietarioCPF pesquisa proprietario pelo CPF e retorna o cliente e
     * caso não encontre retorna nulo podendo cadastrar.
     *
     * @param cpf
     * @return
     */
    public Proprietario getProprietarioCPF(String cpf) { //Método para chamar um Proprietario específico.
        Proprietario p = null; //Inicializa como nulo.
        for (Proprietario proprietario : proprietarios) {
            if (proprietario.getCpf().equals(cpf)) {
                p = proprietario;
                break;
            }
        }//Percorre a lista de proprietarios e comparar os valores se o cpf é igual ao que está na lista.

        return p;
    }
    
}


