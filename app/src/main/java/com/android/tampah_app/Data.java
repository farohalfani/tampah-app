package com.android.tampah_app;

import java.util.Date;

/**
 * Created by Faroh Nur Alfani on 02-May-17.
 */



public class Data {
    public static Date[] startDate2 = new Date[] {null, null, null, null, null, null};
    public static Date[] endDate2 = new Date[] {null, null, null, null, null, null};
    public static String[] namaBrg = {"Dispenser","Toaster","Ceramic Set", "Toples", "Microwave", "Kompor"};
    public int[] hargaBrg = {30000,25000,15000, 10000, 25000, 15000};
    public int[] gambarBrg = {R.drawable.sample_0,R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_4,R.drawable.sample_5};
    public static String[] deskripsiBrg = {"Sudah teruji di laboratoriun ITB dan IPB", "Dapat digunakan untuk memanggang roti sehari-hari. Kualitas oke punya.", "Lengkap dengan 10 cangkir. Desain elegan"
            , "Tidak mudah pecah. Jarang dipakai.", "Hemat listrik. Praktis.", "Mudah dibawa. Mudah digunakan" };

    private static int position;

    private static int countdate;

    public Data() {

    }

    public static int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
