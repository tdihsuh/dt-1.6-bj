package com.cycredit.base.wechat.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.sun.javadoc.Doc;

/**
 * 微信解析xml：带有CDATA格式的
 */
public class WechatXmlParseUtils {


    /**
     * 解析xml
     *
     * @param xml
     * @return
     * @throws XmlPullParserException
     * @throws IOException
     */
    public static Map<String, String> jdomParseXmlToMap(String xml) throws XmlPullParserException, IOException {
        Map<String, String> map = null;
        if (StringUtils.isNotEmpty(xml)) {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

            XmlPullParser pullParser = factory.newPullParser();

            pullParser.setInput(new StringReader(xml)); // 为xml设置要解析的xml数据
            int eventType = pullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        map = new HashMap<String, String>();
                        break;
                    case XmlPullParser.START_TAG:
                        String key = pullParser.getName();
                        if ("xml".equals(key)) {
                            break;
                        }
                        String value = pullParser.nextText().trim();
                        map.put(key, value);
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = pullParser.next();
            }
        }
        return map;
    }


    public static JSONObject jdomParseXmlToJson(String xml) {
        JSONObject detail = new JSONObject();
        try {
            StringReader read = new StringReader(xml);
            // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
            InputSource source = new InputSource(read);
            // 创建一个新的SAXBuilder
            SAXBuilder sb = new SAXBuilder();
            // 通过输入源构造一个Document
            Document doc;
            doc = (Document) sb.build(source);

            Element root = doc.getRootElement();// 指向根节点
            List<Element> list = root.getChildren();

            if (list != null && list.size() > 0) {
                for (Element element : list) {
                    detail.put(element.getName(), element.getText());
                }
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }


}
