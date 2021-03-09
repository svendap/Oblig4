package no.hiof.svendap;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;


public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.get("/", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                ctx.result("Hello World");
            }
        });

    }

}
