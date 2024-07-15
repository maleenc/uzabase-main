package com.uzabase.processor;

import java.util.List;

public interface BaseProcessor {
    List<String> transform(List<String> originalText, String type) throws Exception;
}