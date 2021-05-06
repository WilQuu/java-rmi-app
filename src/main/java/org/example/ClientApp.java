package org.example;

import app.impl.ClientImpl;
import bilboards.IClient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientApp {
    public static void main(String[] args) throws RemoteException {
        IClient server = new ClientImpl();
        IClient stub = (IClient) UnicastRemoteObject.exportObject(server, 0);
        Registry registry = LocateRegistry.createRegistry(1100);
        registry.rebind("IClient", stub);
    }
}
