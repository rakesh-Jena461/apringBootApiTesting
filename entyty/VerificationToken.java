package com.myproject.my_Domy_project.entyty;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.type.EntityType;

import java.util.Calendar;
import java.util.Date;

@Entity
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRE_TIME=10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expireTime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN")
    )
    private Client client;

    public VerificationToken(String token, Date expireTime, Client client) {
        super();
        this.token = token;
        this.expireTime = calculateExpireTime(EXPIRE_TIME);
        this.client = client;
    }

    public VerificationToken(String token){
        this.token=token;
        this.expireTime=calculateExpireTime(EXPIRE_TIME);
    }
    private Date calculateExpireTime(int expireTime){
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expireTime);
        return  new Date(calendar.getTime().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
