package nccsoft.spring.restapi.entity;

import lombok.Data;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cmt")
    private String cmt;
    @NotBlank
    @Column(name = "ten")
    private String ten;

    @NotBlank
    @Column(name = "ngaysinh")
    private Date ngaysinh;

    @NotBlank
    @Column(name = "diachi")
    private String diachi;

    @NotBlank
    @Column(name = "bacnghe")
    private String bacnghe;

    @Column(name = "thamnien")
    private String thamnien;

    @NotBlank
    @Column(name = "vitri")
    private String vitri;

    @Column
    private float luong = 0;

    @OneToMany(mappedBy = "nv1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaiKhoanGuiTien> taiKhoanGuiTien;

    @OneToMany(mappedBy = "nv2", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaiKhoanTinDung> taiKhoanTinDung;

    public NhanVien(){}

    public NhanVien(Long id, String cmt, @NotBlank String ten, @NotBlank Date ngaysinh, @NotBlank String diachi, @NotBlank String bacnghe, String thamnien, @NotBlank String vitri, float luong, List<TaiKhoanGuiTien> taiKhoanGuiTien, List<TaiKhoanTinDung> taiKhoanTinDung) {
        this.id = id;
        this.cmt = cmt;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.bacnghe = bacnghe;
        this.thamnien = thamnien;
        this.vitri = vitri;
        this.luong = luong;
        this.taiKhoanGuiTien = taiKhoanGuiTien;
        this.taiKhoanTinDung = taiKhoanTinDung;
    }
}