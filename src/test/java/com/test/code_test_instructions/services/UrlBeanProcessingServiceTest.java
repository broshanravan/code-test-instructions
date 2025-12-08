package com.test.code_test_instructions.services;

import com.test.code_test_instructions.beans.URLBean;
import com.test.code_test_instructions.inventories.URLInventory;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Logger;
;
import static org.mockito.Mockito.when;



public class UrlBeanProcessingServiceTest {



    final static Logger logger = Logger.getLogger(UrlBeanProcessingServiceTest.class.toString());


    UrlBeanProcessingService urlBeanProcessingService = new UrlBeanProcessingService();
    URLInventory urlInventory = Mockito.mock(URLInventory.class);

    URL originalURL;

    @Before
    public void init() throws MalformedURLException {
         originalURL = new URL("http://google.com");
        URL customizedURL = new URL("http://myGoogle.com");
        when(urlInventory.findURLBeanByCustomizedURL(customizedURL))
                .thenReturn(Optional.of(new URLBean(originalURL,customizedURL)));

    }






    @Test
    public void createCustomURLTest() throws MalformedURLException {
        try {
            URL customizedUrl = new URL("http://myGoogle");
            URLBean urBean;

            urBean = urlBeanProcessingService.customizeUrl(originalURL, "MyGoogle");
            String ref = urBean.getOriginalURL().getRef();
            assert (ref.equalsIgnoreCase("customizedUrl"));
        } catch (MalformedURLException mfExe){
            logger.warning(mfExe.getMessage());
        }catch (NullPointerException npExe){
            logger.warning(npExe.getMessage());

        }
    }



}
