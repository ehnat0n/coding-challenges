import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    private int id = 0;
    private final Map<Integer, String> idMap = new HashMap<>();
    private final String baseURL = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        idMap.put(++id, longUrl); //same URL may be linked to multiple tiny URLs, otherwise need to check entry set for matching values
        return baseURL + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int extractedId = Integer.parseInt(shortUrl.substring(baseURL.length()));
        return idMap.get(extractedId);
    }
}

