package nccsoft.spring.restapi.Controller;

import nccsoft.spring.restapi.Repository.NhanVienRepository;

import nccsoft.spring.restapi.Service.NhanVienService;
import nccsoft.spring.restapi.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;
    @GetMapping("/all")
    public String showList(Model model){
        List<NhanVien> employees = nhanVienService.findAll();
        model.addAttribute("employees", employees);
        return "NhanVien/showList";
    }

    @GetMapping("/add")
    public String showNewEmployeePage(Model model) {
        NhanVien nhanVien = new NhanVien();
        model.addAttribute("nhanVien", nhanVien);
        return "NhanVien/add";
    }
    @PostMapping("/doAdd")
    public String saveEmployee(@ModelAttribute("nhanVien") NhanVien nhanVien) {
       nhanVienService.add(nhanVien);
        return "NhanVien/addSuccess";
    }

    @GetMapping("/update")
    public String updateCustomer(@ModelAttribute("id") Long id, Model model) {
        Optional<NhanVien> nhanVien = nhanVienService.findById(id);
        if (nhanVien.isPresent()) {
            model.addAttribute("nhanVien", nhanVien.get());
        }
        return "NhanVien/update";
    }
    @PostMapping("/doUpdate")
    public String doUpdateCustomer(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienService.save(nhanVien);
        return "NhanVien/updateSuccess";
    }

    @GetMapping("/delete")
    public String doDelete(@ModelAttribute("id") Long id){
        nhanVienService.deleteById(id);
        return "NhanVien/deleteSuccess";
    }
}
