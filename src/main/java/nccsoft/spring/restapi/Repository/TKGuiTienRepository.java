package nccsoft.spring.restapi.Repository;

import nccsoft.spring.restapi.entity.TaiKhoanGuiTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TKGuiTienRepository extends JpaRepository<TaiKhoanGuiTien, Long> {

}
