package .write.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import .Admin;
/**
*  @author author
*/
public interface AdminDaoBaseWriteMapper {

    int insertAdmin(Admin object);

    int updateAdmin(Admin object);

    int update(Admin.UpdateBuilder object);

}