package nccsoft.spring.restapi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "taikhoanguitien")
public class TaiKhoanGuiTien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String loai = "Tài khoản gửi tiền";

    @NotBlank
    @Column(name = "sodu")
    private float sodu = 0L;

    @NotBlank
    @Column(name = "laisuat")
    private int laisuat;

    @Column(name = "sodu_toithieu")
    private float sodu_toithieu = 0L;

    @NotBlank
    @Column(name = "khachhang_id")
    private Long khachhang_id;

    @NotBlank
    @Column(name = "nhanvien_id")
    private Long nhanvien_id;


    public Long getId() {
        return id;
    }

    public Long getKhachhang_id() {
        return khachhang_id;
    }

    public Long getNhanvien_id() {
        return nhanvien_id;
    }

    public TaiKhoanGuiTien(){}

    public float getSodu() {
        return sodu;
    }

    public void setSodu(float sodu) {
        this.sodu = sodu;
    }

    public float getSodu_toithieu() {
        return sodu_toithieu;
    }

    public void setSodu_toithieu(float sodu_toithieu) {
        this.sodu_toithieu = sodu_toithieu;
    }
}
