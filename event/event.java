package com.myproject.my_Domy_project.event;

import com.myproject.my_Domy_project.entyty.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class event extends ApplicationEvent {

    private String applicationUrl;
    @Autowired
    private Client client;

  public event(Client client,String applicationUrl){
      super(client);
      this.applicationUrl=applicationUrl;
      this.client=client;
  }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
