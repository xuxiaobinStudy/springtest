package com.service;

import java.io.InputStream;

public interface ResourceReader {
    InputStream getInputStream(String path);
}
