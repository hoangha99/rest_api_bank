package nccsoft.spring.restapi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Data
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "cmt")
    private String cmt;
    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "ten")
    private String ten;
    @NotBlank
    @Column(name = "ngaysinh")
    private Date ngaysinh;
    @NotBlank
    @Column(name = "diachi")
    private String diachi;
    public KhachHang(){}

    @OneToOne(mappedBy = "kh1",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TaiKhoanGuiTien taiKhoanGuiTien;

    @OneToOne(mappedBy = "kh2", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TaiKhoanTinDung taiKhoanTinDung;

    public KhachHang(Long id, String cmt, @NotBlank @Size(min = 3, max = 50) String ten, @NotBlank Date ngaysinh, @NotBlank String diachi, TaiKhoanGuiTien taiKhoanGuiTien, TaiKhoanTinDung taiKhoanTinDung) {
        this.id = id;
        this.cmt = cmt;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.taiKhoanGuiTien = taiKhoanGuiTien;
        this.taiKhoanTinDung = taiKhoanTinDung;
    }

    public Long getId() {
        return id;
    }
}
