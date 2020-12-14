package nccsoft.spring.restapi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Data
@Table(name = "taikhoantindung")
public class TaiKhoanTinDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String loai = "Tài khoản tín dụng";

    @Column
    private float sodu=0;

    @Column
    private Date hansd;

    @JoinColumn(name = "khachhang_id")
    private Long khachhang_id;

    @Column(name = "nhanvien_id")
    private Long nhanvien_id;

    public TaiKhoanTinDung(Long id, String loai, float sodu, Date hansd, Long khachhang_id, Long nhanvien_id) {
        this.id = id;
        this.loai = loai;
        this.sodu = sodu;
        this.hansd = hansd;
        this.khachhang_id = khachhang_id;
        this.nhanvien_id = nhanvien_id;
    }

    public Long getId() {
        return id;
    }

    public Long getKhachhang_id() {
        return khachhang_id;
    }

    public Long getNhanvien_id() {
        return nhanvien_id;
    }

    public void setSodu(float sodu) {
        this.sodu = sodu;
    }

    public float getSodu() {
        return sodu;
    }

    public TaiKhoanTinDung(){}
}
