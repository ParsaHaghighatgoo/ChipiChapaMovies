package imdb;

public class Report {
    int id;
    User user;
    String title;
    String about;
    ReportType reportType;

    public Report(int id, String title, String about, ReportType reportType,User user) {
        this.id = id;
        this.title = title;
        this.about = about;
        this.reportType = reportType;
        this.user = user;
    }

    public static ReportType createtype(int newt){
        if (newt == 1) return ReportType.SPAM;
        else if (newt == 2) return ReportType.VIOLENCE;
        else if (newt == 3) return ReportType.COPYRIGHT;
        else if (newt == 4) return ReportType.PERSONALDETAILS;
        else if (newt == 5) return ReportType.OTHERS;
        return ReportType.OTHERS;
    }
}

