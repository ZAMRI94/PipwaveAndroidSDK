package com.pipwave.android.sdk.pipwaveandroidsdk;

public class Config {
    public static final String API_STAGING_KEY = "qAJR3PljO72TuSfAy8euH8asfWXt3yUSapW7g0gi";
    public static final String API_STAGING_SECRET = "muwnTAuRfjSpNqyjmBSmUkXGDXut9iIarGRrrleU";

    public static final String SUCCESS_URL_PIPWAVE = "https://merchant.com/success.php";
    public static final String FAILURE_URL_PIPWAVE = "https://merchant.com/fail.php";
    public static final String CANCEL_URL_PIPWAVE = "https://merchant.com/notification.php";

    public static final String HEADERS = "<div class=\"header\">\n<a href=\"#default\" class=\"logo\">ShoppeCart</a></div>";

    public static final String STYLES =
            "<style>\n" +
            "* {box-sizing: border-box;}\n" +
            "\n" +
            "body { \n" +
            "  margin: 0;\n" +
            "  font-family: Arial;\n" +
            "}\n" +
            "\n" +
            ".header {\n" +
            "  overflow: hidden;\n" +
            "  background-color: #f1f1f1;\n" +
            "  padding: 20px 10px;\n" +
            "}\n" +
            "\n" +
            ".header a {\n" +
            "  float: left;\n" +
            "  color: black;\n" +
            "  text-align: center;\n" +
            "  padding: 12px;\n" +
            "  text-decoration: none;\n" +
            "  font-size: 18px; \n" +
            "  line-height: 25px;\n" +
            "  border-radius: 4px;\n" +
            "}\n" +
            "\n" +
            ".header a.logo {\n" +
            "  font-size: 25px;\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            "\n" +
            ".header a:hover {\n" +
            "  background-color: #ddd;\n" +
            "  color: black;\n" +
            "}\n" +
            "\n" +
            ".header a.active {\n" +
            "  background-color: dodgerblue;\n" +
            "  color: white;\n" +
            "}\n" +
            "\n" +
            ".header-right {\n" +
            "  float: right;\n" +
            "}\n" +
            "\n" +
            "@media screen and (max-width: 500px) {\n" +
            "  .header a {\n" +
            "    float: none;\n" +
            "    display: block;\n" +
            "    text-align: left;\n" +
            "  }\n" +
            "  .header-right {\n" +
            "    float: none;\n" +
            "  }\n" +
            "}\n" +
            "</style>\n" +
            "</head>";
}
