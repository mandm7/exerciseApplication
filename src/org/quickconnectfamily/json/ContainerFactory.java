package org.quickconnectfamily.json;


import java.util.List;
import java.util.Map;

/**
 * Container factory for creating containers for mynewjson object and mynewjson array.
 * 
 * @see org.json.simple.parser.JSONParser#parse(java.io.Reader, ContainerFactory)
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public interface ContainerFactory {
        /**
         * @return A Map instance to store mynewjson object, or null if you want to use org.mynewjson.simple.JSONObject.
         */
        Map<Object,Object> createObjectContainer();
        
        /**
         * @return A List instance to store mynewjson array, or null if you want to use org.mynewjson.simple.JSONArray.
         */
        List<?> creatArrayContainer();
}
