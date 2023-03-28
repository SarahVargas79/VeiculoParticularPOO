/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Carro;

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

    public void removeLivros(Carro car) {//void uma ação não tem retorno
        this.carros.remove(car);
    }
}
