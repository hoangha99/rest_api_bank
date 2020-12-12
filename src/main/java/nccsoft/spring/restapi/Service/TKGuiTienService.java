package nccsoft.spring.restapi.Service;

import nccsoft.spring.restapi.Repository.KhachHangRepository;
import nccsoft.spring.restapi.Repository.TKGuiTienRepository;
import nccsoft.spring.restapi.entity.KhachHang;
import nccsoft.spring.restapi.entity.TaiKhoanGuiTien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TKGuiTienService {
    @Autowired
    TKGuiTienRepository tkGuiTienRepository;

    public List<TaiKhoanGuiTien> findAll() {
        List<TaiKhoanGuiTien> list = tkGuiTienRepository.findAll();
        return list;
    }

    public void add(TaiKhoanGuiTien taiKhoanGuiTien){
        tkGuiTienRepository.save(taiKhoanGuiTien);
    }
    public void deleteById(Long id){
        tkGuiTienRepository.deleteById(id);
    }
    public Optional<TaiKhoanGuiTien> findById(Long id){
        return tkGuiTienRepository.findById(id);
    }
    public void save(TaiKhoanGuiTien taiKhoanGuiTien){
        tkGuiTienRepository.save(taiKhoanGuiTien);
    }
}
