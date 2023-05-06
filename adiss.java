import data.Data;
import java.util.ArrayList;
import java.util.List;
 // A class for the replica manager:
public class ReplicaManager {
    private List<Data> replicas;

    public ReplicaManager(int numberOfReplicas) {
        replicas = new ArrayList<Data>();
        for (int i = 0; i < numberOfReplicas; i++) {
            replicas.add(new Data());
        }
    }

    public void setValue(int replicaIndex, String value) {
        replicas.get(replicaIndex).setValue(value);
    }

    public String getValue(int replicaIndex) {
        return replicas.get(replicaIndex).getValue();
    }   
}

public class Client {
     private ReplicaManager replicaManager;

    public Client(int numberOfReplicas) {
        replicaManager = new ReplicaManager(numberOfReplicas);
    }

    public void setValue(int replicaIndex, String value) {
        replicaManager.setValue(replicaIndex, value);
    }

    public String getValue(int replicaIndex) {
        return replicaManager.getValue(replicaIndex);
    } 
    
    public static void main(String[] args) {
        Client client = new Client(3);

        client.setValue(0, "HELLO");
        client.setValue(1, "World");
        client.setValue(2, "!");
      
        System.out.println(client.getValue(0)); // Output: Hello
        System.out.println(client.getValue(1)); // Output: World
        System.out.println(client.getValue(2)); // Output: !
       // System.out.println(client.getValue(3)); 
    }
    
}