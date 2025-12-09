package com.test.code_test_instructions.services;


import com.test.code_test_instructions.beans.URLBean;
import com.test.code_test_instructions.inventories.URLInventory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;


@Getter
@Setter
@Service

public class UrlBeanProcessingService {

    @Autowired
    URLInventory urlInventory;
    public URLBean customizeUrl(URL originalURL, String newCustomizedUrl) throws MalformedURLException {

        URLBean uRLBean = new URLBean();
        uRLBean.setOriginalURL(originalURL);
        URL customizedUrl = new URL("http://" + newCustomizedUrl);
        uRLBean.setCustomizedURL(customizedUrl);

        urlInventory.save(uRLBean);
        return uRLBean;
    }

    public URL getOriginalUrl(String newCustomizedUrlTxt) throws MalformedURLException {

       if (customUrlExists(newCustomizedUrlTxt)){
            URL customizedUrl = new URL(validateUrlFormat(newCustomizedUrlTxt.trim()));
            Optional<URLBean> uRLBean = urlInventory.findURLBeanByCustomizedURL(customizedUrl);
             return uRLBean.get().getOriginalURL();
        } else {
           return new URL("record does not exist");
       }
    }

    public boolean customUrlExists(String newCustomizedUrlTxt) throws MalformedURLException {
        URL customizedUrl = new URL(validateUrlFormat(newCustomizedUrlTxt.trim()));
        Optional<URLBean> uRLBean = urlInventory.findURLBeanByCustomizedURL(customizedUrl);
        uRLBean.isPresent();
        return uRLBean.isPresent();
    }

    public URL deleteURLRecord(String customizedURLTxt) throws MalformedURLException {
        URL customizedUrl = new URL(validateUrlFormat( customizedURLTxt.trim()));
        Optional<URLBean> uRLBean = urlInventory.findURLBeanByCustomizedURL(customizedUrl);
        urlInventory.delete(uRLBean.orElse(new URLBean()));
        return customizedUrl;
       // return urlInventory.deleteByCustomizedURL(customizedURLTxt);

    }

    private String validateUrlFormat(String url){
         //String protocol = url.substring(0, 6);
         if(url.length()<6) {
             url = "http://" + url;
         } else {
             String protocol = url.substring(0, 7);
             if(!protocol.contains("http://")){
                 url = "http://" + url;
             }
         }
         return url;
    }


}
