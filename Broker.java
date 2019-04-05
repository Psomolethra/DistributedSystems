import java.util.*;

public final class  Broker {
    private Object mutex = new Object();
    static class CommonTopics{
        private CommonTopics(){}
        public static final String ON_CACHE_RESET = "onCacheReset";
    }
    private static Broker brokerInstance;
    private Broker(){

    }
    public static Broker getInstance(){
        if(null== brokerInstance){
            brokerInstance = new Broker();
        }
        return brokerInstance;
    }

    private Map<String, Set<Subscriber>> subscribers = new HashMap<>();

    public boolean deregister(String topic, Subscriber subscriber) {
        synchronized (mutex) {
            final Set<Subscriber> subs = this.subscribers.get(topic);
            return subs.remove(subscriber);
        }
    }

    public boolean register(String topic, Subscriber subscriber) {
        boolean returnVal;
        synchronized (mutex) {
            if (subscribers.containsKey(topic)) {
                returnVal = subscribers.get(topic).add(subscriber);
            } else {
                Set<Subscriber> sub = new HashSet<>();
                returnVal = sub.add(subscriber);
                subscribers.put(topic, sub);
            }
        }
        return returnVal;
    }

    public void sendMessage(String topic,Map map){
        synchronized (mutex) {
            final Set<Subscriber> sub = this.subscribers.get(topic);
            sub.parallelStream().forEach(subscriber -> subscriber.update(map));
        }
    }

}
//My Subscriber interface

/*import java.util.Map;

public interface Subscriber {
    public void update(Map map);
}*/