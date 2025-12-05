package com.test.code_test_instructions.services;


import com.test.code_test_instructions.beans.URLBean;
import com.test.code_test_instructions.inventories.UrlInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class UrlBeanProcessingService {

    @Autowired
    UrlInventory urlInventory;
    public URLBean customizeUrl(URL originalURL, String newCustomizedUrl){

        URLBean uRLBean = new URLBean();
        urlInventory.addURLBean(uRLBean);
        return uRLBean;
    }
}
