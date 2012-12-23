package model;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;

@Entity
@Table(name = "user_info")
public class UserInfo extends Model {
    @Id
    @Constraints.Min(1)
    public Long id;

    @Constraints.Required
    public String ip;

    @Constraints.Required
    public String sessionId;

    public UserInfo() {
    }

    public static Model.Finder<Long, UserInfo> find = new Model.Finder<Long, UserInfo>(
            Long.class, UserInfo.class
    );

    public UserInfo(String ip, String sessionId) {
        this.ip = ip;
        this.sessionId = sessionId;
    }
}
