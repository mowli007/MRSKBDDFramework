package com.automation.reader;


import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class XMLDataReader
{

    public static String readData(String xpath) throws XPathExpressionException 
    {
        String xpathResult = null;

        XPath Xpath = XPathFactory.newInstance().newXPath();
        InputSource inputSource = new InputSource(System.getProperty("user.dir") + "/properties.xml");
        xpathResult = Xpath.evaluate(xpath, inputSource);

        return xpathResult;
    }
}


