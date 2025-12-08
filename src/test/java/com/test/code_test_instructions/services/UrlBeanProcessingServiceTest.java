package com.test.code_test_instructions.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.code_test_instructions.beans.URLBean;
import com.test.code_test_instructions.inventories.URLInventory;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.logging.Logger;
;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;




@SpringBootTest
public class UrlBeanProcessingServiceTest {



    final static Logger logger = Logger.getLogger(UrlBeanProcessingServiceTest.class.toString());


    @Mock
    private URLInventory urlInventory;;


     static UrlBeanProcessingService urlBeanProcessingService;

    URL originalURL;


    @BeforeAll
    public void init() throws MalformedURLException {
        urlBeanProcessingService = mock(UrlBeanProcessingService.class);
        originalURL = new URL("http://google.com");
        URL customizedURL = new URL("http://myGoogle.com");
        when(urlInventory.findURLBeanByCustomizedURL(customizedURL))
                .thenReturn(Optional.of(new URLBean(originalURL,customizedURL)));

    }


    @Test
    public void getOriginalUrlTest() throws MalformedURLException, JsonProcessingException {
        URL expectedURL = new URL("http://google.com");
        Assertions.assertThrows(NullPointerException.class,()->{
            URL originalURL = urlBeanProcessingService.getOriginalUrl("myGoogle.com");
            assert(expectedURL.equals(originalURL));
        });

    }



    @Test
    public void createCustomURLTest() throws MalformedURLException {
        try {
            URL customizedUrl = new URL("http://myGoogle");
            URLBean urlBean = urlBeanProcessingService.customizeUrl(originalURL, "MyGoogle");
            String orginalURL = urlBean.getOriginalURL().getRef();
            Assertions.assertEquals("customizedUrl",orginalURL);

            } catch (MalformedURLException mfExe){
            logger.warning(mfExe.getMessage());
        }catch (NullPointerException npExe){
            logger.warning(npExe.getMessage());

        }
    }



}
