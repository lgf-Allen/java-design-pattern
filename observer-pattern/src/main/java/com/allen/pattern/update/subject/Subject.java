package com.allen.pattern.update.subject;

import com.allen.pattern.update.observer.Observer;

/**
 * Created by meng on 2018/11/14.
 */
public interface Subject {

    void registryObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObervers();
}
