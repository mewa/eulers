package com.aisd.euler.components;

import com.aisd.euler.interfaces.Representation;
import com.aisd.euler.models.DAGraph;
import com.aisd.euler.models.GraphMatrix;
import com.aisd.euler.modules.DAGraphModule;
import com.aisd.euler.modules.GraphMatrixRepresentationModule;

import dagger.Component;

@Component(modules = { DAGraphModule.class, GraphMatrixRepresentationModule.class })
public interface GraphComponent {
	DAGraph provideDAGraph();
	Representation provideRepresentation();
}
