package com.sr.sreclamo.entity;

import com.sr.sreclamo.model.tipo_fruta;
import com.sr.sreclamo.model.cliente;
import com.sr.sreclamo.model.estado;
import com.sr.sreclamo.model.marca;
import com.sr.sreclamo.model.producto;
import com.sr.sreclamo.model.reclamo;

public class reclamoEnti {
    
    private reclamo Rrec;
    private tipo_fruta Fru;
    private cliente Cli;
    private estado Est;
    private producto Pro;
    private marca Mar;

    
   
    public reclamoEnti() {
    }
    public reclamoEnti(reclamo rrec, tipo_fruta fru, cliente cli, estado est, producto pro, marca mar) {
        Rrec = rrec;
        Fru = fru;
        Cli = cli;
        Est = est;
        Pro = pro;
        Mar = mar;
    }
    
    public reclamo getRrec() {
        return Rrec;
    }
    public void setRrec(reclamo rrec) {
        Rrec = rrec;
    }

    public tipo_fruta getFru() {
        return Fru;
    }
    public void setFru(tipo_fruta fru) {
        Fru = fru;
    }

    public cliente getCli() {
        return Cli;
    }
    public void setCli(cliente cli) {
        Cli = cli;
    }
    public estado getEst() {
        return Est;
    }
    public void setEst(estado est) {
        Est = est;
    }

    public producto getPro() {
        return Pro;
    }
    public void setPro(producto pro) {
        Pro = pro;
    }
    
    public marca getMar() {
        return Mar;
    }
    public void setMar(marca mar) {
        Mar = mar;
    }
    
    
}
