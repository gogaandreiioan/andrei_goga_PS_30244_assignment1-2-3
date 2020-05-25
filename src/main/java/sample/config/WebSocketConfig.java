package sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker



/**
 * WebSocketConfig is the main entity we'll be using to . . .
 *
 * Please see the {@link com.baeldung.javadoc.AbstractWebSocketMessageBrokerConfigurer} class for true identity
 * @author Goga Andrei
 *
 */
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config)
    {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry)
    {
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
    }
}
