package com.samsung.tcm.schema;

import java.util.ArrayList;

/**
 * 프로젝트 정보를 표현하는 스키마.
 *
 * SCProject 스키마는 복수개의 서브 프로젝트를 가질 수 있다 예를 들어 Tizen 은 TCT, HAL, UNIT TEST 의 하위 프로젝트를 갖는다.
 * TCT 는 더 나아가 NATIVE, C#, WEB 으로 구성된다. 서브 프로젝트 간의 계층 관계는 현재는 플랫하게 표현하는 것으로 가정한다.
 */
public class SCProject {
    private String projectName;
    private ArrayList<SCSubProject> subProjects = new ArrayList<SCSubProject>();

    public SCProject(String projectName) {
        this.projectName = projectName;
    }

    public void addSubProject(SCSubProject subProject) {
        this.subProjects.add(subProject);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ArrayList<SCSubProject> getSubProjects() {
        return subProjects;
    }

    public void setSubProjects(ArrayList<SCSubProject> subProjects) {
        this.subProjects = subProjects;
    }
}
