package com.spd.simpanpinjamdesa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaksi")
@Setter
@Getter
public class Transaksi {
    @Id
    @Column(name = "id_transaksi")
    private String idTransaksi;
    @Column(name = "id_anggota")
    private int  idAnggota;
    @Column(name = "id_aktivitas")
    private String idAktivitas;
    @Column(name = "tanggal_transaksi")
    private Date tanggalTransaksi;
    @Column(name = "jumlah_transaksi")
    private int jumlahTransaksi;
    @Column(name = "saldo")
    private int saldo;
    @Column(name = "pinjaman")
    private int pinjaman;
}
