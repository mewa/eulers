package com.aisd.euler.components;

import javax.inject.Singleton;

import com.aisd.euler.interfaces.Application;
import com.aisd.euler.modules.ApplicationModule;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class }, dependencies = { LoggerComponent.class })
public interface ApplicationComponent {
	Application app();
}
