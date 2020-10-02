package edu.escuelaing.arep.securehost;

import static spark.Spark.*;

public class SecureHost {
    public static void main(String[] args) {
        secure("keystores/ecikeystore.p12", "pansito", "keystores/myTrustStoreLogin", "pansito");
        HttpsClient.init();
        port(getPort());
        get("/hello", (req, res) -> "CONECCIÓN CON OTRA API :D");
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }

}
