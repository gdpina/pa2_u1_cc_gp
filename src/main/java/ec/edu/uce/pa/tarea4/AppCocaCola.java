package ec.edu.uce.pa.tarea4;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class AppCocaCola implements QuarkusApplication {

        @Inject
        private GestionPedido gestionPedido;

        public static void main(String[] args) {
                Quarkus.run(AppCocaCola.class, args);
        }

        @Override
        public int run(String... args) {

                System.out.println("Iniciando la aplicacion Quarkus...");

                PedidoBebida pedido = new PedidoBebida(
                                "PED-001",
                                "Gabriel Piña",
                                "gdpina@uce.edu.ec",
                                "Coca-Cola de 3 litros",
                                4,
                                3.00);

                this.gestionPedido.realizar(pedido);

                return 0;
        }

}
