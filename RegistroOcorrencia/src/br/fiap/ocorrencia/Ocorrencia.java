/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fiap.ocorrencia;

/**
 *
 * @author soonicz
 */
public class Ocorrencia {

    private int chamado;
    private String lab;
    private String comp;
    private String problema;

    public Ocorrencia(int chamado, String lab, String comp, String problema) {
        this.chamado = chamado;
        this.lab = lab;
        this.comp = comp;
        this.problema = problema;
    }

    public int getChamado() {
        return chamado;
    }

    public String getLab() {
        return lab;
    }

    public String getComp() {
        return comp;
    }

    public String getProblema() {
        return problema;
    }

    public void setChamado(int chamado) {
        this.chamado = chamado;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

}
