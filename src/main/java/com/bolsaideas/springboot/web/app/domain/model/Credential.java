package com.bolsaideas.springboot.web.app.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "credentials")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Credential implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    private String nit;
    private String regimen;
    private String token;
    private LocalDate tokenDate;
    private String user;
}

