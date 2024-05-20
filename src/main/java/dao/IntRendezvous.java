package dao;
import models.rendezvous;

import java.util.List;

public interface IntRendezvous {
    void prendre(rendezvous r);
    List<rendezvous> getall(String jour);
rendezvous getbydate(String date);
void delete(String cin);
void update(rendezvous rendezvous);
    List <String> getheurreserve(String jour);
    int getrdntoday();

List <String> getheur(String jour);
rendezvous getrdnbycin(String cin);







}
