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
    @Size(min=3, max = 50)
    @Column(name = "ten")
    private String ten;
    @Column(name = "ngaysinh")
    private Date ngaysinh;
    @Column(name = "diachi")
    private String diachi;
    public KhachHang(){}


    public KhachHang(Long id, String cmt, @NotBlank @Size(min = 3, max = 50) String ten, @NotBlank Date ngaysinh, @NotBlank String diachi) {
        this.id = id;
        this.cmt = cmt;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }

    public Long getId() {
        return id;
    }
}
