package com.spd.simpanpinjamdesa.service;

import com.spd.simpanpinjamdesa.dao.TransaksiDao;
import com.spd.simpanpinjamdesa.model.Transaksi;
import com.spd.simpanpinjamdesa.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TransaksiService {

    @Autowired
    TransaksiDao transaksiDao;

    private static final String[] KODE_AKTIVITAS = {"str", "trk", "pnjm", "kbl"};
    private static final String TRANSAKSI_BERHASIL = "Tranksaksi BERHASIL";
    private static final String TRANSAKSI_TIDAK_TERSEDIA = "Jenis transaksi tidak tersedia.";
    private static final String GAGAL_TARIK = "Transaksi GAGAL! Saldo tidak cukup.";
    private static final String GAGAL_KEMBALI = "Transaksi GAGAL! Jumlah transaksi melebihi jumlah pinjaman.";

    public List<Transaksi> getTransaksiByIdAnggota(String id) {
        int number = 0;
        try{
            number = Integer.parseInt(id);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return transaksiDao.findByIdAnggota(number);
    }

    public String createTransaksi(int idAnggota, String jenisTransaksi, int jumlahTransaksi) {
        Timestamp currentTimestamp = DateUtil.getCurrentTimestamp();
        String result= "";
        List<Transaksi> transaksiList = new ArrayList<>();
        transaksiList = transaksiDao.findByIdAnggota(idAnggota);
        Transaksi transaksi = new Transaksi();
        transaksi = transaksiList.get(0);
        String idAktivitas = "";
        if (jenisTransaksi.equalsIgnoreCase("setor")) {
            idAktivitas = KODE_AKTIVITAS[0];
        } else if (jenisTransaksi.equalsIgnoreCase("tarik")) {
            idAktivitas = KODE_AKTIVITAS[1];
        } else if (jenisTransaksi.equalsIgnoreCase("pinjam")) {
            idAktivitas = KODE_AKTIVITAS[2];
        } else if (jenisTransaksi.equalsIgnoreCase("kembali")) {
            idAktivitas = KODE_AKTIVITAS[3];
        }

        if (!(Arrays.asList(KODE_AKTIVITAS).contains(idAktivitas))) {
            result = TRANSAKSI_TIDAK_TERSEDIA;
        } else {
            int saldo = transaksi.getSaldo();
            int pinjaman = transaksi.getPinjaman();
            if (idAktivitas.equalsIgnoreCase(KODE_AKTIVITAS[0])) {
                proceedInsert(idAnggota, idAktivitas, currentTimestamp, jumlahTransaksi, saldo +jumlahTransaksi, pinjaman);
                result = TRANSAKSI_BERHASIL;
            } else if (idAktivitas.equalsIgnoreCase(KODE_AKTIVITAS[1])) {
                if (saldo > jumlahTransaksi) {
                    proceedInsert(idAnggota, idAktivitas, currentTimestamp, jumlahTransaksi, saldo -jumlahTransaksi, pinjaman);
                    result = TRANSAKSI_BERHASIL;
                } else {
                    result = GAGAL_TARIK;
                }
            } else if (idAktivitas.equalsIgnoreCase(KODE_AKTIVITAS[2])) {
                proceedInsert(idAnggota, idAktivitas, currentTimestamp, jumlahTransaksi, saldo, pinjaman +jumlahTransaksi);
                result = TRANSAKSI_BERHASIL;
            } else if (idAktivitas.equalsIgnoreCase(KODE_AKTIVITAS[3])) {
                if (pinjaman != 0 && pinjaman >= jumlahTransaksi) {
                    proceedInsert(idAnggota, idAktivitas, currentTimestamp, jumlahTransaksi, saldo, pinjaman -jumlahTransaksi);
                    result = TRANSAKSI_BERHASIL;
                } else {
                    result = GAGAL_KEMBALI;
                }
            }
        }

        return result;
    }

    public List<Transaksi> getTransaksiByDate(String tanggalAwal, String tanggalAkhir) {
        return transaksiDao.findByDate(DateUtil.stringToDate(tanggalAwal), DateUtil.stringToDate(tanggalAkhir));
    }

    private String getIdTransaksi(int idAnggota, String idAktivitas, Date tanggalTransaksi) {
        return Integer.toString(idAnggota)+idAktivitas+DateUtil.dateToString(tanggalTransaksi);
    }

    private int proceedInsert(int idAnggota, String idAktivitas, Date tanggalTransaksi, int jumlahTransaksi, int jumlahSaldo, int jumlahPinjaman) {
        int result = 0;
        try {
            transaksiDao.insertTransaksi(getIdTransaksi(idAnggota, idAktivitas, tanggalTransaksi), idAnggota, idAktivitas, tanggalTransaksi, jumlahTransaksi, jumlahSaldo, jumlahPinjaman);
            result = 1;
        } catch (Exception e) {
            result = 0;
            e.printStackTrace();
        }
        return result;
    }
}
