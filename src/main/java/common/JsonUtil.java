package common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 将参数对象输出为 JSON 字符串
     */
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    /**
     * 读取 JSON 字符串返回对应的 Java 对象
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) throws IOException {
        return mapper.readValue(jsonString, clazz);
    }

    /**
     * 读取 JSON 字符串返回对应的 Java 对象
     */
    public static <T> T fromReader(Reader reader, Class<T> clazz) throws IOException {

        return mapper.readValue(reader,clazz);
    }


    /**
     * 读取 JSON 字符串返回对应的 Java 对象列表
     *
     * @param jsonString JSON 数组字符串
     * @param clazz      数组中单个元素的类型
     */
    public static <T> List<T> fromJsonArray(String jsonString, Class<T> clazz) throws IOException {
        return mapper.readValue(jsonString,
                mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }


    /**
     * 将参数对象输出为 JSON 字符串并写入到 writer
     *
     * @throws IOException
     */
    public static void writeValue(Writer writer, Object object) throws IOException {
        mapper.writeValue(writer, object);
    }
}
