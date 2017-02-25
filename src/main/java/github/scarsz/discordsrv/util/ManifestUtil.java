package github.scarsz.discordsrv.util;

import github.scarsz.discordsrv.DiscordSRV;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class ManifestUtil {
    public static String getManifestInfo(String valueKey) {
        Enumeration resEnum;
        try {
            resEnum = DiscordSRV.getPlugin().getClass().getClassLoader().getResources(JarFile.MANIFEST_NAME);
            while (resEnum.hasMoreElements()) {
                try {
                    URL url = (URL)resEnum.nextElement();
                    InputStream is = url.openStream();
                    if (is != null) {
                        Manifest manifest = new Manifest(is);
                        Attributes mainAttribs = manifest.getMainAttributes();
                        String value = mainAttribs.getValue(valueKey);
                        if (value != null) {
                            return value;
                        }
                    }
                }
                catch (Exception e) {
                    // Silently ignore wrong manifests on classpath
                }
            }
        } catch (IOException e1) {
            // Silently ignore wrong manifests on classpath
        }
        return null;
    }
}