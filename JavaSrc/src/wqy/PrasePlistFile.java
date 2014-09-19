package wqy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class PlistHandler extends DefaultHandler {
	 
    private boolean isRootElement = false;
 
    private boolean keyElementBegin = false;
 
    private String key;
 
    Stack<Object> stack = new Stack<Object>();
 
    private boolean valueElementBegin = false;
 
    private Object root;
 
    @SuppressWarnings("unchecked")
    public HashMap<String, Object> getMapResult() {
        return (HashMap<String, Object>) root;
    }
 
    @SuppressWarnings("unchecked")
    public List<Object> getArrayResult() {
        return (List<Object>) root;
    }
 
    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析");
    }
 
    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束解析");
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // System.out.println(uri+"startElement:"+qName);
        if ("plist".equals(qName)) {
            isRootElement = true;
        }
        if ("dict".equals(qName)) {
            if (isRootElement) {
                stack.push(new HashMap<String, Object>());// 压栈
                isRootElement = !isRootElement;
            } else {
                Object object = stack.peek();
                HashMap<String, Object> dict = new HashMap<String, Object>();
                if (object instanceof ArrayList)
                    ((ArrayList<Object>) object).add(dict);
                else if (object instanceof HashMap)
                    ((HashMap<String, Object>) object).put(key, dict);
                stack.push(dict);
            }
        }
 
        if ("key".equals(qName)) {
            keyElementBegin = true;
        }
        if ("true".equals(qName)) {
            HashMap<String, Object> parent = (HashMap<String, Object>) stack.peek();
            parent.put(key, true);
        }
        if ("false".equals(qName)) {
            HashMap<String, Object> parent = (HashMap<String, Object>) stack.peek();
            parent.put(key, false);
        }
        if ("array".equals(qName)) {
            if (isRootElement) {
                ArrayList<Object> obj = new ArrayList<Object>();
                stack.push(obj);
                isRootElement = !isRootElement;
            } else {
                HashMap<String, Object> parent = (HashMap<String, Object>) stack.peek();
                ArrayList<Object> obj = new ArrayList<Object>();
                stack.push(obj);
                parent.put(key, obj);
            }
        }
        if ("string".equals(qName)) {
            valueElementBegin = true;
        }
    }
 
    /*
     * 字符串解析(non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("characters:");
        if (length > 0) {
            if (keyElementBegin) {
                key = new String(ch, start, length);
                System.out.println("key:" + key);
            }
            if (valueElementBegin) {
                if (HashMap.class.equals(stack.peek().getClass())) {
                    HashMap<String, Object> parent = (HashMap<String, Object>) stack.peek();
                    String value = new String(ch, start, length);
                    parent.put(key, value);
                } else if (ArrayList.class.equals(stack.peek().getClass())) {
                    ArrayList<Object> parent = (ArrayList<Object>) stack.peek();
                    String value = new String(ch, start, length);
                    parent.add(value);
                }
                System.out.println("value:" + new String(ch, start, length));
            }
        }
    }
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("plist".equals(qName)) {
            ;
        }
        if ("key".equals(qName)) {
            keyElementBegin = false;
        }
        if ("string".equals(qName)) {
            valueElementBegin = false;
        }
        if ("array".equals(qName)) {
            root = stack.pop();
        }
        if ("dict".equals(qName)) {
            root = stack.pop();
        }
    }
}

public class PrasePlistFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("F:/test.plist");
		InputStream is;
		SAXParserFactory factorys = null;
		SAXParser saxparser = null;
		PlistHandler plistHandler = null;
		try {
			is = new FileInputStream(file);
			factorys = SAXParserFactory.newInstance();
	        saxparser = factorys.newSAXParser();
	        plistHandler = new PlistHandler();
	        saxparser.parse(is, plistHandler);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 
        HashMap<String, Object> hash = plistHandler.getMapResult();
//        ArrayList<Object> array =  (ArrayList<Object>)plistHandler.getArrayResult();
//        for(int i=0;i<hash.size();i++)
//        	System.out.println(hash.get(i));
        
	}

}
