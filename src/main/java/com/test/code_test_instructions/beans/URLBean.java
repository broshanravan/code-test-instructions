package com.test.code_test_instructions.beans;

import lombok.*;
import org.springframework.context.annotation.Bean;

import java.net.URL;

/**
 * To present the url
 * and customized version
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class URLBean {

    private URL originalURL;
    private URL customizedURL;
}
