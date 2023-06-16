public class SimpleTask extends Task {

    protected String title;

    protected SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    protected String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
        return false;
    }
}
