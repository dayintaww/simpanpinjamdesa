package com.spd.simpanpinjamdesa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "anggota")
@Setter
@Getter
public class Anggota {
    @Id
    @Column(name = "id_anggota")
    private String idAnggota;
    @Column(name = "nama_anggota")
    private String namaAnggota;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;
}
