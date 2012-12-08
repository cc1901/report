package service;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import model.UserInfo;

import javax.annotation.Nullable;
import java.util.List;

public class ReportService {

    public List<String> reportIp() {
        EbeanServer report = Ebean.getServer("report");
        List<String> ips = Lists.transform(report.find(UserInfo.class).findList(), new Function<UserInfo, String>() {
            @Override
            public String apply(@Nullable UserInfo userInfo) {
                return userInfo.ip;
            }
        });
        return ips;
    }
}
