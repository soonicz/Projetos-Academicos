/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fiap.laboratorio;

/**
 *
 * @author soonicz
 */
public class Laboratorio {

    private int codigo;
    private String lab;

    public Laboratorio(int codigo, String lab) {
        this.codigo = codigo;
        this.lab = lab;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getLab() {
        return lab;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

}
