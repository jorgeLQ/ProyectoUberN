package com.example.ubernavidenio;

public class RTarjeta {
    String cv;
    String ntarjeta;
    String fexpira;
    String tipotarjeta;

    public RTarjeta(String cv, String ntarjeta, String fexpira, String tipotarjeta) {
        this.cv=cv;
        this.ntarjeta=ntarjeta;
        this.fexpira=fexpira;
        this.tipotarjeta=tipotarjeta;
    }
    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv=cv;
    }

    public String getNtarjeta() {
        return ntarjeta;
    }

    public void setNtarjeta(String ntarjeta) {
        this.ntarjeta=ntarjeta;
    }

    public String getFexpira() {
        return fexpira;
    }

    public void setFexpira(String fexpira) {
        this.fexpira=fexpira;
    }

    public String getTipotarjeta() {
        return tipotarjeta;
    }

    public void setTipotarjeta(String tipotarjeta) {
        this.tipotarjeta=tipotarjeta;
    }


}
