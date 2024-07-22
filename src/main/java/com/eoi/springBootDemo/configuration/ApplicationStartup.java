package com.eoi.springBootDemo.configuration;

import com.eoi.springBootDemo.repositories.UsuarioRepository;
import com.eoi.springBootDemo.entities.UsuarioDemo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Constructor de la clase que recibe un {@link UsuarioRepository} para interactuar con la base de datos.
     *
     * @param userRepository el repositorio de usuarios que se utilizará para guardar los datos del usuario.
     */
    public ApplicationStartup(UsuarioRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        UsuarioDemo usuarioDemo = new UsuarioDemo(1L, "user1", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo1 = new UsuarioDemo(2L, "user2", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo2 = new UsuarioDemo(3L, "user3", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo3 = new UsuarioDemo(4L, "user4", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo4 = new UsuarioDemo(5L, "user5", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo5 = new UsuarioDemo(6L, "user6", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo6 = new UsuarioDemo(7L, "user7", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo7 = new UsuarioDemo(8L, "user8", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo8 = new UsuarioDemo(9L, "user9", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo9 = new UsuarioDemo(10L, "user10", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        UsuarioDemo usuarioDemo10 = new UsuarioDemo(11L, "user11", "pepe", "lopez", "mail@mail.com", bCryptPasswordEncoder.encode("password"), "admin");
        usuarioRepository.save(usuarioDemo);
        usuarioRepository.save(usuarioDemo1);
        usuarioRepository.save(usuarioDemo2);
        usuarioRepository.save(usuarioDemo3);
        usuarioRepository.save(usuarioDemo4);
        usuarioRepository.save(usuarioDemo5);
        usuarioRepository.save(usuarioDemo6);
        usuarioRepository.save(usuarioDemo7);
        usuarioRepository.save(usuarioDemo8);
        usuarioRepository.save(usuarioDemo9);
        usuarioRepository.save(usuarioDemo10);

        return;
    }
}
