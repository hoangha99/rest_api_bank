package nccsoft.spring.restapi.Controller;

import nccsoft.spring.restapi.Service.KhachHangService;
import nccsoft.spring.restapi.Service.NhanVienService;
import nccsoft.spring.restapi.Service.TKGuiTienService;
import nccsoft.spring.restapi.Service.TKTinDungService;
import nccsoft.spring.restapi.entity.KhachHang;
import nccsoft.spring.restapi.entity.NhanVien;
import nccsoft.spring.restapi.entity.TaiKhoanGuiTien;
import nccsoft.spring.restapi.entity.TaiKhoanTinDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tkguitien")
public class TKGuiTienController {
    @Autowired
    TKGuiTienService tkGuiTienService;
    @Autowired
    TKTinDungService tkTinDungService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/all")
    public String showList(Model model){
        List<TaiKhoanGuiTien> taiKhoanGuiTien = tkGuiTienService.findAll();
        model.addAttribute("taiKhoanGuiTien", taiKhoanGuiTien);
        return "TKGuiTien/showList";
    }

    @GetMapping("/add")
    public String add(Model model) {
        TaiKhoanGuiTien taiKhoanGuiTien = new TaiKhoanGuiTien();
        model.addAttribute("taiKhoanGuiTien", taiKhoanGuiTien);
        return "TKGuiTien/add";
    }

    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("taiKhoanGuiTien") TaiKhoanGuiTien taiKhoanGuiTien) {
        Optional<NhanVien> nhanVien = nhanVienService.findById(taiKhoanGuiTien.getNhanvien_id());
        Optional<KhachHang> khachHang = khachHangService.findById(taiKhoanGuiTien.getKhachhang_id());
        if(nhanVien.isPresent()&&khachHang.isPresent()){
            nhanVien.get().setLuong(5000+nhanVien.get().getLuong());
            tkGuiTienService.add(taiKhoanGuiTien);
            return "TKGuiTien/addSuccess";
        }
        return "TKGuiTien/error";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("id") Long id, Model model) {
        Optional<TaiKhoanGuiTien> taiKhoanGuiTien = tkGuiTienService.findById(id);
        if (taiKhoanGuiTien.isPresent()) {
            model.addAttribute("taiKhoanGuiTien", taiKhoanGuiTien.get());
        }
        return "TKGuiTien/update";
    }
    @PostMapping("/doUpdate")
    public String doUpdate(@ModelAttribute("taiKhoanGuiTien") TaiKhoanGuiTien taiKhoanGuiTien) {
        Optional<NhanVien> nhanVien = nhanVienService.findById(taiKhoanGuiTien.getNhanvien_id());
        Optional<KhachHang> khachHang = khachHangService.findById(taiKhoanGuiTien.getKhachhang_id());

       if(nhanVien.isPresent()||khachHang.isPresent())
        {
            tkGuiTienService.save(taiKhoanGuiTien);
            return "TKGuiTien/updateSuccess";

        }
        return "TKGuiTien/error";
    }

    @GetMapping("/delete")
    public String doDelete(@ModelAttribute("id") Long id){
        tkGuiTienService.deleteById(id);
        return "TKGuiTien/deleteSuccess";
    }
    @GetMapping("/guitien")
    public String save(@ModelAttribute("id") Long id, Model model){
        Optional<TaiKhoanGuiTien> taiKhoanGuiTien = tkGuiTienService.findById(id);
        if (taiKhoanGuiTien.isPresent()) {
            model.addAttribute("taiKhoanGuiTien", taiKhoanGuiTien.get());
        }
        return "TKGuiTien/guiTien";
    }
    @PostMapping("/doGui")
    public String doSave(@ModelAttribute("id") Long id, @ModelAttribute("sotien") float sotien){
        Optional<TaiKhoanGuiTien> taiKhoanGuiTien = tkGuiTienService.findById(id);
        if(taiKhoanGuiTien.get().getSodu()==0L){
            sotien = (float) (sotien+ sotien*(0.2));
        }
        taiKhoanGuiTien.get().setSodu(taiKhoanGuiTien.get().getSodu()+ sotien);
        tkGuiTienService.save(taiKhoanGuiTien.get());
        return "TKGuiTien/guiSuccess";
    }

    @GetMapping("/thanhtoan")
    public String pay(@ModelAttribute("id") Long id, Model model){
        Optional<TaiKhoanGuiTien> taiKhoanGuiTien = tkGuiTienService.findById(id);
        if (taiKhoanGuiTien.isPresent()) {
            model.addAttribute("taiKhoanGuiTien", taiKhoanGuiTien.get());
        }
        return "TKGuiTien/thanhToan";
    }
    @PostMapping("/doThanhToan")
    public String doPay(@ModelAttribute("id") Long id, @ModelAttribute("sotien") float sotien, @ModelAttribute("idtt") Long idtt){
        Optional<TaiKhoanGuiTien> taiKhoanGuiTien = tkGuiTienService.findById(id);
        Optional<TaiKhoanTinDung> taiKhoanTinDung = tkTinDungService.findById(idtt);
        if(taiKhoanGuiTien.get().getSodu()-sotien>taiKhoanGuiTien.get().getSodu_toithieu()||taiKhoanTinDung.isPresent()){
            taiKhoanGuiTien.get().setSodu(taiKhoanGuiTien.get().getSodu()- sotien);
            tkGuiTienService.save(taiKhoanGuiTien.get());
            taiKhoanTinDung.get().setSodu(taiKhoanTinDung.get().getSodu()+sotien);
            tkTinDungService.save(taiKhoanTinDung.get());
            return "TKGuiTien/thanhToanSuccess";
        }
        return "TKGuiTien/errorThanhToan";
    }
}
