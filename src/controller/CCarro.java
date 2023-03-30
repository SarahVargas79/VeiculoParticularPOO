/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Carro;
import veiculoparticularpoo.VeiculoParticularPOO;

/**
 *
 * @author 182010049
 */
public class CCarro {

    ArrayList<Carro> carros = new ArrayList<>();
    int idCarro = 1;

    public int geraID() {
        return this.idCarro++;
    }

    public void addCarro(Carro car) {
        this.carros.add(car);
    }

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }

    public void removeCarros(Carro car) {//void uma ação não tem retorno
        this.carros.remove(car);
    }
    
    public void mockCarros() {
       
        Carro car1 = new Carro();
        car1.setIdCarro(this.geraID());
        car1.setMarca("Lamborghini");
        car1.setModelo("Urus");
        car1.setAno(2022);
        car1.setPlaca("JNL5P36");
        car1.setIdProprietario(VeiculoParticularPOO.cadProprietario.getProprietarioCPF("80188950079"));//espera um objeto editora - chamar construtor
        this.addCarro(car1);
        
        Carro car2 = new Carro();
        car2.setIdCarro(this.geraID());
        car2.setMarca("CAOA Chery");
        car2.setModelo("Tiggo 8");
        car2.setAno(2023);
        car2.setPlaca("XQJ1P23");
        car2.setIdProprietario(VeiculoParticularPOO.cadProprietario.getProprietarioCPF("79786685091"));//espera um objeto editora - chamar construtor
        this.addCarro(car2);
    }

    /**
     * getCarroPlaca pesquisa carro pela placa e retorna o carro e caso não
     * encontre retorna nulo podendo cadastrar.
     *
     * @param placa
     * @return
     */
    public Carro getCarroPlaca(String placa) {
        Carro car = null; //Inicializa como nulo.
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                car = carro;
                break;
            }
        }//Percorre a lista de carros e compara os valores se a placa é igual ao que está na lista.

        return car;
    }
}
