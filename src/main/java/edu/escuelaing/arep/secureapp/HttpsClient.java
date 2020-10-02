package edu.escuelaing.arep.secureapp;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpsClient {
    public static void init() {
        // Create a file and a password representation
        File trustStoreFile = new File("keystores/myTrustStore");
        char[] trustStorePassword = "pansito".toCharArray();
        // Load the trust store, the default type is "pkcs12", the alternative is "jks"
        KeyStore trustStore = null;
        TrustManagerFactory tmf = null;
        SSLContext sslContext = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
            // Get the singleton instance of the TrustManagerFactory
            tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            // Itit the TrustManagerFactory using the truststore object
            tmf.init(trustStore);
            //Set the default global SSLContext so all the connections will use it
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (IOException | CertificateException | KeyStoreException | KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
