package hocjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "NHANVIEN")
public class nhanvien {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    public nhanvien(int id, String TENNHANVIEN, String TUOI) {
        this.id = id;
        this.TENNHANVIEN = TENNHANVIEN;
        this.TUOI = TUOI;
    }

    private String TENNHANVIEN;
    private String TUOI;

    public nhanvien() {

    }

    public int getId() {
        return id;
    }

    public String getTENNHANVIEN() {
        return TENNHANVIEN;
    }

    public String getTUOI() {
        return TUOI;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTENNHANVIEN(String TENNHANVIEN) {
        this.TENNHANVIEN = TENNHANVIEN;
    }

    public void setTUOI(String TUOI) {
        this.TUOI = TUOI;
    }
}
