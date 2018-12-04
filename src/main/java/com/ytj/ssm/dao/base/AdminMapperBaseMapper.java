package .base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import .Admin;
/**
*  @author author
*/
public interface AdminMapperBaseMapper {

    int insertAdmin(Admin object);

    int updateAdmin(Admin object);

    int update(Admin.UpdateBuilder object);

    List<Admin> queryAdmin(Admin object);

    Admin queryAdminLimit1(Admin object);

}