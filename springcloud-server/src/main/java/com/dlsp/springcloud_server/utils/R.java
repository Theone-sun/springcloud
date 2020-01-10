package com.dlsp.springcloud_server.utils;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class R<T> {

    private String codeMsg;
    private List<T> list;
}
