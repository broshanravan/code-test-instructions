package com.test.code_test_instructions.inventories;

/**
 * to manage and maintain a record of provided
 * and shortened.
 * The application will use a noSQl mongoDB to
 * record the data ion original and customized URLs
 * keeping customized URLs as a key to make sure that
 * they are not reused
 */

import com.test.code_test_instructions.beans.URLBean;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
@Repository
public class UrlInventory {


    /**
     * To retrieve a single URL bean
     * containing original and
     * customized
     * @return
     */
    public URLBean getURLBean(){
            return new URLBean();
     }

    public List<URLBean> getAllURLBeans(){

        List<URLBean> urlBeansList = new LinkedList<URLBean>();

        return urlBeansList;


    }

    /**
     * To save the details of a URL beans
     * after it has been created
     * @param urlBean
     */
    public void addURLBean(URLBean urlBean){

    }

    /**
     * To delete exiting Urls and
     * their costumized counterparts
     * @param urlBean
     */
    public void deleteRLBean(URLBean urlBean){

        }
}
