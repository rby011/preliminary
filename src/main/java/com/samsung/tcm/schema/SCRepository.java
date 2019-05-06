package com.samsung.tcm.schema;

import java.util.ArrayList;

/**
 * SubProject 는 복수개의 Repository 를 가질 수 있으며 단일 Repository 는 복수개의 Test File 을 가질 수 있다
 * <p>
 * Repository 별로 코드를 받아 올 수 있는 remote-url 과 branch 이름을 알고 있어야 하며,
 * SubProject 별로 다를 수 있다. 즉, 동일한 remote-url 이라 할지라도 branch 가 다르면
 * 이는 서로 다른 Repository 로 보아야 한다. 따라서 생성자로 받는 입력 인자가 remote-url 과 branch name 이다
 */
public class SCRepository {
    private String remoteUrl, branchName;
    private ArrayList<SCTestFile> testcaseFiles = new ArrayList<SCTestFile>();

    public SCRepository(String remoteUrl, String branchName) {
        this.remoteUrl = remoteUrl;
        this.branchName = branchName;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public ArrayList<SCTestFile> getTestcaseFiles() {
        return testcaseFiles;
    }

    public void addTestcaseFile(SCTestFile directory) {
        this.testcaseFiles.add(directory);
    }
}
