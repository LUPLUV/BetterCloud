package dev.lupluv.bettercloud.driver;

import dev.lupluv.bettercloud.cloudtasks.BetterCloudTasksProvider;
import dev.lupluv.bettercloud.cloudtasks.CloudTask;
import dev.lupluv.bettercloud.configuration.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BetterCloudDriver {

    private static BetterCloudDriver instance;

    public static BetterCloudDriver getInstance() {
        return instance;
    }

    BetterCloudTasksProvider tasksProvider;

    public BetterCloudDriver() {
        instance = this;
        tasksProvider = new BetterCloudTasksProvider(cloudTasksListToString(loadCloudTasks()));
    }

    public BetterCloudTasksProvider getTasksProvider() {
        return tasksProvider;
    }

    public void setTasksProvider(BetterCloudTasksProvider tasksProvider) {
        this.tasksProvider = tasksProvider;
    }

















    public List<CloudTask> loadCloudTasks(){
        List<CloudTask> l = new ArrayList<>();
        for (File file : Configuration.getConfiguration().getTasksFolder().listFiles()) {
            l.add(new CloudTask(file.getName()).load());
        }
        return l;
    }

    public List<String> cloudTasksListToString(List<CloudTask> l){
        List<String> sl = new ArrayList<>();
        for(CloudTask ct : l){
            sl.add(ct.getName());
        }
        return sl;
    }

}
