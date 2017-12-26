package com.example.agung.latihan_android1.model;

/**
 * Created by agung on 26/12/17.
 */

public class Matakuliah {
    private DataDosen dosen;
    private MhsProdi prodi;
    private SemesterMhs semester;
    private String nama;
    private int id;

    public DataDosen getDosen() {
        return dosen;
    }

    public MhsProdi getProdi() {
        return prodi;
    }

    public SemesterMhs getSemester() {
        return semester;
    }

    public String getNama() {
        return nama;
    }

    public int getId() {
        return id;
    }
}
