public class Visit {

    private String date;
    private String problem;
    private int cost;
    private boolean finished;

    public Visit(String date, String problem, int cost) {
        this.date = date;
        this.problem = problem;
        this.cost = cost;
        this.finished = false;
    }

    public void finishVisit() {
        finished = true;
        System.out.println("Visit finished. Cost: " + cost);
    }
}

