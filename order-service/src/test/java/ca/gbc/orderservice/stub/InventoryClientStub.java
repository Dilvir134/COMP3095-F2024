package ca.gbc.orderservice.stub;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class InventoryClientStub {

    private static WireMockServer wireMockServer;

    // Method to start the WireMock server
    public static void startWireMockServer() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(WireMockConfiguration.options().dynamicPort());
            wireMockServer.start();

            configureFor("localhost", wireMockServer.port());
            System.setProperty("wiremock.server.port", String.valueOf(wireMockServer.port()));
        }
    }

    public static void stopWireMockServer() {
        if (wireMockServer != null) {
            wireMockServer.stop();
            wireMockServer = null;
        }
    }


    public static void stubInventoryCall(String skuCode, Integer quantity) {
        startWireMockServer();

        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true"))
        );
    }

}
