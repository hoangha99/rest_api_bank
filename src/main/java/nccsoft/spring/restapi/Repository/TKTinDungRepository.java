package nccsoft.spring.restapi.Repository;

import nccsoft.spring.restapi.entity.TaiKhoanTinDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TKTinDungRepository extends JpaRepository<TaiKhoanTinDung,Long> {
}
