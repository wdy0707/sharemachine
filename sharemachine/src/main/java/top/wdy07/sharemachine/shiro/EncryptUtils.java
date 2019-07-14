package top.wdy07.sharemachine.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptUtils {
    public static Object encrypt(String username, String passwd) {
        String hashAlgorithName = "MD5";
        String password = passwd;
        int hashIterations = 2;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        return obj;
    }

    public static void main(String[] args) {
        String username = "wdy";
        String passwd = "123";
        System.out.println(encrypt(username,passwd));
    }
}
