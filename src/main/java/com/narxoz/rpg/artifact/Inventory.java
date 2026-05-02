package com.narxoz.rpg.artifact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
    private final List<Artifact> artifacts = new ArrayList<>();

    public void add(Artifact artifact) {
        artifacts.add(artifact);
    }

    public List<Artifact> getArtifacts() {
        return Collections.unmodifiableList(artifacts);
    }

    public int size() {
        return artifacts.size();
    }

    public void accept(ArtifactVisitor visitor) {
        for (Artifact artifact : artifacts) {
            artifact.accept(visitor);
        }
    }
}
