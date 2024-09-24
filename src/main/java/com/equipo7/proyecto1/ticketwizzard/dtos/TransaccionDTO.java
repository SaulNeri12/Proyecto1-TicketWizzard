
package com.equipo7.proyecto1.ticketwizzard.dtos;

import com.equipo7.proyecto1.ticketwizzard.objetos.*;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Equipo 7
 */
public class TransaccionDTO {
    // columna: id_transaccion
    private Integer id;
    // columna: id_comprador
    private Integer idComprador;
    // columna: id_vendedor
    private Integer idVendedor;
    // columna: monto
    private Float monto;
    // columna: fecha_hora
    private Timestamp fechaHora;
    // columna: tipo
    private String tipoTransaccion;
    
    private List<Boleto> boletos;
    
    public TransaccionDTO() {
        
    }

    
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the idComprador
     */
    public Integer getIdComprador() {
        return idComprador;
    }

    /**
     * @param idComprador the idComprador to set
     */
    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    /**
     * @return the idVendedor
     */
    public Integer getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the monto
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Float monto) {
        this.monto = monto;
    }

    /**
     * @return the fechaHora
     */
    public Timestamp getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }



    /**
     * @return the boletos
     */
    public List<Boleto> getBoletos() {
        return boletos;
    }

    /**
     * @param boletos the boletos to set
     */
    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    /**
     * @return the tipoTransaccion
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * @param tipoTransaccion the tipoTransaccion to set
     */
    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
}
