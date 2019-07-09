package top.wdy07.sharemachine.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.wdy07.sharemachine.entity.TaskCat;
import top.wdy07.sharemachine.entity.TaskCatExample;

public interface TaskCatMapper {
    int countByExample(TaskCatExample example);

    int deleteByExample(TaskCatExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TaskCat record);

    int insertSelective(TaskCat record);

    List<TaskCat> selectByExample(TaskCatExample example);

    TaskCat selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TaskCat record, @Param("example") TaskCatExample example);

    int updateByExample(@Param("record") TaskCat record, @Param("example") TaskCatExample example);

    int updateByPrimaryKeySelective(TaskCat record);

    int updateByPrimaryKey(TaskCat record);
}