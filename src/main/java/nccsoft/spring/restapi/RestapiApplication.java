package nccsoft.spring.restapi;

import nccsoft.spring.restapi.Service.NhanVienService;
import nccsoft.spring.restapi.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }


}
