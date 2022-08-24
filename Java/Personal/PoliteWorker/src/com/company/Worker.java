package com.company;

public class Worker {
    
    private String name;
    private boolean active;
    
    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public synchronized void work(SharedResource sharedResource, Worker other) {
        while (active) {
            if (sharedResource.getOwner() != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {
                
                }
                continue;
            }
            
            if (other.isActive()) {
                System.out.println(getName() + ": give the resource to the worker " + other.getName());
                sharedResource.setOwner(other);
                continue;
            }
    
            System.out.println(getName() + ": working on the common resource");
            active = false;
        }
    }
}
