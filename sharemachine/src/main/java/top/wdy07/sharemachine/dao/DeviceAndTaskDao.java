package top.wdy07.sharemachine.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.wdy07.sharemachine.entity.Device;
import top.wdy07.sharemachine.entity.Task;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface DeviceAndTaskDao {
    void postDevice(Device device);
    void postTaskInfo(Task task);
    void postDeviceState(String did);

    List<HashMap<String,String>> getTaskCid();
    List<HashMap<String,String>> getUserTaskList(String uid);
    List<HashMap<String,String>> getTerminaledTask(String did);
}
