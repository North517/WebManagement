package com.north.tliaswebmanagement;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void testGenJwt(){

        Map<String, Object> claims = new HashMap();
        claims.put("id", 1);
        claims.put("username", "testdf");


        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "north.tliaswebmanagement.com")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600))
                .compact();
        System.out.println(jwt);

    }






}
