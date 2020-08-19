package top.warmj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.warmj.pojo.User;

@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(String name);
}
