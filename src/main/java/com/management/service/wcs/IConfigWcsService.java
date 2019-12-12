package com.management.service.wcs;

import com.management.common.ServerResponse;

public interface IConfigWcsService {

    ServerResponse selectConfigWcs(String key);

    ServerResponse updateConfigWcs(String key, String value);
}
