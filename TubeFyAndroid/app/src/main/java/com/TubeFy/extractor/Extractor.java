package com.TubeFy.extractor;


import com.TubeFy.YoutubeException;


public interface Extractor {

    void setRequestProperty(String key, String value);

    void setRetryOnFailure(int retryOnFailure);

    String extractYtPlayerConfig(String html) throws YoutubeException;

    String loadUrl(String url) throws YoutubeException;

}
