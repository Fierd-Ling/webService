package com.hand.ws.test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.hand.ws.Service;
import com.hand.ws.ServiceServiceLocator;

public class WeatherClient {
    public static void main(String[] args) throws RemoteException, ServiceException {
    	Service service = new ServiceServiceLocator().getServicePort();
        String result=service.queryWeather("衡阳");
        System.out.println(result);

    }
    }
