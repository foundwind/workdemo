import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloActor extends UntypedActor {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("HelloSystem");
        ActorRef helloActor = system.actorOf(Props.create(HelloActor.class));
        helloActor.tell("Actor", ActorRef.noSender());
    }

    @Override
    public void onReceive(Object message) {
        System.out.println("Hello " + message);
    }


}

