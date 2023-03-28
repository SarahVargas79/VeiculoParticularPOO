/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 182010049
 */
public class Proprietario {
    private int idProprietario;
    private String nomeProprietario;
    private String sobrenomeProprietario;
    private int idade;
    private String cpf;
    private String endereco;

    public Proprietario() {
    }

    public Proprietario(int idProprietario, String nomeProprietario, String sobrenomeProprietario, int idade, String cpf, String endereco) {
        this.idProprietario = idProprietario;
        this.nomeProprietario = nomeProprietario;
        this.sobrenomeProprietario = sobrenomeProprietario;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getSobrenomeProprietario() {
        return sobrenomeProprietario;
    }

    public void setSobrenomeProprietario(String sobrenomeProprietario) {
        this.sobrenomeProprietario = sobrenomeProprietario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Proprietario{" + "idProprietario=" + idProprietario + ", nomeProprietario=" + nomeProprietario + ", sobrenomeProprietario=" + sobrenomeProprietario + ", idade=" + idade + ", cpf=" + cpf + ", endereco=" + endereco + '}';
    }
    
    
}
