package org.example;
import java.sql.Connection;
import java.util.List;
public interface InterCRUD {
    public interface CRUDInterface {
        void Create(Connection connection, Client client);
        List<Client> Read(Connection connection);
        void Update(Connection connection,Client client, int id);
        void Delete(Connection connection, int id);
    }

}
