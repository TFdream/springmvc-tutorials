package apple.springmvc.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-01-05 11:25
 */
public class JsonUtils {
    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private JsonUtils(){}

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {

        return GSON.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {

        return GSON.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {

        return GSON.fromJson(json, classOfT);
    }

    public static <T> T fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {

        return GSON.fromJson(json, typeOfT);
    }

    public static String toJson(Object obj){

        return GSON.toJson(obj);
    }

}
