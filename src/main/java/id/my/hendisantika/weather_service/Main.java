package id.my.hendisantika.weather_service;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.Dsl;

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
  }
}
