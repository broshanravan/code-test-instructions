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
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.util.Optional;

@Repository
public interface URLInventory extends MongoRepository<URLBean, String> {
    public Optional<URLBean> findURLBeanByCustomizedURL(URL customizedURL);


}
