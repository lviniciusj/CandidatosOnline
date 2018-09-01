package com.lviniciusj.br.candidatosonline.api;

import java.io.Serializable;
import java.util.List;

public class Candidato implements Serializable {

    private Long id;

    private String foto;

    private String nome;

    private String partido;

    private String propostas;

    private String site;

    private String detalhes;

    private Double totalVotos;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getPartido() {
        return partido;
    }
    public void setPartido(String partido) {
        this.partido = partido;
    }


    public String getPropostas() {
        return propostas;
    }
    public void setPropostas(String propostas) {
        this.propostas = propostas;
    }



    public String getDetalhes() {
        return detalhes;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }



    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }



    public Double getTotalVotos() {
        return totalVotos;
    }
    public void setTotalVotos(Double totalVotos) {
        this.totalVotos = totalVotos;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", foto='" + foto + '\'' +
                ", nome='" + nome + '\'' +
                ", partido='" + partido + '\'' +
                ", propostas=" + propostas +
                ", detalhes='" + detalhes + '\'' +
                ", totalVotos=" + totalVotos +
                ", site='" + site + '\'' +
                '}';
    }
}