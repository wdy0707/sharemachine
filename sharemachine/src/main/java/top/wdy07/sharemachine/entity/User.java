package top.wdy07.sharemachine.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashSet;
import java.util.Set;

public class User {

    @JSONField(ordinal = 1)
    private String uid;

    @JSONField(ordinal = 2)
    private String username;

    @JSONField(ordinal = 3)
    private String passwd;
    @JSONField(ordinal = 4)
    private Set<Role> roles = new HashSet<>();

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", roles=" + roles +
                '}';
    }
}