package com.nalbam.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PackageUtil {

    public static Map<String, String> getData(final Class<?> c) {
        final Map<String, String> data = new ConcurrentHashMap<>();
        final Package p = c.getPackage();
        if (p != null) {
            if (p.getImplementationTitle() != null) {
                data.put("artifactId", p.getImplementationTitle());
            } else if (p.getSpecificationTitle() != null) {
                data.put("artifactId", p.getSpecificationTitle());
            }
            if (p.getImplementationVersion() != null) {
                data.put("version", p.getImplementationVersion());
            } else if (p.getSpecificationVersion() != null) {
                data.put("version", p.getSpecificationVersion());
            }
        }
        data.put("address", AddressUtil.getAddress());
        return data;
    }

}
