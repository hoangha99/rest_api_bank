package nccsoft.spring.restapi.Controller;


import nccsoft.spring.restapi.Service.NhanVienService;
import nccsoft.spring.restapi.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Home {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/addnhanvien")
    public  String add(){
        return "ThemNhanVien";
    }

}