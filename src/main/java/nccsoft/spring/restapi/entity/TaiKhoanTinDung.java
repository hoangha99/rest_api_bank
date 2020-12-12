package nccsoft.spring.restapi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@Table(name = "taikhoantindung")
public class TaiKhoanTinDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String loai = "Tài khoản tín dụng";
    @NotBlank
    @Column
    private Long sodu;

    @Column
    private Date hanSD;

    @OneToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang kh2;

    @ManyToOne
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nv2;

    public TaiKhoanTinDung(Long id, String loai, @NotBlank Long sodu, Date hanSD, KhachHang kh2, NhanVien nv2) {
        this.id = id;
        this.loai = loai;
        this.sodu = sodu;
        this.hanSD = hanSD;
        this.kh2 = kh2;
        this.nv2 = nv2;
    }

    public TaiKhoanTinDung(){}
}
