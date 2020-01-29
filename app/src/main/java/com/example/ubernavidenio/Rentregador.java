package com.example.ubernavidenio;

public class Rentregador {


    String entregadorid, nombree, apellidoe, edade, telefe, correo, cuentae, contrae1,constrae2;

    public Rentregador(String entregadorid, String nombree, String apellidoe, String edade, String telefe, String correo, String cuentae, String contrae1, String constrae2) {
        this.entregadorid = entregadorid;
        this.nombree = nombree;
        this.apellidoe = apellidoe;
        this.edade = edade;
        this.telefe = telefe;
        this.correo = correo;
        this.cuentae = cuentae;
        this.contrae1 = contrae1;
        this.constrae2 = constrae2;
    }

    public String getEntregadorid() {
        return entregadorid;
    }

    public String getNombree() {
        return nombree;
    }

    public String getApellidoe() {
        return apellidoe;
    }

    public String getEdade() {
        return edade;
    }

    public String getTelefe() {
        return telefe;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCuentae() {
        return cuentae;
    }

    public String getContrae1() {
        return contrae1;
    }

    public String getConstrae2() {
        return constrae2;
    }
}
