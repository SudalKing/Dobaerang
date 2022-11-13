package com.jmcompany.dobaerang.global.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestInfo implements Serializable {

    private String remoteIp;
    private String sessionId;
    private LocalDateTime loginTime;

}
