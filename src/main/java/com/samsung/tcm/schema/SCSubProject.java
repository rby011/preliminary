package com.samsung.tcm.schema;

import java.util.ArrayList;

/**
 * Project 는 여러개의 SubProject 로 구성되며 하나의 SubProject 는 복수개의 Repository 를 갖는다.
 * SubProject 의 식별자는 그 이름으로 한다. 해당 식별자의 유일성 보장 범위는 Project 내로 한정하고,
 * 혹시 SubProject 를 바로 접근하는 경우 접근하는 자가 이를 보장하여 사용해야 한다.
 */
public class SCSubProject {
    private String name;

    private ArrayList<SCRepository> repositories = new ArrayList<SCRepository>();

    public SCSubProject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRepository(SCRepository repository) {
        repositories.add(repository);
    }

    public ArrayList<SCRepository> getRepositories() {
        return repositories;
    }

}
