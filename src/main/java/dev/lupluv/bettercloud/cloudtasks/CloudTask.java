package dev.lupluv.bettercloud.cloudtasks;

import dev.lupluv.bettercloud.enums.Tasks;

import java.util.List;
import java.util.UUID;

public class CloudTask {

    String name;
    Tasks.Provider provider;
    Tasks.Type type;
    long maxHeapMemory;
    boolean maintenance;
    List<UUID> whitelist;
    String javaCommand;

    public CloudTask(String name) {
        this.name = name;
    }

    public CloudTask(String name, Tasks.Provider provider, Tasks.Type type, long maxHeapMemory, boolean maintenance, List<UUID> whitelist, String javaCommand) {
        this.name = name;
        this.provider = provider;
        this.type = type;
        this.maxHeapMemory = maxHeapMemory;
        this.maintenance = maintenance;
        this.whitelist = whitelist;
        this.javaCommand = javaCommand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tasks.Provider getProvider() {
        return provider;
    }

    public void setProvider(Tasks.Provider provider) {
        this.provider = provider;
    }

    public Tasks.Type getType() {
        return type;
    }

    public void setType(Tasks.Type type) {
        this.type = type;
    }

    public long getMaxHeapMemory() {
        return maxHeapMemory;
    }

    public void setMaxHeapMemory(long maxHeapMemory) {
        this.maxHeapMemory = maxHeapMemory;
    }

    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    public List<UUID> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(List<UUID> whitelist) {
        this.whitelist = whitelist;
    }

    public void addToWhitelist(UUID uuid){
        this.whitelist.add(uuid);
    }

    public void removeFromWhitelist(UUID uuid){
        this.whitelist.remove(uuid);
    }

    public boolean isOnWhitelist(UUID uuid){
        return this.whitelist.contains(uuid);
    }

    public String getJavaCommand() {
        return javaCommand;
    }

    public void setJavaCommand(String javaCommand) {
        this.javaCommand = javaCommand;
    }

    public CloudTask load(){
        return this;
    }
}
