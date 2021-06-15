package com.booth.web.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下拉框对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectItem {

    private String value;// 值
    private String text;// 文本
}
