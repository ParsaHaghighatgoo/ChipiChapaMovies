package imdb;

public class Report {
    int id;
    User user;
    String title;
    String about;
    ReportType reportType;
    Movie movie;

    public Report(int id, String title, String about, ReportType reportType, User user, Movie movie) {
        this.id = id;
        this.title = title;
        this.about = about;
        this.reportType = reportType;
        this.user = user;
        this.movie = movie;
    }

    public static ReportType createtype(int newt) {
        if (newt == 1) return ReportType.SPAM;
        else if (newt == 2) return ReportType.VIOLENCE;
        else if (newt == 3) return ReportType.COPYRIGHT;
        else if (newt == 4) return ReportType.PERSONALDETAILS;
        else if (newt == 5) return ReportType.OTHERS;
        return ReportType.OTHERS;
    }

    public static void createReport(Movie desiredMovie, User logedInUser) {
        System.out.println("enter new title for it:");
        String newtitle = main.scanner.nextLine();
        System.out.println("enter new about for it:");
        String newabout = main.scanner.nextLine();
        System.out.println("1.spam 2.violence 3.copyright 4.personal 5.other");
        int newtype = Integer.parseInt(main.scanner.nextLine());
        Report newreportadd = new Report(main.randomIdGen.nextInt(main.bound),
                newtitle, newabout, Report.createtype(newtype), logedInUser, desiredMovie);
        desiredMovie.reports.add(newreportadd);
        main.reportsDb.add(newreportadd);
        logedInUser.reports.add(newreportadd);
    }
}

