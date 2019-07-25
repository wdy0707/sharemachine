package top.wdy07.sharemachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.wdy07.sharemachine.dao.DeviceAndTaskDao;
import top.wdy07.sharemachine.entity.Device;
import top.wdy07.sharemachine.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SharemachineApplication.class)
public class DaoTest {
    @Autowired
    DeviceAndTaskDao deviceAndTaskDao;
    @Test
    public  void selectTest() throws InterruptedException{
      String result =   deviceAndTaskDao.getTaskCid().toString();
        System.out.println(result);
    }

//    void postDevice(Device device);
//    List<HashMap<String,String>> getTaskCid();
//    List<HashMap<String,String>> getUserTaskList(String uid);
//    void postTaskInfo(Task task);
//    void postDeviceState(String did);
//    List<HashMap<String,String>> getTerminaledTask(String did);
@Test
public  void getTaskCid() throws InterruptedException{
    List result =   deviceAndTaskDao.getUserTaskList("3");
    System.out.println(result.size());
    System.out.println(result.toString());
}

    @Test
    public  void postTest() throws InterruptedException{
        Device device = new Device();
        device.setCpu("123");
        device.setDid("fffffffffff");
        device.setMemsize("1024");
        device.setState(false);
        deviceAndTaskDao.postDevice(device);
    }
}
