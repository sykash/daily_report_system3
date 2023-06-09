package actions.views;
import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Report;

public class ReportConverter {

    public static Report toModel(ReportView rv) {
        return new Report(
                rv.getId(),
                EmployeeConverter.toModel(rv.getEmployee()),
                rv.getReportDate(),
                rv.getTitle(),
                rv.getContent(),
                rv.getCreatedAt(),
                rv.getUpdatedAt(),
                rv.getGrantedFlag() == null
                ? null
                : rv.getGrantedFlag() == AttributeConst.GRANT_FLAG_TRUE.getIntegerValue()
                        ? JpaConst.REP_LEAD_TRUE
                        : JpaConst.REP_LEAD_FALSE);
    }


    public static ReportView toView(Report r) {

        if (r == null) {
            return null;
        }

        return new ReportView(
                r.getId(),
                EmployeeConverter.toView(r.getEmployee()),
                r.getReportDate(),
                r.getTitle(),
                r.getContent(),
                r.getCreatedAt(),
                r.getUpdatedAt(),
                r.getGrantedFlag() == null
                ? null
                : r.getGrantedFlag() == AttributeConst.GRANT_FLAG_TRUE.getIntegerValue()
                        ? JpaConst.REP_LEAD_TRUE
                        : JpaConst.REP_LEAD_FALSE);
    }


    public static List<ReportView> toViewList(List<Report> list) {
        List<ReportView> evs = new ArrayList<>();

        for (Report r : list) {
            evs.add(toView(r));
        }

        return evs;
    }

    public static void copyViewToModel(Report r, ReportView rv) {
        r.setId(rv.getId());
        r.setEmployee(EmployeeConverter.toModel(rv.getEmployee()));
        r.setReportDate(rv.getReportDate());
        r.setTitle(rv.getTitle());
        r.setContent(rv.getContent());
        r.setCreatedAt(rv.getCreatedAt());
        r.setUpdatedAt(rv.getUpdatedAt());
        r.setGrantedFlag(rv.getGrantedFlag());

    }

}