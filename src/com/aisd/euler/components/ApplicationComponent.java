package com.aisd.euler.components;

import javax.inject.Singleton;

import com.aisd.euler.Application;
import com.aisd.euler.modules.DebugLoggerModule;
import com.aisd.euler.modules.graph.GraphModule;

import dagger.Component;

@Singleton
@Component(modules = { DebugLoggerModule.class, GraphModule.class })
public interface ApplicationComponent {
	Application app();
}
