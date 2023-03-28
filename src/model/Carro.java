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
public class Carro {
    private int idCarro;
    private String marca;
    private String modelo; 
    private int ano;
    private int placa;
    private Proprietario idProprietario;

    public Carro() {
    }

    public Carro(int idCarro, String marca, String modelo, int ano, int placa, Proprietario idProprietario) {
        this.idCarro = idCarro;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.idProprietario = idProprietario;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public Proprietario getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Proprietario idProprietario) {
        this.idProprietario = idProprietario;
    }

    @Override
    public String toString() {
        return "Carro{" + "idCarro=" + idCarro + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", placa=" + placa + ", idProprietario=" + idProprietario + '}';
    }
    
    
}
