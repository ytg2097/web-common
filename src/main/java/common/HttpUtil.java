package common;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import common.util.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: yangtg
 * @create: 2020-02-18
 **/
public class HttpUtil {

    static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    public static String HTTP_METHOD_POST = "POST";

    public static String HTTP_METHOD_GET = "GET";

    private static String CONTENT_TYPE_FILE_UPLOAD = "multipart/form-data";

    private static List<String> CONTENT_TYPE_FILE_DOWNLOAD = Lists.newArrayList("application/json");

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String requestToStr(HttpServletRequest request) {
        StringBuilder result = new StringBuilder();
        result.append(requestToStrCommon(request));

        if (!isUpload(request) && HTTP_METHOD_GET.equalsIgnoreCase(request.getMethod())) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap != null && parameterMap.size() > 0) {
                result.append("GET params:").append(JsonUtil.toJson(parameterMap));
            }
        }
        return result.toString();
    }

    public static String requestToStrWithBody(HttpServletRequest request) {
        StringBuilder result = new StringBuilder();
        result.append(requestToStrCommon(request));
        if (!isUpload(request) && HTTP_METHOD_POST.equalsIgnoreCase(request.getMethod())) {
            result.append("POST params:").append(HttpUtil.getPostRequestMsg(request));
        }
        return result.toString();
    }

    private static String getHeader(HttpServletRequest request) {
        Map<String, String> headersMap = Maps.newHashMap();
        putHeaderValue(request, headersMap, WebConst.REQUEST_HEADER_TID);
        putHeaderValue(request, headersMap, WebConst.REQUEST_HEADER_CHANNEL_ID);
        putHeaderValue(request, headersMap, WebConst.REQUEST_HEADER_OPERATOR_ID);
        putHeaderValue(request, headersMap, WebConst.REQUEST_HEADER_OPERATOR_TOKEN);
        if (headersMap.size() > 0) {
            return JsonUtil.toJson(headersMap);
        }
        return null;
    }

    private static void putHeaderValue(HttpServletRequest request, Map<String, String> headersMap, String headerName) {
        String value = request.getHeader(headerName);
        if (!Strings.isNullOrEmpty(value)) {
            headersMap.put(headerName, request.getHeader(headerName));
        }
    }

    private static String requestToStrCommon(HttpServletRequest request) {
        StringBuilder result = new StringBuilder();
        if (request == null) {
            return result.toString();
        }
        result.append(formatNow()).append(", ");
        if (request.getRequestURI() != null) {
            result.append("requestUri:").append(request.getRequestURI()).append(", ");
        }
        if (request.getRequestURL() != null) {
            result.append("requestUrl:").append(request.getRequestURL().toString()).append(", ");
        }
        if (request.getHeader("X-Forwarded-For") != null) {
            result.append("ip:").append(NetworkUtil.getIpAddress(request)).append(", ");
        }
        if (request.getHeader("User-Agent") != null) {
            result.append("browser:").append(request.getHeader("User-Agent")).append(", ");
        }
        String headers = getHeader(request);
        if (!Strings.isNullOrEmpty(headers)) {
            result.append("headers:").append(headers).append(", ");
        }
        return result.toString();
    }

    public static String responseToStr(String responseBody) {
        StringBuilder result = new StringBuilder();
        result.append(formatNow()).append(", ")
                .append("responseBody:").append(responseBody);
        return result.toString();
    }

    private static String formatNow() {
        return DateFormatUtils.format(new Date(), DATE_PATTERN);
    }

    public static String getResponseBody(InputStream responseStream) {
        try {
            return IOStreamUtil.copyToString(responseStream, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "getResponseBody error";
    }

    private static String getPostRequestMsg(HttpServletRequest request) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            return sb.toString();
        } catch (IOException e) {
            LOGGER.error("Post parameter parse Error!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOGGER.error("Close InputStreamReader Error!");
                }
            }
        }
        return null;
    }

    /**
     * 判断是否是上传请求
     *
     * @param request request
     * @return true 上传请求  false 非上传请求
     */
    public static boolean isUpload(HttpServletRequest request) {
        String contentType = request.getContentType();
        return !StringUtils.isEmpty(contentType) && contentType.contains(CONTENT_TYPE_FILE_UPLOAD);
    }

    /**
     * 判断是否是下载
     *
     * @param response response
     * @return true 下载  false 非下载
     */
    public static boolean isDownload(HttpServletResponse response) {
        String contentType = response.getContentType();
        if (!StringUtils.isEmpty(contentType)) {
            for (String s : CONTENT_TYPE_FILE_DOWNLOAD) {
                if (contentType.toLowerCase().startsWith(s)) {
                    return false;
                }
            }
        }
        return true;
    }
}
