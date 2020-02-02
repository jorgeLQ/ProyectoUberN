package com.example.ubernavidenio;

public class Rcliente {

    String idcleinte, UNamecl,Contrasenacl, CContrasenacl, Nombrecl, Apellidocl, Emailcl, CBancariacl, M , FNacimientocl,Direccionclid;

    public Rcliente(String idcleinte, String UNamecl, String contrasenacl, String CContrasenacl, String nombrecl, String apellidocl, String emailcl, String CBancariacl, String m, String FNacimientocl, String direccionclid) {
        this.idcleinte = idcleinte;
        this.UNamecl = UNamecl;
        this.Contrasenacl = contrasenacl;
        this.CContrasenacl = CContrasenacl;
        this.Nombrecl = nombrecl;
        this.Apellidocl = apellidocl;
        this.Emailcl = emailcl;
        this.CBancariacl = CBancariacl;
        M = m;
        this.FNacimientocl = FNacimientocl;
        this.Direccionclid = direccionclid;
    }

    public String getIdcleinte() {
        return idcleinte;
    }

    public String getUNamecl() {
        return UNamecl;
    }

    public String getContrasenacl() {
        return Contrasenacl;
    }

    public String getCContrasenacl() {
        return CContrasenacl;
    }

    public String getNombrecl() {
        return Nombrecl;
    }

    public String getApellidocl() {
        return Apellidocl;
    }

    public String getEmailcl() {
        return Emailcl;
    }

    public String getCBancariacl() {
        return CBancariacl;
    }

    public String getM() {
        return M;
    }

    public String getFNacimientocl() {
        return FNacimientocl;
    }

    public String getDireccionclid() {
        return Direccionclid;
    }
}
