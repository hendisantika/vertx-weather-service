package id.my.hendisantika.weather_service;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.Dsl;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : weather-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/01/25
 * Time: 07.38
 * To change this template use File | Settings | File Templates.
 */
public class Main {
  public static class MyVerticle extends AbstractVerticle {
    private AsyncHttpClient asyncHttpClient;

    @Override
    public void start(Promise<Void> startPromise) {
      Router router = Router.router(vertx);

      router.get("/").handler(this::handleGetSummaryResource);
      router.get("/hour").handler(this::handleGetHourResource);

      // Initialize AsyncHttpClient
      AsyncHttpClientConfig config = Dsl.config().build();
      asyncHttpClient = Dsl.asyncHttpClient(config);

      vertx.createHttpServer()
        .requestHandler(router)
        .listen(8080, ar -> {
          if (ar.succeeded()) {
            System.out.println("Server started on port 8080");
            startPromise.complete();
          } else {
            System.out.println("Server start failed: " + ar.cause());
            startPromise.fail(ar.cause());
          }
        });
    }

    private void handleGetSummaryResource(RoutingContext routingContext) {
      Map<String, String> headers = routingContext.request().headers().entries().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

      Vertx vertx = routingContext.vertx();
      vertx.<String>executeBlocking(promise -> {
        try {
          String response = fetchSummaryApiData(headers).join(); // Use CompletableFuture's join
          promise.complete(response);
        } catch (Exception e) {
          promise.fail(e);
        }
      }, res -> {
//                if (res.succeeded()) {
        routingContext.response().setStatusCode(200).end(res.result());
//                } else {
//                    routingContext.response().setStatusCode(500).end("Failed to fetch data");
//                }
      });
    }

    private void handleGetHourResource(RoutingContext routingContext) {
      Map<String, String> headers = routingContext.request().headers().entries().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

      Vertx vertx = routingContext.vertx();
      vertx.<String>executeBlocking(promise -> {
        try {
          String response = fetchHourApiData(headers).join(); // Use CompletableFuture's join
          promise.complete(response);
        } catch (Exception e) {
          promise.fail(e);
        }
      }, res -> {
//                if (res.succeeded()) {
        routingContext.response().setStatusCode(200).end(res.result());
//                } else {
//                    routingContext.response().setStatusCode(500).end("Failed to fetch data");
//                }
      });
    }

    private CompletableFuture<String> fetchSummaryApiData(Map<String, String> headers) {
      CompletableFuture<String> future = new CompletableFuture<>();

      // Build the request with dynamic headers
      org.asynchttpclient.RequestBuilder requestBuilder = new org.asynchttpclient.RequestBuilder("GET")
        .setUrl("https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/summary/");
      headers.forEach(requestBuilder::addHeader);

      asyncHttpClient.executeRequest(requestBuilder.build())
        .toCompletableFuture()
        .thenAccept(response -> {
//                        if (response.getStatusCode() == 200) {
          future.complete(response.getResponseBody());
//                        } else {
//                            future.completeExceptionally(new RuntimeException("Failed to fetch summary data"));
//                        }
        }).exceptionally(ex -> {
          future.completeExceptionally(ex);
          return null;
        });

      return future;
    }

  }
}
