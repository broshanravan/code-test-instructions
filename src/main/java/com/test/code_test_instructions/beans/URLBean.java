package com.test.code_test_instructions.beans;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.ConstructorParameters;
import java.net.URL;

/**
 * To present the url
 * and customized version
 */

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Document("URLs")
public class URLBean {

    @Id
    private String urlBeanId;

    @NotBlank(message = "Original URL is required")
    @NonNull
    private URL originalURL;

    @NotBlank(message = "Original URL is required")
    @NonNull
    private URL customizedURL;



}
