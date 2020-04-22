package com.TubeFy.parser;


import com.alibaba.fastjson.JSONObject;
import com.TubeFy.YoutubeException;
import com.TubeFy.cipher.CipherFactory;
import com.TubeFy.extractor.Extractor;
import com.TubeFy.model.VideoDetails;
import com.TubeFy.model.formats.Format;

import java.io.IOException;
import java.util.List;

public interface Parser {

    Extractor getExtractor();

    CipherFactory getCipherFactory();

    JSONObject getPlayerConfig(String htmlUrl) throws IOException, YoutubeException;

    VideoDetails getVideoDetails(JSONObject config);

    String getJsUrl(JSONObject config) throws YoutubeException;

    List<Format> parseFormats(JSONObject json) throws YoutubeException;
}
