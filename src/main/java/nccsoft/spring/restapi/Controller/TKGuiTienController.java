package nccsoft.spring.restapi.Controller;

import nccsoft.spring.restapi.Repository.TKGuiTienRepository;
import nccsoft.spring.restapi.Service.TKGuiTienService;
import nccsoft.spring.restapi.entity.TaiKhoanGuiTien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        tkGuiTienService.add(taiKhoanGuiTien);
        return "TKGuiTien/addSuccess";
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
        tkGuiTienService.save(taiKhoanGuiTien);
        return "TKGuiTien/updateSuccess";
    }

    @GetMapping("/delete")
    public String doDelete(@ModelAttribute("id") Long id){
        tkGuiTienService.deleteById(id);
        return "TKGuiTien/deleteSuccess";
    }
}
