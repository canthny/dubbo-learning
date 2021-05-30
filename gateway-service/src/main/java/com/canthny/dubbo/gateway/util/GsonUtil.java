package com.canthny.dubbo.gateway.util;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GsonUtil {
    private static Logger logger = LogManager.getLogger(GsonUtil.class);
    private static Gson gson = (new GsonBuilder()).registerTypeAdapter(Date.class, new GsonUtil.UtilDateSerializer()).registerTypeAdapter(Date.class, new GsonUtil.UtilDateDeserializer()).setDateFormat(1).create();
    private static final Type STRING_MAP_TYPE = (new TypeToken<Map<String, String>>() {
    }).getType();
    private static final Type STRING_LIST_TYPE = (new TypeToken<List<String>>() {
    }).getType();
    private static final Type STRING_LIST_TYPE_OBJECT = (new TypeToken<List<Object>>() {
    }).getType();
    private static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public GsonUtil() {
    }

    public static <T> T getDomain(String json, TypeToken<T> token) {
        return gson.fromJson(json, token.getType());
    }

    public static JsonElement parseString(String json) {
        if (json != null && json.trim().length() > 0) {
            JsonParser parser = new JsonParser();
            return parser.parse(json);
        } else {
            return JsonNull.INSTANCE;
        }
    }

    public static Map<String, String> fromJson2StrMap(String json) {
        try {
            return (Map)gson.fromJson(json, STRING_MAP_TYPE);
        } catch (Exception var2) {
            logger.info("json串转换map异常,json:" + json, var2);
            return new HashMap(0);
        }
    }

    public static List<String> fromJson2StrList(String json) {
        try {
            return (List)gson.fromJson(json, STRING_LIST_TYPE_OBJECT);
        } catch (Exception var2) {
            logger.info("json串转换list异常,json:" + json, var2);
            return new ArrayList(0);
        }
    }

    public static <T> List<T> getObjList(String json, Class<T> cls) {
        try {
            return (List)gson.fromJson(json, cls);
        } catch (Exception var3) {
            logger.info("json串转换list异常,json:" + json, var3);
            return null;
        }
    }

    public static String getKeyValue(String key, String jsonStr) {
        return getKeyValue(key, parseString(jsonStr));
    }

    public static String getKeyValue(String key, JsonElement element) {
        if (key != null && key.trim().length() > 0 && element != null) {
            JsonObject object = null;

            try {
                if (element.isJsonObject()) {
                    object = element.getAsJsonObject();
                    element = object.get(key);
                    if (element.isJsonPrimitive()) {
                        return element.getAsString();
                    }

                    return element.toString();
                }

                return element.toString();
            } catch (Exception var4) {
                ;
            }
        }

        return null;
    }

    public static String removeKey(String key, JsonElement element) {
        if (key != null && key.trim().length() > 0 && element != null) {
            JsonObject object = null;

            try {
                if (element.isJsonObject()) {
                    object = element.getAsJsonObject();
                    object.remove(key);
                    return object.toString();
                }

                return element.toString();
            } catch (Exception var4) {
                ;
            }
        }

        return null;
    }

    public static String toJsonString(Object o) {
        return gson.toJson(o);
    }

    public static <T> T fromJson(String json, TypeToken<T> token) {
        return gson.fromJson(json, token.getType());
    }

    public static <T> T fromJson(Class<T> classOfT, String json) {
        return gson.fromJson(json, classOfT);
    }

    public static Boolean isRealJson(String json) {
        if (StringUtils.isBlank(json)) {
            return Boolean.FALSE;
        } else if (json.startsWith("{") && json.endsWith("}") && json.length() > 2) {
            try {
                (new JsonParser()).parse(json);
                return Boolean.TRUE;
            } catch (JsonParseException var2) {
                logger.debug("bad json: " + json);
                return Boolean.FALSE;
            }
        } else {
            return Boolean.FALSE;
        }
    }

    private static class UtilDateSerializer implements JsonSerializer<Date> {
        private UtilDateSerializer() {
        }

        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            DateFormat format = (DateFormat)GsonUtil.dateFormat.get();
            return new JsonPrimitive(format.format(src));
        }
    }

    private static class UtilDateDeserializer implements JsonDeserializer<Date> {
        private UtilDateDeserializer() {
        }

        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (null == json) {
                return null;
            } else {
                String value = json.getAsString();
                Date date = null;
                if (null != value && !value.trim().equals("") && !value.trim().equals("null")) {
                    value = value.trim();
                    String format = "yyyy-MM-dd HH:mm:ss";

                    try {
                        if (value.contains("-")) {
                            if (value.length() == 19) {
                                format = "yyyy-MM-dd HH:mm:ss";
                            } else if (value.length() == 16) {
                                format = "yyyy-MM-dd HH:mm";
                            } else if (value.length() == 13) {
                                format = "yyyy-MM-dd HH";
                            } else if (value.length() == 10) {
                                format = "yyyy-MM-dd";
                            }
                        } else if (value.contains(":")) {
                            if (value.length() == 8) {
                                format = "HH:mm:ss";
                            } else if (value.length() == 5) {
                                format = "HH:mm";
                            }
                        } else if (value.length() == 2) {
                            format = "HH";
                        } else if (value.length() == 4) {
                            format = "HHmm";
                        } else if (value.length() == 6) {
                            format = "HHmmss";
                        } else if (value.length() == 8) {
                            format = "yyyyMMdd";
                        } else if (value.length() == 10) {
                            format = "yyyyMMddHH";
                        } else if (value.length() == 12) {
                            format = "yyyyMMddHHmm";
                        } else if (value.length() == 14) {
                            format = "yyyyMMddHHmmss";
                        } else if (value.length() >= 13 && !value.startsWith("20")) {
                            date = new Date(Long.parseLong(value));
                            format = null;
                        }

                        if (null != format) {
                            date = (new SimpleDateFormat(format)).parse(value);
                        }
                    } catch (ParseException var8) {
                        GsonUtil.logger.error("", var8);
                    }
                }

                return date;
            }
        }
    }
}
