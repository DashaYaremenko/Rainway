package org.example;

import lombok.Data;

@Data
public class Client {
private int ID;
private String LastName;
private String FirstName;
private String TypeDoc;
@Override
public String toString(){
    return  "ID: "+ ID+
            "\n Призвіще: " +LastName+
            "\n Ім'я: "+ FirstName+
            "\n Тип Документа: "+ TypeDoc;
    }
}
