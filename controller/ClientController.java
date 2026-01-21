package com.myproject.my_Domy_project.controller;


import com.myproject.my_Domy_project.entyty.Client;
import com.myproject.my_Domy_project.event.event;
import com.myproject.my_Domy_project.model.ClientModel;
import com.myproject.my_Domy_project.services.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
   private ClientService clientService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register/user")
    public String saveClient(@RequestBody ClientModel clientModel, final HttpServletRequest request){
        Client client = clientService.saveClient(clientModel);
        publisher.publishEvent(new event(client,applicationUrl(request)));
        return "successful";
    }

    public String verifyRegistrationToken(@RequestParam("token") String token){
        String result = clientService.verifyRegistrationToken(token);
        if (result.equalsIgnoreCase("valid")){
            return "valid";
        }
        return "Bad user";
    }
    private String applicationUrl(HttpServletRequest request) {
        return "http//"+
      request.getServerName()+":"+
                request.getServerPort()+
                request.getContextPath();

    }


}
