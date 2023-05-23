package com.example.ap2_dac.beans;

import com.example.ap2_dac.daos.IncidenteDAO;
import com.example.ap2_dac.entities.Agressor;
import com.example.ap2_dac.entities.Incidente;
import com.example.ap2_dac.entities.Vitima;
import com.example.ap2_dac.util.MessagesUtil;

import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebServlet;

@ManagedBean
@WebServlet(name = "incidenteBean", urlPatterns = "/incidente")
public class IncidenteBean {
    Vitima vitima = new Vitima();
    Agressor agressor = new Agressor();
    Incidente incidente = new Incidente();

    public String save() {
        try {
            incidente.setAgressor(agressor);
            incidente.setVitima(vitima);
            IncidenteDAO.save(incidente);
            MessagesUtil.successMessage("Incidente cadastrado com sucesso.");
            Thread.sleep(5000);
            return "lista_incidentes?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            MessagesUtil.errorMessage("Erro ao cadastrar incidente. Stacktrace:" +  e.getMessage());
            return null;
        }
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

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }
}
