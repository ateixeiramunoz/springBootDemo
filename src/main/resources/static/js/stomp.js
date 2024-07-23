
document.addEventListener("DOMContentLoaded", function(event) {
    // Your code to run since DOM is loaded and ready
    const stompClient = new StompJs.Client({
        brokerURL: 'ws://localhost:8090/mensajes',
        onConnect: () => {
            client.subscribe('/topic/greetings', message =>
                console.log(`Received: ${message.body}`)
            );
            client.publish({ destination: '/topic/test01', body: 'First Message' });
        }
    });
});


