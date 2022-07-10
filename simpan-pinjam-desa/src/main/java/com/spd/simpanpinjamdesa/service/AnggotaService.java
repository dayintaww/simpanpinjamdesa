package com.spd.simpanpinjamdesa.service;

import com.spd.simpanpinjamdesa.dao.AnggotaDao;
import com.spd.simpanpinjamdesa.model.Anggota;
import com.spd.simpanpinjamdesa.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class AnggotaService {

    @Autowired
    AnggotaDao anggotaDao;

    public List<Anggota> getAnggota() {
        return anggotaDao.findAll();
    }

    public int createAnggota(String namaAnggota, String alamat, String tanggalLahir) {
        int result=0;
        anggotaDao.insertAnggota(getIdAnggota(), namaAnggota, alamat, DateUtil.stringToDate(tanggalLahir));
        return result;
    }

    private int getIdAnggota() {
        System.out.println("HERE: "+anggotaDao.getIdAnggota());
        int number = anggotaDao.getIdAnggota();
        return number+1;
    }
}
