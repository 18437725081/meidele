package com.synco.kava.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.synco.kava.entity.Admin;

/**
 * @author:wangshuai
 * @date:2019/1/28
 */
public class JWTUtil {

    public static String getToken(Admin admin) {
        return JWT.create().withAudience(admin.getUsername()).sign(Algorithm.HMAC256(admin.getPassword()));

    }
}

