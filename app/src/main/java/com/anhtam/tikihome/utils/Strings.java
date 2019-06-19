package com.anhtam.tikihome.utils;

import java.util.ArrayList;

public class Strings {
    public static String separate(String src, int count, String separator) {
        int i = 0;
        ArrayList<String> tmp = new ArrayList<>();
        while (i < src.length()) {
            tmp.add(src.substring(i, Math.min(i + count, src.length())));
            i += count;
        }

        String str = "";
        for (int k = 0; k < tmp.size(); k++) {
            str += tmp.get(k) + (k != tmp.size() - 1 ? separator : "");
        }

        return str;
    }

    public static String moneyFormat(String str) {
        return new StringBuilder(Strings.separate(new StringBuilder(str).reverse().toString(), 3, ".")).reverse().toString();
    }
}
