package github.scarsz.discordsrv.util;

import github.scarsz.discordsrv.DiscordSRV;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Made by Scarsz
 *
 * @in /dev/hell
 * @on 2/7/2017
 * @at 4:16 PM
 */
public class HttpUtil {

    public static String requestHttp(String requestUrl) {
        try {
            return IOUtils.toString(new URL(requestUrl), Charset.defaultCharset());
        } catch (IOException e) {
            DiscordSRV.error("Failed to fetch URL " + requestUrl + ": " + e.getLocalizedMessage());
            return "";
        }
    }

    public static void downloadFile(String requestUrl, File destination) {
        try {
            FileUtils.copyURLToFile(new URL(requestUrl), destination);
        } catch (IOException e) {
            DiscordSRV.error("Failed to download URL " + requestUrl + ": " + e.getLocalizedMessage());
        }
    }

}