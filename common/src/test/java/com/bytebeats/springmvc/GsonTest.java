package com.bytebeats.springmvc;

import com.bytebeats.springmvc.common.util.JsonUtils;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-01-05 11:27
 */
public class GsonTest {

    @Test
    public void testGson(){

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        String json = JsonUtils.toJson(list);
        System.out.println("json:"+json);
        //list
        Type typeList = new TypeToken<ArrayList<String>>(){}.getType();
        list = JsonUtils.fromJson(json, typeList);

        System.out.println("list:"+list);
    }
}
