package .read.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import .Admin;
/**
*  @author author
*/
public interface AdminDaoBaseReadMapper {


    List<Admin> queryAdmin(Admin object);

    Admin queryAdminLimit1(Admin object);

}