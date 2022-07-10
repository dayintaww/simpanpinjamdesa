package com.spd.simpanpinjamdesa.controller;

import com.spd.simpanpinjamdesa.model.Anggota;
import com.spd.simpanpinjamdesa.model.Transaksi;
import com.spd.simpanpinjamdesa.service.AnggotaService;
import com.spd.simpanpinjamdesa.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class SimpanPinjamController {
    @Autowired
    AnggotaService anggotaService;

    @Autowired
    TransaksiService transaksiService;

    //1. get all anggota
    @RequestMapping(value="/getAllAnggota", method = RequestMethod.GET)
    @ResponseBody
    public List<Anggota> getAllAnggota() {
        return anggotaService.getAnggota();
    }

    //2. add anggota
    @RequestMapping(value="/addAnggota", method = RequestMethod.POST)
    @ResponseBody
    public String createAnggota(@RequestParam("namaAnggota") String namaAnggota,
                                @RequestParam("alamat") String alamat,
                                @RequestParam("tanggalLahir(YYYY-MM-DD)") String tanggalLahir){

        String output = null;
        try {
            anggotaService.createAnggota(namaAnggota, alamat, tanggalLahir);
            output = "SUKSES menambahkan anggota";
        } catch (Exception e) {
            output = "GAGAL menambahkan anggota";
            e.printStackTrace();
        }
        return output;
    }

    //3. Tambah Data Transaksi
    @RequestMapping(value="/addTransaksi", method = RequestMethod.POST)
    @ResponseBody
    public String createTransaksi(@RequestParam("idAnggota") int idAnggota,
                                @RequestParam("jenisTransaksi") String jenisTransaksi,
                                @RequestParam("jumlahTransaksi") int jumlahTransaksi) {

        return transaksiService.createTransaksi(idAnggota, jenisTransaksi, jumlahTransaksi);
    }

    //4. Melihat data transaksi by date
    @RequestMapping(value="/getDataTransaksiByDate", method = RequestMethod.GET)
    @ResponseBody
    public List<Transaksi> getDataTrsansaksiByIdAnggota(@RequestParam("tanggalAwal") String tanggalAwal,
                                                        @RequestParam("tanggalAkhir") String tanggalAkhir) {
        return transaksiService.getTransaksiByDate(tanggalAwal, tanggalAkhir);
    }

    //5. Melihat data transaksi by id anggota
    @RequestMapping(value="/getDataTransaksiByIdAnggota", method = RequestMethod.GET)
    @ResponseBody
    public List<Transaksi> getDataTrsansaksiByIdAnggota(@RequestParam("idAnggota") String idAnggota) {
        return transaksiService.getTransaksiByIdAnggota(idAnggota);
    }
}
