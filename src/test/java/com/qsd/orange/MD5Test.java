package com.qsd.orange;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @Author Esion
 * @Date 2020/9/23 19:42
 * @Version 1.0
 */
public class MD5Test {

    public static void main(String[] args) {
        String password = "123456";
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        password = md5.digestHex(password);
        System.out.println(password);
    }

}
