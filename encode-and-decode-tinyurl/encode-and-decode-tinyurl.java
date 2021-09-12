public class Codec {
    Map<String, String> map = new HashMap<>();
    int current = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        this.map.put("http://tinyurl.com/" + this.current, longUrl);
        this.current++;
        return "http://tinyurl.com/" + Integer.toString(this.current-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));