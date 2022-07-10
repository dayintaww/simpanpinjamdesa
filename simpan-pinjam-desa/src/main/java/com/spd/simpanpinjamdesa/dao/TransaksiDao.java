package com.spd.simpanpinjamdesa.dao;

import com.spd.simpanpinjamdesa.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransaksiDao extends JpaRepository<Transaksi, String> {

    @Modifying
    @Query(value = "INSERT INTO public.transaksi(id_transaksi, id_anggota, id_aktivitas, tanggal_transaksi, jumlah_transaksi, saldo, pinjaman) VALUES (?, ?, ?, ?, ?, ?, ?)",
            nativeQuery = true)
    public int insertTransaksi(String idTransaksi, int idAnggota, String idAktivitas, Date tanggalTransaksi, int jumlahTransaksi, int saldo, int sign);

    @Query(value = "SELECT * FROM public.transaksi t where t.id_anggota = :idAnggota order by t.tanggal_transaksi desc",
            nativeQuery = true)
    public List<Transaksi> findByIdAnggota(@Param("idAnggota") int idAnggota);

    @Query(value = "SELECT * FROM public.transaksi t where t.tanggal_transaksi between :tanggalAwal and :tanggalAkhir",
            nativeQuery = true)
    public List<Transaksi> findByDate(@Param("tanggalAwal") Date tanggalAwal, @Param("tanggalAkhir") Date tanggalAkhir);

}
