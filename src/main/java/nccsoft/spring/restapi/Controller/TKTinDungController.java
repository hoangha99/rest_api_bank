package nccsoft.spring.restapi.Controller;

import nccsoft.spring.restapi.Service.KhachHangService;
import nccsoft.spring.restapi.Service.NhanVienService;
import nccsoft.spring.restapi.Service.TKTinDungService;
import nccsoft.spring.restapi.entity.KhachHang;
import nccsoft.spring.restapi.entity.NhanVien;
import nccsoft.spring.restapi.entity.TaiKhoanTinDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tktindung")
public class TKTinDungController {
    @Autowired
    TKTinDungService tkTinDungService;

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    NhanVienService nhanVienService;


    @GetMapping("/all")
    public String showList(Model model){
        List<TaiKhoanTinDung> taiKhoanTinDung = tkTinDungService.findAll();
        model.addAttribute("taiKhoanTinDung", taiKhoanTinDung);
        return "TKTinDung/showList";
    }

    @GetMapping("/add")
    public String add(Model model) {
        TaiKhoanTinDung taiKhoanTinDung = new TaiKhoanTinDung();
        model.addAttribute("taiKhoanTinDung", taiKhoanTinDung);
        return "TKTinDung/add";
    }

    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("taiKhoanTinDung") TaiKhoanTinDung taiKhoanTinDung) {
        Optional<NhanVien> nhanVien = nhanVienService.findById(taiKhoanTinDung.getNhanvien_id());
        Optional<KhachHang> khachHang = khachHangService.findById(taiKhoanTinDung.getKhachhang_id());
        if(nhanVien.isPresent()&&khachHang.isPresent())
        {
            nhanVien.get().setLuong(500000+nhanVien.get().getLuong());
            tkTinDungService.add(taiKhoanTinDung);
            return "TKTinDung/addSuccess";
        }


        return "TKTinDung/error";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("id") Long id, Model model) {
        Optional<TaiKhoanTinDung> taiKhoanTinDung = tkTinDungService.findById(id);
        if (taiKhoanTinDung.isPresent()) {
            model.addAttribute("taiKhoanTinDung", taiKhoanTinDung.get());
        }
        return "TKTinDung/update";
    }
    @PostMapping("/doUpdate")
    public String doUpdate(@ModelAttribute("taiKhoanTinDung") TaiKhoanTinDung taiKhoanTinDung) {
        Optional<NhanVien> nhanVien = nhanVienService.findById(taiKhoanTinDung.getNhanvien_id());
        Optional<KhachHang> khachHang = khachHangService.findById(taiKhoanTinDung.getKhachhang_id());
        if(nhanVien.isPresent()&&khachHang.isPresent())
        {
            tkTinDungService.save(taiKhoanTinDung);
            return "TKTinDung/updateSuccess";

        }
        return "TKTinDung/error";
    }

    @GetMapping("/delete")
    public String doDelete(@ModelAttribute("id") Long id){
        tkTinDungService.deleteById(id);
        return "TKTinDung/deleteSuccess";
    }

    @GetMapping("/pay")
    public String pay(@ModelAttribute("id") Long id, Model model){
        Optional<TaiKhoanTinDung> taiKhoanTinDung = tkTinDungService.findById(id);
        if (taiKhoanTinDung.isPresent()) {
            model.addAttribute("taiKhoanTinDung", taiKhoanTinDung.get());
        }
        return "TKTinDung/pay";
    }
    @PostMapping("/doPay")
    public String doPay(@ModelAttribute("id") Long id, @ModelAttribute("sotien") Long sotien){
        Optional<TaiKhoanTinDung> taiKhoanTinDung = tkTinDungService.findById(id);
        if(taiKhoanTinDung.get().getSodu()- sotien>0){
            taiKhoanTinDung.get().setSodu(taiKhoanTinDung.get().getSodu()- sotien);
            tkTinDungService.save(taiKhoanTinDung.get());
            return "TKTinDung/paySuccess";
        }

        return "payError";
    }
}
