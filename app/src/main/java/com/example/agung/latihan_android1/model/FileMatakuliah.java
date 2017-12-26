package com.example.agung.latihan_android1.model;

/**
 * Created by agung on 26/12/17.
 */

public class FileMatakuliah {
    private Matakuliah matkul_id;
    private int id;
    private String name;

    public Matakuliah getMatkul_id() {
        return matkul_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Matakuliah {
        private int dosen;
        private int prodi;
        private int semester;
        private String nama;
        private int id;

        public int getDosen() {
            return dosen;
        }

        public int getProdi() {
            return prodi;
        }

        public int getSemester() {
            return semester;
        }

        public String getNama() {
            return nama;
        }

        public int getId() {
            return id;
        }
    }
}
