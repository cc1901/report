package model;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.SqlUpdate;
import org.junit.Before;
import org.junit.Test;
import play.db.ebean.Transactional;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class UserInfoTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Transactional
    public void should_persist_user_info() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                EbeanServer ebeanServer = Ebean.getServer("report");
                SqlUpdate sqlUpdate = ebeanServer.createSqlUpdate("delete from userInfo");
                sqlUpdate.execute();
                String ip = "10.10.10.10";
                UserInfo userInfo = new UserInfo(ip, "sessionId");
                ebeanServer.save(userInfo);
//                RawSql rawSql = RawSqlBuilder.parse("select count(*) from userInfo").create();
//                Query<UserInfo> userInfoQuery = Ebean.find(UserInfo.class);
//                List<UserInfo> list = userInfoQuery.setRawSql(rawSql).findList();
//                assertThat(list.size(), is(1));
//                assertThat(list.get(0).ip, is(ip));
            }
        });

    }
}
