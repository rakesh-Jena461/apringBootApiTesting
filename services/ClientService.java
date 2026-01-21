package com.myproject.my_Domy_project.services;


import com.myproject.my_Domy_project.entyty.Client;
import com.myproject.my_Domy_project.model.ClientModel;

public interface ClientService {

    Client saveClient(ClientModel clientModel);

    String verifyRegistrationToken(String token);
}
