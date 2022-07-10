package com.spd.simpanpinjamdesa.dao;

import com.spd.simpanpinjamdesa.model.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AnggotaDao extends JpaRepository<Anggota, String> {

    @Modifying
    @Query(value = "INSERT INTO public.anggota(id_anggota, nama_anggota, alamat, tanggal_lahir) VALUES (?, ?, ?, ?)", nativeQuery = true)
    public int insertAnggota(int id_anggota, String namaAnggota, String alamat, Date tanggalLahir);

    @Query(value = "SELECT id_anggota FROM public.anggota order by id_anggota desc LIMIT 1", nativeQuery = true)
    public int getIdAnggota();
}
