package nccsoft.spring.restapi.Service;

import nccsoft.spring.restapi.Repository.NhanVienRepository;
import nccsoft.spring.restapi.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    NhanVienRepository nhanVienRepository;

    public List<NhanVien> findAll() {
        List<NhanVien> list = nhanVienRepository.findAll();
        return list;
    }
    public void add(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }
    public void deleteById(Long id){
        nhanVienRepository.deleteById(id);
    }
    public Optional<NhanVien> findById(Long id){
        return nhanVienRepository.findById(id);
    }
    public void save(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

}
