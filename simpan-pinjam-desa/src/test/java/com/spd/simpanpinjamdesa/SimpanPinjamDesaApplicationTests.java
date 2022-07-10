package com.spd.simpanpinjamdesa;

import com.spd.simpanpinjamdesa.controller.SimpanPinjamController;
import com.spd.simpanpinjamdesa.model.Anggota;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class SimpanPinjamDesaApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    private SimpanPinjamController simpanPinjamController;
    @Test
    public void getAllAnggota() throws Exception {
        Anggota anggota = new Anggota();
        anggota.setIdAnggota("1");
        anggota.setNamaAnggota("Nama Anggota");

        List<Anggota> anggotaList = Collections.singletonList(anggota);

        Mockito.when(simpanPinjamController.getAllAnggota()).thenReturn(anggotaList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllAnggota")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is(anggota.getIdAnggota())));

    }
}
