package com.uzabase.reader;

import com.uzabase.writer.CSVWriter;
import com.uzabase.writer.PrintWriter;

public class ReaderFactory {
    public static InputReader createReader(String type, String source) {
        switch (type.toLowerCase()) {
            case "rss":
                return new RssReader(source);
            case "csv":
                return new CsvReader(source);
            default:
                throw new IllegalArgumentException("Unknown input type: " + type);
        }
    }
}