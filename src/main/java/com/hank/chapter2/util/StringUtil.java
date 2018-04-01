package com.hank.chapter2.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
