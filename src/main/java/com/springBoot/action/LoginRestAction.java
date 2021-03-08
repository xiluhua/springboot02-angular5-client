package com.springBoot.action;

import com.springBoot.entity.Contacts;
import com.springBoot.entity.Suser;
import com.springBoot.entity.User;
import com.springBoot.model.resp.*;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;
import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 没有实现多用户场景，纯学习测试用
 * @author Tony Xi
 * @since 2021-03-05
 */
@CrossOrigin
@RestController
public class LoginRestAction {

    public static Map<Object, Contacts> MAP = new HashMap<>();
    public static Integer SERIAL = 0;
    static {
        Contacts contacts = Contacts.builder()
                .email("abc@qq.com")
                .id(500)
                .name("Tom")
                .phone("56789")
                .tag("家人")
                .user(3).build();
        MAP.put(contacts.getId(), contacts);

        Contacts contacts2 = Contacts.builder()
                .email("fog@qq.com")
                .id(501)
                .name("Jannie")
                .phone("12345")
                .tag("朋友")
                .user(4).build();
        MAP.put(contacts2.getId(), contacts2);

        Contacts contacts3 = Contacts.builder()
                .email("hop@qq.com")
                .id(502)
                .name("Marry")
                .phone("13579")
                .tag("朋友")
                .user(5).build();
        MAP.put(contacts3.getId(), contacts3);

        List<Contacts> list = new ArrayList<>();
        list.addAll(MAP.values());

        int biggist = 0;
        for (Contacts ctt: list){
            if (ctt.getId() > biggist) {
                biggist = ctt.getId();
            }
        }
        SERIAL = biggist;
    }

	@PostMapping(value = "/login.action", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BusiResp login(@RequestBody Suser suser) {

        BusiResp resp = new BusiResp(StatusCode.unknownException);
        if (suser != null && !StringUtils.isEmpty(suser.getPassword()) && !StringUtils.isEmpty(suser.getPassword())){
            resp = new BusiResp(StatusCode.success);
        }
		return resp;
	}

	@PostMapping(value = "/loginAngular5.action", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> loginAngular5(@RequestBody User user) {
        return getObjectResponseEntity(user, true);
    }

	@PostMapping(value = "/signinAngular5.action", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> signinAngular5(@RequestBody User user) {
        return getObjectResponseEntity(user, true);
    }

    @PostMapping(value = "/signoutAngular5.action", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> signoutAngular5(@RequestBody User user) {
        return getObjectResponseEntity(user, true);
    }

    private ResponseEntity<Object> getObjectResponseEntity(User user, boolean isProduceToken) {
        UserResp resp = new UserResp(StatusCode.unknownException);
        if (user.getEmail().indexOf("123") > -1){
            return new ResponseEntity<Object>(resp, HttpStatus.CONFLICT);
        }
        if (user != null && !StringUtils.isEmpty(user.getPassword()) && !StringUtils.isEmpty(user.getEmail())){
            resp = new UserResp(StatusCode.success);
            resp.setUser(user);
            if (isProduceToken){
                resp.setToken("TOKEN-1000");
            }
            return new ResponseEntity<Object>(resp, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(resp, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/contactsAngular5.action", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> contactsAngular5(HttpServletRequest request, @RequestBody User user) {
        String token = request.getHeader("X-Access-Token");
	    System.out.println("X-Access-Token: "+token);

        ContactsResp resp = new ContactsResp(StatusCode.success);
        List<Contacts> list = new ArrayList<>();
        list.addAll(MAP.values());
        resp.setContactsList(list);
        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    @PostMapping(value = "/contactsNewAngular5.action", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> contactsNewAngular5(HttpServletRequest request, @RequestBody Contacts contacts) {
        String token = request.getHeader("X-Access-Token");
	    System.out.println("X-Access-Token: "+token);

        ContactsResp resp = new ContactsResp(StatusCode.success);
        SERIAL = SERIAL+1;
        contacts.setId(SERIAL);
        contacts.setTag("朋友");
        // 模拟存数据库
        MAP.put(SERIAL, contacts);
        // 响应
        List<Contacts> list = new ArrayList<>();
        list.addAll(MAP.values());
        resp.setContactsList(list);
        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    @PostMapping(value = "/contactsDelAngular5.action")
    public ResponseEntity<Object> contactsNewAngular5(HttpServletRequest request, @RequestParam("id") String id) {
        String token = request.getHeader("X-Access-Token");
        System.out.println("X-Access-Token: "+token);

        ContactsResp resp = new ContactsResp(StatusCode.success);
        // 模拟存数据库
        MAP.remove(Integer.valueOf(id));
        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/contactsGetAngular5.action")
    public ResponseEntity<Object> contactsGetAngular5(HttpServletRequest request, @RequestParam("id") String id) {
        String token = request.getHeader("X-Access-Token");
        System.out.println("X-Access-Token: "+token);

        ContactsResp resp = new ContactsResp(StatusCode.success);
        // 模拟存数据库
        Contacts contacts = MAP.get(Integer.valueOf(id));
        // 响应
        List<Contacts> list = new ArrayList<>();
        list.add(contacts);
        resp.setContactsList(list);
        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    @PostMapping(value = "/contactsUpdateAngular5.action")
    public ResponseEntity<Object> contactsUpdateAngular5(HttpServletRequest request, @RequestBody Contacts contacts) {
        String token = request.getHeader("X-Access-Token");
        System.out.println("X-Access-Token: "+token);

        ContactsResp resp = new ContactsResp(StatusCode.success);
        // 模拟更新存数据库
        MAP.put(contacts.getId(), contacts);
        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }
}
