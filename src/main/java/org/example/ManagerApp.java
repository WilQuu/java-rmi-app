package org.example;

import app.impl.ManagerImpl;
import bilboards.IManager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ManagerApp {
    public static void main(String[] args) throws RemoteException {
        IManager server = new ManagerImpl();
        IManager stub = (IManager) UnicastRemoteObject.exportObject(server, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("IManager", stub);
    }
}