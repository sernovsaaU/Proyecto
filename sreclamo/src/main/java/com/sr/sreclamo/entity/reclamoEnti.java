package com.sr.sreclamo.entity;

import com.sr.sreclamo.model.tipo_fruta;
import com.sr.sreclamo.model.reclamo;

public class reclamoEnti {

    private tipo_fruta Fru;
    private reclamo Rrec;

    
    public reclamoEnti() {
    }
    public reclamoEnti(tipo_fruta fru, reclamo rrec) {
        Fru = fru;
        Rrec = rrec;
    }
    public tipo_fruta getFru() {
        return Fru;
    }
    public void setFru(tipo_fruta fru) {
        Fru = fru;
    }
    public reclamo getRrec() {
        return Rrec;
    }
    public void setRrec(reclamo rrec) {
        Rrec = rrec;
    }

    

    
}
