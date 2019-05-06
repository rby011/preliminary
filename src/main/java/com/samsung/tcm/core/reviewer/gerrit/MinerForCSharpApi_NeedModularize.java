package com.samsung.tcm.core.reviewer.gerrit;

import com.google.gerrit.extensions.api.GerritApi;
import com.google.gerrit.extensions.api.changes.Changes;
import com.google.gerrit.extensions.common.ChangeInfo;
import com.google.gerrit.extensions.common.CommentInfo;
import com.google.gerrit.extensions.common.FileInfo;
import com.google.gerrit.extensions.common.RevisionInfo;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.urswolfer.gerrit.client.rest.GerritAuthData;
import com.urswolfer.gerrit.client.rest.GerritRestApiFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.*;


public class MinerForCSharpApi_NeedModularize {
    static private boolean DEBUG = true;
    private static MinerForCSharpApi_NeedModularize miner = null;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												MINER INSTANCE POOL
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO : MINER INSTANCE POOL FOR PARALELL EXECUTION, CONNECTION URL VS MINER-INSTANCE KEY MAPPING
    private String connectionUrl;

    private MinerForCSharpApi_NeedModularize(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public static MinerForCSharpApi_NeedModularize minerInstance(String connectionUrl) {
        if (miner == null)
            miner = new MinerForCSharpApi_NeedModularize(connectionUrl);
        return miner;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //												MAIN LOGIC
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void mine(String project, String branch, String status) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Tizen C SHARP API");
        FileOutputStream fout = new FileOutputStream("./result.xlsx");

        int rowIdx = 0;

        // AUTHENTICATION WITH SAMHAK'S ACCOUNT
        GerritRestApiFactory gerritRestApiFactory = new GerritRestApiFactory();
        GerritAuthData.Basic authData = new GerritAuthData.Basic(connectionUrl, "j3s3h3", "angel1004");
        GerritApi gerritApi = gerritRestApiFactory.create(authData);

        // GET ENTRY POINT & MAKE QUERY
        Changes entryPoint = gerritApi.changes();
        String queryStr = makeQueryString(project, branch, status).trim();
        List<ChangeInfo> changes = entryPoint.query(queryStr).withLimit(1000).get();
        for (ChangeInfo changeInfo : changes) {
            changeInfo = entryPoint.id(changeInfo.id).get();

            // FOR EACH VALID CHANGES
            // IF THE CHANGE HAS REVISION HISTORY
            if (changeInfo.revisions == null) continue;
            for (Map.Entry<String, RevisionInfo> entry : changeInfo.revisions.entrySet()) {
                // GETTING THE LIST OF THE FILES PER REVISION
                Map<String, FileInfo> filesMap = entry.getValue().files;

                // JUST SKIP, IF NO FILE REVISED.
                if (filesMap == null) continue;

                // GETTING COMMENTS FOR EACH FILE
                String revisionId = entry.getKey();
                Map<String, List<CommentInfo>> comments = getCommentPerRevision(entryPoint, changeInfo, revisionId);

                // JUST SKIP, IF NO REVIEW COMMENT (* ASSUME THAT THIS IS INVALID REVIEW).
                //if(comments.size() == 0) continue;

                String validPrev = "", alternativeMsg = "", line = "";
                Set<String> cmtKeys = comments.keySet();
                for (String cmtKey : cmtKeys) {
                    List<CommentInfo> cmtList = comments.get(cmtKey);
                    Iterator iter = cmtList.iterator();
                    Cell cell = null;

                    while (iter.hasNext()) {
                        CommentInfo cmtInfo = (CommentInfo) iter.next();

                        Row row = sheet.createRow(rowIdx++);

                        int colIdx = 0;
                        cell = row.createCell(colIdx++);
                        cell.setCellValue(changeInfo.branch);
                        cell = row.createCell(colIdx++);
                        cell.setCellValue(changeInfo._number);

                        if (DEBUG)
                            line = changeInfo.branch + "|" + changeInfo._number + "|";

                        cell = row.createCell(colIdx++);
                        cell.setCellValue(cmtKey);

                        // BUILD META INFO FOR A COMMENT
                        cell = row.createCell(colIdx++);
                        if (((cmtInfo.message.toLowerCase().contains("same") || cmtInfo.message.toLowerCase().contains("similar")) && cmtInfo.message.toLowerCase().contains("above")) || cmtInfo.message.toLowerCase().trim().equals("same")) {
                            alternativeMsg = validPrev;
                            cell.setCellValue(alternativeMsg);
                            if (DEBUG)
                                line = line + cmtKey + "|" + cmtInfo.message + "(" + alternativeMsg + ")" + "|" + connectionUrl + "/" + changeInfo._number + "|";
                        } else {
                            validPrev = cmtInfo.message;
                            cell.setCellValue(validPrev);
                            if (DEBUG)
                                line = line + cmtKey + "|" + cmtInfo.message + "|" + connectionUrl + "/" + changeInfo._number + "|";
                        }
                        cell = row.createCell(colIdx++);
                        cell.setCellValue(connectionUrl + "/" + changeInfo._number);

                        // CATEGORIZE THE COMMENT
                        cell = row.createCell(colIdx++);
                        if (cmtInfo.message.toLowerCase().contains("done")) {
                            cell.setCellValue("ETC");
                            if (DEBUG)
                                line = line + "ETC";
                        } else if (cmtInfo.message.toLowerCase().contains("static")) {
                            cell.setCellValue("STATIC KEYWORD");
                            if (DEBUG)
                                line = line + "STATIC KEYWORD";
                        } else if (cmtInfo.message.toLowerCase().contains("assert")) {
                            cell.setCellValue("ASSERTION");
                            if (DEBUG)
                                line = line + "ASSERTION";
                        } else {
                            cell.setCellValue("TBD");
                            if (DEBUG)
                                line = line + "<TBD>";
                        }
                        if (DEBUG)
                            System.out.println("\t" + line);
                    }
                }
                if (DEBUG)
                    System.out.println("# TOTAL COUNT : " + rowIdx);
            }
//			Change newChange = getCommentsPerReview(gerritApi.changes(), c);
//			if(newChange == null) continue;
//			List<ReviewerInfo> revs = getReviewers(gerritApi.changes(), c);
//			store(c, newChange, revs, ++idx);
        }
        workbook.write(fout);
        workbook.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //									EXTRACT REQUIRED PARTIAL INFO FROM REST CALL
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, List<CommentInfo>> getCommentPerRevision(Changes changes, ChangeInfo c, String revisionId) {
        Map<String, List<CommentInfo>> comments = new HashMap<String, List<CommentInfo>>();
        int numTries = 1;
        while (true) {
            try {
                // Getting the list of comments for each file
                comments = getComments(changes, c, revisionId);
                break;
            } catch (com.urswolfer.gerrit.client.rest.http.HttpStatusException e) {
                System.out.println("Unable to get detail of change " + c.changeId);
                break;
            } catch (com.google.gerrit.extensions.restapi.RestApiException e) {
                if (numTries > 100) {
                    System.out.println("Too many tries! Quitting...");
                    System.out.println("Sort key of the last element: " + c._sortkey);
                    System.exit(-1);
                }
                numTries++;
                System.out.println("--------REQUEST FAILED: doing a new request. Request number " + numTries);
            }
        }
        return comments;
    }

    private String getAuthor(ChangeInfo c) {
        if (c.owner.name != null) {
            return formatString(c.owner.name);
        }
        return null;
    }

    private Map<String, List<CommentInfo>> getComments(Changes changes, ChangeInfo c, String revisionId)
            throws RestApiException {
        return changes.id(c._number).revision(revisionId).comments();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //									     UPDATE EXTRACTED INFO WHILE MINING
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private HashMap<String, Integer> updateComments(HashMap<String, Integer> totComments, HashMap<String, Integer> currentComments) {
        for (String file : currentComments.keySet()) {
            totComments.put(file, totComments.getOrDefault(file, 0) + currentComments.getOrDefault(file, 0));
        }
        return totComments;
    }

    private HashMap<String, String> updateBodyComments(HashMap<String, String> bodyComments, HashMap<String, String> currentBodyComments) {
        for (String file : currentBodyComments.keySet()) {
            bodyComments.put(file, bodyComments.getOrDefault(file, "") + "\n###NEWREVISION###\n" + currentBodyComments.getOrDefault(file, ""));
        }
        return bodyComments;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 												  STRING UTILITY
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String formatString(String toFormat) {
        if (toFormat == null)
            return "";
        return toFormat
                .replaceAll("\\'", "")
                .replaceAll("\"", "")
                .replaceAll("%", "")
                .replace("\\", "");
    }

    private boolean isValid(String str) {
        if (str == null || str.length() < 1) return false;
        return true;
    }

    private String makeQueryString(String project, String branch, String status) {
        if (!isValid(project)) return null;
        String ret = "project:" + project;

        if (isValid(branch)) {
            ret += "%20";
            ret += "branch:" + branch + " ";
        }
        if (isValid(status)) {
            ret += "%20";
            ret += "status:" + status;
        }

        return ret;
    }

}
