package com.spd.simpanpinjamdesa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aktivitass")
@Setter
@Getter
public class Aktivitas {
    @Id
    @Column(name = "id_aktivitas")
    private String idAktivitas;
    @Column(name = "aktivitas_deskripsi")
    private String aktivitasDeskripsi;
}
