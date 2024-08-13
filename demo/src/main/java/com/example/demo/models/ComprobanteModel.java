package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Comprobante")
public class ComprobanteModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="tipo_de_moneda")
    private String tipoDeMoneda;

    @OneToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn (name="id_registro",nullable=false)
    private RegistroModel registro;

    @OneToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="id_dato_empresa",nullable=false)
    private DatosEmpresaModel datosempresas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeMoneda() {
        return tipoDeMoneda;
    }

    public void setTipoDeMoneda(String tipoDeMoneda) {
        this.tipoDeMoneda = tipoDeMoneda;
    }

    public RegistroModel getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroModel registro) {
        this.registro = registro;
    }

    public DatosEmpresaModel getDatosempresas() {
        return datosempresas;
    }

    public void setDatosempresas(DatosEmpresaModel datosempresas) {
        this.datosempresas = datosempresas;
    }

   


    
}
