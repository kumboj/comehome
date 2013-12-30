package com.kum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kum.model.Location;
import com.kum.model.Device;
import com.kum.model.Function;


public class StoreData {

private static final String PERSISTENCE_UNIT_NAME = "JPAEclipseLinkDemoPU";

public StoreData() {

EntityManagerFactory objEntityManagerFactory = Persistence
.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
EntityManager objEntityManager = objEntityManagerFactory
.createEntityManager();

// Begin a new local transaction so that we can persist a new entity
objEntityManager.getTransaction().begin();

Function lichtAn = setFunction("Licht an");
objEntityManager.persist(lichtAn);

Function radioAn = setFunction("Radio an");
objEntityManager.persist(radioAn);

Device wohnzimmerBeleuchtung = new Device();
wohnzimmerBeleuchtung.setName("Wohnzimmerbeleuchtung");
wohnzimmerBeleuchtung.getFunctionList().add(lichtAn);
objEntityManager.persist(wohnzimmerBeleuchtung);

Device musikAnlage = new Device();
musikAnlage.setName("Musikanlage");
musikAnlage.getFunctionList().add(radioAn);
objEntityManager.persist(musikAnlage);

Location wohnort = new Location();
wohnort.setDescription("Neuburg an der Donau");
wohnort.getDevices().add(wohnzimmerBeleuchtung);
wohnort.getDevices().add(musikAnlage);
objEntityManager.persist(wohnort);

wohnzimmerBeleuchtung.setLocation(wohnort);
objEntityManager.persist(wohnzimmerBeleuchtung);

musikAnlage.setLocation(wohnort);
objEntityManager.persist(musikAnlage);

// Commit the transaction, which will cause the entity to be stored in
// the database
objEntityManager.getTransaction().commit();

objEntityManager.close();
objEntityManagerFactory.close();
}

private Function setFunction(String description) {
Function newFunction = new Function();
newFunction.setFunctionDescription(description);
return newFunction;
}


/**
* @param args
*/
public static void main(String[] args) {
new StoreData();
}
}