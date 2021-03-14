package no.hiof.svendap;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.svendap.controller.PlanetSystemController;
import no.hiof.svendap.model.PlanetSystem;
import no.hiof.svendap.repository.UniverseDataRepository;
import org.jetbrains.annotations.NotNull;


public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/", new Handler() {
            @Override
            public void handle(Context ctx) throws Exception {
                ctx.result("Hello World");
            }
        });


        app.get("/planet-system/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-system/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));


        UniverseDataRepository universeRepository = new UniverseDataRepository();
        PlanetSystemController planetSystemController = new PlanetSystemController(universeRepository);


        app.get("/api/planet-system/:planet-system-id", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                planetSystemController.getPlanetSystem(context);
            }
        });

        app.get("/api/planet-system/:planet-system-id/planets", new Handler() {
            @Override
            public void handle(@NotNull Context ctx) throws Exception {
                planetSystemController.getSpesificPlanetFromPlanetSystem(ctx);
            }
        });

    }

}
