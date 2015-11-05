package org.quickconnectfamily.json;

import java.io.IOException;

/**
 * A simplified and stoppable SAX-like content handler for stream processing of mynewjson text.
 * 
 * @see org.xml.sax.ContentHandler
 * @see org.json.simple.parser.JSONParser#parse(java.io.Reader, ContentHandler, boolean)
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public interface ContentHandler {
        /**
         * Receive notification of the beginning of mynewjson processing.
         * The parser will invoke this method only once.
     * 
         * @throws ParseException - JSONParser will stop and throw the same exception to the caller when receiving this exception.
         */
        void startJSON() throws ParseException, IOException;
        
        /**
         * Receive notification of the end of mynewjson processing.
         * 
         * @throws ParseException
         */
        void endJSON() throws ParseException, IOException;
        
        /**
         * Receive notification of the beginning of a mynewjson object.
         * 
         * @return false if the handler wants to stop parsing after return.
         * @throws ParseException
     *          - JSONParser will stop and throw the same exception to the caller when receiving this exception.
     * @see #endJSON
         */
        boolean startObject() throws ParseException, IOException;
        
        /**
         * Receive notification of the end of a mynewjson object.
         * 
         * @return false if the handler wants to stop parsing after return.
         * @throws ParseException
     * 
     * @see #startObject
         */
        boolean endObject() throws ParseException, IOException;
        
        /**
         * Receive notification of the beginning of a mynewjson object entry.
         * 
         * @param key - Key of a mynewjson object entry.
         * 
         * @return false if the handler wants to stop parsing after return.
         * @throws ParseException
     * 
     * @see #endObjectEntry
         */
        boolean startObjectEntry(String key) throws ParseException, IOException;
        
        /**
         * Receive notification of the end of the value of previous object entry.
         * 
         * @return false if the handler wants to stop parsing after return.
         * @throws ParseException
     * 
     * @see #startObjectEntry
         */
        boolean endObjectEntry() throws ParseException, IOException;
        
        /**
         * Receive notification of the beginning of a mynewjson array.
         * 
         * @return false if the handler wants to stop parsing after return.
         * @throws ParseException
     * 
     * @see #endArray
         */
        boolean startArray() throws ParseException, IOException;
        
        /**
         * Receive notification of the end of a mynewjson array.
         * 
         * @return false if the handler wants to stop parsing after return.
         * @throws ParseException
     * 
     * @see #startArray
         */
        boolean endArray() throws ParseException, IOException;
        
        /**
         * Receive notification of the mynewjson primitive values:
         *      java.lang.String,
         *      java.lang.Number,
         *      java.lang.Boolean
         *      null
         * 
         * @param value - Instance of the following:
         *                      java.lang.String,
         *                      java.lang.Number,
         *                      java.lang.Boolean
         *                      null
         * 
         * @return false if the handler wants to stop parsing after return.
         * @throws ParseException
         */
        boolean primitive(Object value) throws ParseException, IOException;
                
}
