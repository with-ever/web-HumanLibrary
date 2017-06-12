package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.common.client.ClientPlatform;
import kr.withever.humanlibrary.domain.common.client.FCMInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by youngjinkim on 2017. 6. 12..
 */
@DatabaseSetup(value = {"/dataset/FCMInfo.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/FCMInfo.xml"}, type = DatabaseOperation.DELETE_ALL)
public class FCMInfoMapperTest extends WitheverDbUnitTestConfig{

    @Autowired
    private FCMInfoMapper fcmInfoMapper;

    @Test
    public void insertFCMInfo() throws Exception {
        FCMInfo fcmInfo = new FCMInfo("jin", "kim", ClientPlatform.ANDROID.name());
        this.fcmInfoMapper.insertFCMInfo(fcmInfo);

        FCMInfo insertedFCMInfo = this.fcmInfoMapper.selectFCMInfoByDeviceId("jin");
        assertEquals("jin", insertedFCMInfo.getDeviceId());
        assertEquals("kim", insertedFCMInfo.getToken());
        assertEquals(ClientPlatform.ANDROID.name(), insertedFCMInfo.getPlatform());
    }

    @Test
    public void selectFCMInfoByUserId() throws Exception {
        FCMInfo fcmInfo = this.fcmInfoMapper.selectFCMInfoByUserId(1L);
        assertEquals("1234", fcmInfo.getDeviceId());
        assertEquals("abcd", fcmInfo.getToken());
        assertEquals(ClientPlatform.ANDROID.name(), fcmInfo.getPlatform());
        assertEquals(Long.valueOf(1L), fcmInfo.getUser().getUserId());
        assertEquals("3", fcmInfo.getType());
        assertEquals("1.0", fcmInfo.getVersion());
        assertEquals("1234567890", fcmInfo.getSid());
    }

    @Test
    public void selectFCMInfoByDeviceId() throws Exception {
        FCMInfo fcmInfo = this.fcmInfoMapper.selectFCMInfoByDeviceId("1234");
        assertEquals("1234", fcmInfo.getDeviceId());
        assertEquals("abcd", fcmInfo.getToken());
        assertEquals(ClientPlatform.ANDROID.name(), fcmInfo.getPlatform());
        assertEquals(Long.valueOf(1L), fcmInfo.getUser().getUserId());
        assertEquals("3", fcmInfo.getType());
        assertEquals("1.0", fcmInfo.getVersion());
        assertEquals("1234567890", fcmInfo.getSid());
    }

    @Test
    public void updateFCMInfo() throws Exception {
        FCMInfo fcmInfo = this.fcmInfoMapper.selectFCMInfoByDeviceId("1234");
        fcmInfo.setSid("11111111");

        this.fcmInfoMapper.updateFCMInfo(fcmInfo);

        FCMInfo updatedFCMInfo = this.fcmInfoMapper.selectFCMInfoByDeviceId("1234");
        assertEquals("11111111", updatedFCMInfo.getSid());
    }

    @Test
    public void deleteFCMInfoByUserId() throws Exception {
        FCMInfo fcmInfo = this.fcmInfoMapper.selectFCMInfoByUserId(1L);
        assertNotNull(fcmInfo);

        this.fcmInfoMapper.deleteFCMInfoByUserId(1L);

        FCMInfo deletedFCMInfo = this.fcmInfoMapper.selectFCMInfoByUserId(1L);
        assertNull(deletedFCMInfo);
    }

    @Test
    public void deleteFCMInfoByDeviceId() throws Exception {
        FCMInfo fcmInfo = this.fcmInfoMapper.selectFCMInfoByDeviceId("1234");
        assertNotNull(fcmInfo);

        this.fcmInfoMapper.deleteFCMInfoByDeviceId("1234");

        FCMInfo deletedFCMInfo = this.fcmInfoMapper.selectFCMInfoByDeviceId("1234");
        assertNull(deletedFCMInfo);
    }

}