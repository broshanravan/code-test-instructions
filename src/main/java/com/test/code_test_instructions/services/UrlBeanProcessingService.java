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
        URL customizedUrl = new URL("http://" + newCustomizedUrlTxt);
        Optional<URLBean> uRLBean = urlInventory.findURLBeanByCustomizedURL(customizedUrl);

        return uRLBean.get().getOriginalURL();
    }

    public boolean customUrlExists(String newCustomizedUrlTxt) throws MalformedURLException {
        URL customizedUrl = new URL("http://" + newCustomizedUrlTxt);
        Optional<URLBean> uRLBean = urlInventory.findURLBeanByCustomizedURL(customizedUrl);
        uRLBean.isPresent();
        return uRLBean.isPresent();
    }

    public URL deleteURLRecord(String customizedURLTxt) throws MalformedURLException {
        URL customizedUrl = new URL("http://" + customizedURLTxt);
        Optional<URLBean> uRLBean = urlInventory.findURLBeanByCustomizedURL(customizedUrl);
        urlInventory.delete(uRLBean.orElse(new URLBean()));
        return customizedUrl;
       // return urlInventory.deleteByCustomizedURL(customizedURLTxt);

    }


}
