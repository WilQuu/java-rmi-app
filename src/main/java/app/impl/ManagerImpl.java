package app.impl;

import bilboards.IBillboard;
import bilboards.IManager;
import bilboards.Order;

import java.rmi.RemoteException;

public class ManagerImpl implements IManager{
    @Override
    public int bindBillboard(IBillboard billboard) throws RemoteException {
        return 0;
    }

    @Override
    public boolean unbindBillboard(int billboardId) throws RemoteException {
        return false;
    }

    @Override
    public boolean placeOrder(Order order) throws RemoteException {
        return false;
    }

    @Override
    public boolean withdrawOrder(int orderId) throws RemoteException {
        return false;
    }
}
