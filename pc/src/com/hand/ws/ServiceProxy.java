package com.hand.ws;

public class ServiceProxy implements com.hand.ws.Service {
  private String _endpoint = null;
  private com.hand.ws.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new com.hand.ws.ServiceServiceLocator()).getServicePort();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.hand.ws.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public java.lang.String queryWeather(java.lang.String arg0) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.queryWeather(arg0);
  }
  
  
}