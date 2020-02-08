package com.example.ubernavidenio.test;

import com.example.ubernavidenio.RTarjeta;

import org.junit.Test;

import static org.junit.Assert.*;

public class registrar_targeta_view_controlerTest {

    @Test
    public void onCreate() {
    }

    @Test
    public void registrarTarjeta() {
        RTarjeta obj = new RTarjeta("4356","1234567812345678","12/12/22","visa");
    }
}