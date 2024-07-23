package com.eoi.springBootDemo.sockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //  websockethandshake is the HTTP URL for the endpoint to which a WebSocket (or SockJS) client
    //  needs to connect for the WebSocket handshake.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websockethandshake");
    }

    //Configuraremos el servicio STOMP (Stomp es nuestro message broker)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //STOMP messages whose destination header begins with /mensajes
        // are routed to @MessageMapping methods in @Controller classes.
        config.setApplicationDestinationPrefixes("/app");

        // Use the built-in message broker for subscriptions
        // and broadcasting and route messages whose destination header
        // begins with /grupoX to the broker.

        config.enableSimpleBroker("/topic");

        //config.enableSimpleBroker("/grupo1", "/grupo2", "/grupo3", "/grupo4", "/grupo5", "/topic");
    }
}

