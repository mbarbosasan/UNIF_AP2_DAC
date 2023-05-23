package com.example.ap2_dac.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Incidente {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vitima vitima;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Agressor agressor;
    @Column(nullable = false)
    private String descricaoIncidente;
    @ElementCollection
    @CollectionTable(name = "tipo_violacao", joinColumns = @JoinColumn(name = "incidente_id"))
    @Column(name = "tipo")
    private List<String> tipoViolacao;
    @Column
    private String providenciasTomadas;

    public Incidente() {
    }

    public Vitima getVitima() {
        return vitima;
    }

    public void setVitima(Vitima vitima) {
        this.vitima = vitima;
    }

    public Agressor getAgressor() {
        return agressor;
    }

    public void setAgressor(Agressor agressor) {
        this.agressor = agressor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoIncidente() {
        return descricaoIncidente;
    }

    public void setDescricaoIncidente(String descricaoIncidente) {
        this.descricaoIncidente = descricaoIncidente;
    }

    public List<String> getTipoViolacao() {
        return tipoViolacao;
    }

    public void setTipoViolacao(List<String> tipoViolacao) {
        this.tipoViolacao = tipoViolacao;
    }

    public String getProvidenciasTomadas() {
        return providenciasTomadas;
    }

    public void setProvidenciasTomadas(String providenciasTomadas) {
        this.providenciasTomadas = providenciasTomadas;
    }
}
