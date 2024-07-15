package com.eoi.springBootDemo;

import com.eoi.springBootDemo.entities.UsuarioDemo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Clase que se ejecuta al iniciar la aplicación. Implementa {@link ApplicationListener}
 * para escuchar el evento {@link ApplicationReadyEvent}, indicando que la aplicación
 * está lista para recibir solicitudes.
 *
 * <p>
 * Al implementar {@link ApplicationListener}, esta clase puede reaccionar a eventos específicos
 * del ciclo de vida de la aplicación. En este caso, estamos escuchando el evento
 * {@link ApplicationReadyEvent}, que se dispara cuando la aplicación ha completado el
 * proceso de arranque y está lista para servir peticiones.
 * </p>
 *
 * <p>
 * Esta clase se utiliza para inicializar datos en la base de datos, como la creación de un usuario
 * predeterminado al inicio de la aplicación.
 * </p>
 *
 */
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor de la clase que recibe un {@link UsuarioRepository} para interactuar con la base de datos.
     *
     * @param userRepository el repositorio de usuarios que se utilizará para guardar los datos del usuario.
     */
    public ApplicationStartup(UsuarioRepository userRepository) {
        this.usuarioRepository = userRepository;
    }

    /**
     * Este método se ejecuta tan pronto como sea posible para indicar que
     * la aplicación está lista para atender solicitudes.
     *
     * <p>
     * En este método se crea un usuario predeterminado y se guarda en la base de datos
     * utilizando el {@link UsuarioRepository}. Este enfoque permite inicializar datos críticos
     * o de prueba en la base de datos automáticamente cuando la aplicación se inicia por primera vez.
     * </p>
     *
     * @param event el evento que indica que la aplicación está lista.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        UsuarioDemo usuarioDemo = new UsuarioDemo(1L, "user", "pepe", "lopez", "mail@mail.com", "password", "admin");
        usuarioRepository.save(usuarioDemo);
        return;
    }
}
