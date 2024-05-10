package dao;
import models.rendezvous;

import java.util.List;

public interface IntRendezvous {
    void prendre(rendezvous r);
    List<rendezvous> getall();
rendezvous getbydate(String date);
void delete(rendezvous rendezvous);
void update(rendezvous rendezvous);







}
