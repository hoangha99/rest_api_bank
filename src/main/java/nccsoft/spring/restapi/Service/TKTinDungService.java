package nccsoft.spring.restapi.Service;

import nccsoft.spring.restapi.Repository.TKGuiTienRepository;
import nccsoft.spring.restapi.Repository.TKTinDungRepository;
import nccsoft.spring.restapi.entity.TaiKhoanGuiTien;
import nccsoft.spring.restapi.entity.TaiKhoanTinDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TKTinDungService {
    @Autowired
    TKTinDungRepository tkTinDungRepository;

    public List<TaiKhoanTinDung> findAll() {
        List<TaiKhoanTinDung> list = tkTinDungRepository.findAll();
        return list;
    }

    public void add(TaiKhoanTinDung taiKhoanTinDung){
        tkTinDungRepository.save(taiKhoanTinDung);
    }
    public void deleteById(Long id){
        tkTinDungRepository.deleteById(id);
    }
    public Optional<TaiKhoanTinDung> findById(Long id){
        return tkTinDungRepository.findById(id);
    }
    public void save(TaiKhoanTinDung taiKhoanTinDung){
        tkTinDungRepository.save(taiKhoanTinDung);
    }
}
