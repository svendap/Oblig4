package no.hiof.svendap;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.svendap.controller.PlanetController;
import no.hiof.svendap.controller.PlanetSystemController;
import no.hiof.svendap.repository.UniverseDataRepository;


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


        app.get("/planet-system", new VueComponent("planet-system-overview"));
        app.get("/planet-system/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-system/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));


        UniverseDataRepository universeRepository = new UniverseDataRepository();
        PlanetSystemController planetSystemController = new PlanetSystemController(universeRepository);
        PlanetController planetController = new PlanetController(universeRepository);



        app.get("/api/planet-system", planetSystemController::getAllPlanetSystems);

        app.get("/api/planet-system/:planet-system-id", planetSystemController::getPlanetSystem);

        app.get("/api/planet-system/:planet-system-id/planets", planetController::getAllPlanets);

        app.get("/api/planet-system/:planet-system-id/planets/:planet-id", planetController::getSpecificPlanetFromPlanetSystem);

    }

}
