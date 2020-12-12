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
    private String loai;

    @NotBlank
    @Column(name = "sodu")
    private Long sodu;

    @NotBlank
    @Column(name = "laisuat")
    private int laisuat;

    @Column(name = "sodu_toithieu")
    private String sodu_toithieu;

    @OneToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang kh1;

    @ManyToOne
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nv1;

    public TaiKhoanGuiTien(Long id, String loai, @NotBlank Long sodu, @NotBlank int laisuat, String sodu_toithieu, KhachHang kh1, NhanVien nv1) {
        this.id = id;
        this.loai = loai;
        this.sodu = sodu;
        this.laisuat = laisuat;
        this.sodu_toithieu = sodu_toithieu;
        this.kh1 = kh1;
        this.nv1 = nv1;
    }

    public TaiKhoanGuiTien(){}

}
