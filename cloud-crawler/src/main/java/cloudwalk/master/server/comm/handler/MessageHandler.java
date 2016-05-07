package cloudwalk.master.server.comm.handler;

import cloudwalk.master.server.processor.UpdateProcessor;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * Created by 1333907 on 2/18/16.
 * Handler for SimpleMasterHttpServer.
 */

public class MessageHandler implements HttpHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandler.class);

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        LOGGER.info("Get request from " + httpExchange.getRemoteAddress().toString());
        InputStream inputStream = httpExchange.getRequestBody();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
        String string;
        while ((string = reader.readLine()) != null) {
            LOGGER.info("Request from client: " + string);
            UpdateProcessor.process(string);
        }
        String responseMsg = "received\n";
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseMsg.getBytes().length);
        OutputStream out = httpExchange.getResponseBody();
        out.write(responseMsg.getBytes());
        out.flush();
        httpExchange.close();
    }
}
