package nccsoft.spring.restapi.Service;

import nccsoft.spring.restapi.Repository.KhachHangRepository;
import nccsoft.spring.restapi.entity.KhachHang;
import nccsoft.spring.restapi.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;

    public List<KhachHang> findAll() {
        List<KhachHang> list = khachHangRepository.findAll();
        return list;
    }
    public void add(KhachHang khachHang){
        khachHangRepository.save(khachHang);
    }
    public void deleteById(Long id){
        khachHangRepository.deleteById(id);
    }
    public Optional<KhachHang> findById(Long id){
        return khachHangRepository.findById(id);
    }
    public void save(KhachHang khachHang){
        khachHangRepository.save(khachHang);
    }
}
