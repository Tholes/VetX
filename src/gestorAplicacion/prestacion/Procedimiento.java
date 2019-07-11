package gestorAplicacion.prestacion;

import java.util.Date;

public class Procedimiento {
    private String nombreProcedimiento;
    private int idProcedimento;
    private int valor;
    private Date fechaProcedimiento;

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getFechaProcedimiento() {
        return fechaProcedimiento;
    }

    public void setFechaProcedimiento(Date fechaProcedimiento) {
        this.fechaProcedimiento = fechaProcedimiento;
    }
}
