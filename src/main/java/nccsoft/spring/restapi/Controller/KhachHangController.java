package nccsoft.spring.restapi.Controller;

import nccsoft.spring.restapi.Service.KhachHangService;
import nccsoft.spring.restapi.Service.NhanVienService;
import nccsoft.spring.restapi.entity.KhachHang;
import nccsoft.spring.restapi.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/all")
    public String showList(Model model){
        List<KhachHang> customer = khachHangService.findAll();
        model.addAttribute("customer", customer);
        return "KhachHang/showList";
    }

    @GetMapping("/add")
    public String add(Model model) {
        KhachHang khachHang = new KhachHang();
        model.addAttribute("khachHang", khachHang);
        return "KhachHang/add";
    }

    @PostMapping("/doAdd")
    public String doAdd(@ModelAttribute("khachHang") KhachHang khachHang) {
        khachHangService.add(khachHang);
        return "KhachHang/addSuccess";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("id") Long id, Model model) {
        Optional<KhachHang> khachHang = khachHangService.findById(id);
        if (khachHang.isPresent()) {
            model.addAttribute("khachHang", khachHang.get());
        }
        return "KhachHang/update";
    }
    @PostMapping("/doUpdate")
    public String doUpdate(@ModelAttribute("nhanVien") KhachHang khachHang) {
        khachHangService.save(khachHang);
        return "KhachHang/updateSuccess";
    }

    @GetMapping("/delete")
    public String doDelete(@ModelAttribute("id") Long id){
        khachHangService.deleteById(id);
        return "KhachHang/deleteSuccess";
    }
}
