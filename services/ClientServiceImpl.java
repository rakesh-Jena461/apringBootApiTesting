package com.myproject.my_Domy_project.services;


import com.myproject.my_Domy_project.entyty.Client;
import com.myproject.my_Domy_project.entyty.VerificationToken;
import com.myproject.my_Domy_project.model.ClientModel;
import com.myproject.my_Domy_project.repository.ClientRepository;
import com.myproject.my_Domy_project.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Override
    public Client saveClient(ClientModel clientModel) {
        Client client = new Client();
        client.setFirstName(clientModel.getFirstName());
        client.setLastName(clientModel.getLastName());
        client.setEmail(clientModel.getEmail());
        client.setPassword(clientModel.getPassword());
        clientRepository.save(client);
        return client;
    }

    @Override
    public String verifyRegistrationToken(String token) {
        VerificationToken verificationToken =
                verificationTokenRepository.findByToken(token);
        if (verificationToken == null){
            return "token is empty";
        }
        Client client = verificationToken.getClient();
        Calendar calendar = Calendar.getInstance();
        if ((verificationToken.getExpireTime().getTime() - calendar.getTime().getTime()) <=0){
            verificationTokenRepository.delete(verificationToken);
            return "token was deleted";
        }
        client.setEnabled(true);
        clientRepository.save(client);
        return "validate successfully";

    }
}
